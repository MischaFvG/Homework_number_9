package com.cat;

public interface TreeMap {
    void clear();

    boolean containsKey(int key);

    boolean containsValue(int key, int value);

    void put(int key, int value);

    void get(int key, int value);

    void remove(int key, int value);

    boolean isEmpty();

    void print();

    void getSize();

}
