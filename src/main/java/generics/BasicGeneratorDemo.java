package generics;
//: generics/BasicGeneratorDemo.java

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

public class BasicGeneratorDemo {
    public static void main(String[] args) {

        /**
         * 构造CountedObject对象
         * CountedObject需要提供默认构造器
         */
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);


        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
}


/* Output:
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
*///:~
