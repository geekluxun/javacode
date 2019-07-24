//: concurrency/DaemonsDontRunFinally.java
// Daemon threads don't run the finally clause

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class ADaemon implements Runnable {
    public void run() {
        try {
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        } finally {
            //所有非后台线程结束后后台线程会被突然中止，所以此句话不一定能打印出来
            print("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();

        //TimeUnit.MILLISECONDS.sleep(1000);
    }
} /* Output:
Starting ADaemon
*///:~
