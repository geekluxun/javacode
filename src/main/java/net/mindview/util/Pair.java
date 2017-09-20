//: net/mindview/util/Pair.java
package net.mindview.util;

public class Pair<K, V> {
    //只读
    public final K key;
    public final V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }
} ///:~
