package generics;
//: generics/HijackedInterface.java
// {CompileTimeError} (Won't compile)

class Cat implements Comparable<Cat> {
    // Error: Comparable cannot be inherited with
    // different arguments: <Cat> and <Pet>
    public int compareTo(Cat arg) {
        return 0;
    }
} ///:~
