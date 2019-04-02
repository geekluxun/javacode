package generics;
//: generics/InstantiateGenericType.java

import static net.mindview.util.Print.*;

/**
 * Class对象作为工厂对象
 * @param <T>
 */
class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee2 {
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee2> fe = new ClassAsFactory<Employee2>(Employee2.class);

        print("ClassAsFactory<Employee> succeeded");

        /**
         * 因为Integer没有提供无参构造函数，所以异常
         */
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
        } catch (Exception e) {
            print("ClassAsFactory<Integer> failed");
        }
    }
} /* Output:
ClassAsFactory<Employee> succeeded
ClassAsFactory<Integer> failed
*///:~
