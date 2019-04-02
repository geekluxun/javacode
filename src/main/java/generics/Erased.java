package generics;
//: generics/Erased.java
// {CompileTimeError} (Won't compile)

/**
 * 因为运行时的类型擦除，所有需要运行时知道确切的操作类型的操作都无法工作
 * @param <T>
 */
public class Erased<T> {
    private final int SIZE = 100;

    public static void f(Object arg) {
        // if(arg instanceof T) {}          // Error
        //T var = new T();                 // Error
        //T[] array = new T[SIZE];         // Error
        //T[] array = (T)new Object[SIZE]; // Unchecked warning
    }
} ///:~
