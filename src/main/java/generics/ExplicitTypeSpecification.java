package generics;

//: generics/ExplicitTypeSpecification.java

import net.mindview.util.New;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

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
