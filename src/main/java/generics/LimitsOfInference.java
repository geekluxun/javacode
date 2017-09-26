package generics;

//: generics/LimitsOfInference.java

import typeinfo.pets.*;

import java.util.*;

public class LimitsOfInference {
    static void
    f(Map<Person, List<? extends Pet>> petPeople) {}

    public static void main(String[] args) {
        /**
         *  泛型类型推断在传递参数时不适用
         */
        // f(New.map()); // Does not compile
    }
} ///:~
