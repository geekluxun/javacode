package concurrency;
//: concurrency/ExchangerDemo.java

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

import java.util.List;
import java.util.concurrent.*;

class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    ExchangerProducer(Exchanger<List<T>> exchg, Generator<T> gen, List<T> holder) {
        exchanger = exchg;
        generator = gen;
        this.holder = holder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                /** 生产出size个对象放在list中*/
                for (int i = 0; i < ExchangerDemo.size; i++)
                    holder.add(generator.next());
                // Exchange full for empty:
                /** 等待交换线程到交换点，否则一直阻塞 参数是交换的对象，返回值是从交换线程交换回的对象*/
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            // OK to terminate this way.
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
        exchanger = ex;
        this.holder = holder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                /** 等待交换线程到交换点，否则一直阻塞 参数是交换的对象，返回值是从交换线程交换回的对象*/
                holder = exchanger.exchange(holder);
                /** 消费交换回的对象*/
                for (T x : holder) {
                    value = x; // Fetch out value
                    holder.remove(x); // OK for CopyOnWriteArrayList
                }
            }
        } catch (InterruptedException e) {
            // OK to terminate this way.
        }
        System.out.println("Final value: " + value);
    }
}

public class ExchangerDemo {
    static int size = 10;
    static int delay = 5; // Seconds

    public static void main(String[] args) throws Exception {
        if (args.length > 0)
            size = new Integer(args[0]);
        if (args.length > 1)
            delay = new Integer(args[1]);

        ExecutorService exec = Executors.newCachedThreadPool();
        /** 两个线程通过xc关联，构成交换线程*/
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();

        List<Fat>
            producerList = new CopyOnWriteArrayList<Fat>(),
            consumerList = new CopyOnWriteArrayList<Fat>();

        exec.execute(new ExchangerProducer<Fat>(xc, BasicGenerator.create(Fat.class), producerList));

        exec.execute(new ExchangerConsumer<Fat>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
} /* Output: (Sample)
Final value: Fat id: 29999
*///:~
