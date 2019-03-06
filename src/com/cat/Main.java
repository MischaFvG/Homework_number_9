package com.cat;

public class Main {

    public static void main(String[] args) {
        System.out.println("MyTreeMap");
        TreeMap treeMap = new MyTreeMap();
        treeMap.put(1, 2);
        treeMap.put(2, 3);
        treeMap.put(4, 56);
        treeMap.put(5, 23);
        treeMap.put(0, 23);
        System.out.println(treeMap.containsKey(0));
        treeMap.get(4, 56);
        treeMap.print();
        System.out.println(treeMap.containsValue(4, 56));
        treeMap.remove(2, 3);
        treeMap.print();
        System.out.println(treeMap.containsKey(2));
        System.out.println("MyTreeSet");
        TreeSet treeSet = new MyTreeSet();
        treeSet.put(7);
        treeSet.put(5);
        treeSet.put(2);
        treeSet.put(0);
        treeSet.put(10);
        treeSet.print();
        treeSet.get(10);
        treeSet.print();
        treeSet.remove(10);
        treeSet.print();
        System.out.println(treeSet.containsKey(10));
    }
}
