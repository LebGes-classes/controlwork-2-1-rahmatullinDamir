package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.SizeLimitExceededException;

public class ArrayListRealisationTest {
    ArrayListRealisation list;
    int capacity;

    @BeforeEach
    void init() throws SizeLimitExceededException {
        capacity = 1;
        list = new ArrayListRealisation(capacity);
    }

    @Test
    void addToEndTestWithNormalCapacityTest() {
        list.add(12);
        list.add(12);
        list.add(12);
        Assertions.assertEquals(12, list.getElemFromIndex(0));
    }

    @Test
    void getElemFromIndexWithNull() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getElemFromIndex(-1));
    }
    @Test
    void getElemFromIndexNormal() throws SizeLimitExceededException {
        ArrayListRealisation<Integer> list = new ArrayListRealisation(16);
        list.add(12);
        Assertions.assertEquals(12, list.getElemFromIndex(0));
    }


    @Test
    void addToEndTestWithNullCapacityTest() {
        capacity = 0;
        Assertions.assertThrows(SizeLimitExceededException.class, () -> new ArrayListRealisation<>(capacity));
    }


    @Test
    void addToIndexTest() {
        list = new ArrayListRealisation();
        list.add(17,1);
        Assertions.assertEquals(1, list.getElemFromIndex(17));
    }
    @Test
    void addToIndexTestBiggerCapacity() {
        list = new ArrayListRealisation();
        list.add(17,1);
        Assertions.assertEquals(1, list.getElemFromIndex(17));
    }
    @Test
    void addToIndexTestBLowerThanNull() {
        list = new ArrayListRealisation();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(-11,1));
    }


    @Test
    void toStringTest() {
        list = new ArrayListRealisation();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals("1 2 3", list.toString());
    }

    @Test
    void removeTest() {
        list = new ArrayListRealisation();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.remove(1);
        Assertions.assertEquals(1 , list.getElemFromIndex(0));
    }
    @Test
    void removeTestIndexBound() {
        list = new ArrayListRealisation();
        list.add(1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void addForIndex() {
        list = new ArrayListRealisation();
        list.add(1,12);
        Assertions.assertEquals(12, list.getElemFromIndex(1));
    }
    @Test
    void addForArray() {
        list = new ArrayListRealisation();
        list.add(1);
        Assertions.assertEquals(1, list.getElemFromIndex(0));
    }


}
