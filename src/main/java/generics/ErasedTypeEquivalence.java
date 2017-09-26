package generics;
//: generics/ErasedTypeEquivalence.java

import java.util.*;

public class ErasedTypeEquivalence {
    public static void main(String[] args) {

        /**
         * 类型擦除
         */
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
} /* Output:
true
*///:~
