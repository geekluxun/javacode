package concurrency;
//: concurrency/SerialNumberGenerator.java

public class SerialNumberGenerator {
    //volatile 不能对递增操作产生原子性
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
} ///:~
