//: net/mindview/util/Generator.java
// A generic interface.
package net.mindview.util;

/**
 * 这是一个泛型接口,泛型也可以用接口
 *
 * @param <T>
 */
public interface Generator<T> {
    T next();
} ///:~
