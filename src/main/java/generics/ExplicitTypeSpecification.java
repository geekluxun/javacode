package generics;

//: generics/ExplicitTypeSpecification.java

import typeinfo.pets.*;

import java.util.*;

import net.mindview.util.*;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        /**
         * 显示的指明泛型类型，否则编译不过
         */
        f(New.<Person, List<Pet>>map());
    }
} ///:~
