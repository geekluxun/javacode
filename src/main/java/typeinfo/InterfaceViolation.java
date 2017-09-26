//: typeinfo/InterfaceViolation.java
// Sneaking around an interface.
package typeinfo;

import typeinfo.interfacea.*;

class B3 implements A {
    public void f() {
    }

    public void g() {
    }
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B3();
        a.f();
        // a.g(); // Compile error
        System.out.println(a.getClass().getName());
        if (a instanceof B3) {
            B3 b = (B3) a;
            b.g();
        }
    }
} /* Output:
B
*///:~
