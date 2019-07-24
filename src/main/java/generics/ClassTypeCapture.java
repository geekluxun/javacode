//: generics/ClassTypeCapture.java
package generics;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
    Class<T> kind;

    /**
     * 编译器保证类型标签Class匹配泛型参数
     *
     * @param kind
     */
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    /**
     * 通过类的Class对象实现 instanceof
     *
     * @param arg
     * @return
     */
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
} /* Output:
true
true
false
true
*///:~
