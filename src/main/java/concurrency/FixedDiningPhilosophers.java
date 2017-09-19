package concurrency;
//: concurrency/FixedDiningPhilosophers.java
// Dining philosophers without deadlock.
// {Args: 5 5 timeout}

import java.util.concurrent.*;

/**
 *  解决哲学家就餐死锁问题
 */
public class FixedDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 5;
        if (args.length > 0)
            ponder = Integer.parseInt(args[0]);
        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];

        for (int i = 0; i < size; i++)
            sticks[i] = new Chopstick();

        for (int i = 0; i < size; i++)
            if (i < (size - 1)){
                exec.execute(new Philosopher(sticks[i], sticks[i + 1], i, ponder));
            }
            else {
                //最后一个哲学家先拿起和放下左边的筷子 来破除循环加锁
                exec.execute(new Philosopher(sticks[0], sticks[i], i, ponder));
            }

        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
} /* (Execute to see output) *///:~
