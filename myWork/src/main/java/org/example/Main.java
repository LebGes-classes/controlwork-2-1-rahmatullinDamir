package org.example;

public class Main {
    public static void main(String[] args) {
        ArrayListRealisation<Integer> arr = new ArrayListRealisation<Integer>();
        arr.add(2);
        arr.add(2);
        arr.add(3232131);
        arr.add(2);
        System.out.println(arr);
        arr.remove(2);
        arr.isEmpty();
        arr.getElemFromIndex(1);
        System.out.println(arr);
    }
}
