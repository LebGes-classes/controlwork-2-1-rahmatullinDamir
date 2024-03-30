package org.example;

import javax.naming.SizeLimitExceededException;

public class ArrayListRealisation <T>
{
    int size;
    int capacity;
    T[] array;

    public  ArrayListRealisation() {
        capacity = 16;
        array = (T[]) new Object[capacity]; // из-за особенности Generics придется использовать cast к типу T generic из Object,
                                            // он возможен благодаря тому, что Object родитель любого объекта в джаве
    }
    public ArrayListRealisation(int capacity) throws SizeLimitExceededException{ // елси указали неверную вместимость необходимо
        if (capacity == 0 || capacity < 0) {                                      // кинуть ошибку SizeLimit
            throw new SizeLimitExceededException();
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void increaseCapacity() {  // метод для увеличения вместимости ArrayList'a
        capacity = capacity * 2;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void add(T elemToAdd) {
        if (size >= capacity) {
            increaseCapacity();
        }
        array[size] = elemToAdd;
        size++;
    }

    public void add(int index, T elemToAdd) {
        if (index < 0) {                          // если некорректный индекс ошибка IndexOutOfBoundsException
            throw new IndexOutOfBoundsException();
        }
        if(index >= capacity) {
            increaseCapacity();
        }
        array[capacity - 1] = elemToAdd; // вставляем элемент последним в массиве
        for(int i = 0; i < (capacity - index - 1); i++){ // двигаем элемент до нужного нам индекса
            T tmp = array[capacity - i - 1];               // делаем swap соседей
            array[capacity - i - 1] = array[capacity - i - 2];
            array[capacity - i - 2] = tmp;
        }
        size++;
    }

    public T getElemFromIndex(int index) {
        if(index >= capacity || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public boolean isEmpty() {
        return  array == null;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            for (int i = index; i < (size - 1); i++) {
                array[i] = array[i + 1];
            }
        }
        array[--size] = null; // Очистка последнего элемента
    }

    @Override
    public String toString() {
        String toStringCustom = "";
        for(int i = 0; i < size; i++){
            if (i != size - 1) {
                toStringCustom  += array[i] + " ";
            }
            else {
                toStringCustom += array[i];
            }
        }

        return toStringCustom;
    }
}
