package generics;

//: generics/NonCovariantGenerics.java
// {CompileTimeError} (Won't compile)
public class NonCovariantGenerics {
    // Compile Error: incompatible types:
    /**
     * 此处编译不过
     */
    //List<Fruit> flist = new ArrayList<Apple>();
} ///:~
