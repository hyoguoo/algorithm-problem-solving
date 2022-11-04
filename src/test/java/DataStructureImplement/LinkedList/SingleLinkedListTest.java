package DataStructureImplement.LinkedList;

import DataStructureImplement.LinkedList.SingleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleLinkedListTest {

    SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
    final int[] dataList = {10, 20, 30};

    @BeforeEach
    void beforeEach() {
        singleLinkedList.clear();

        for (int i : dataList) {
            singleLinkedList.add(i);
        }
    }

    @Test
    void add() {
        int data = 59;
        singleLinkedList.add(data);
        Assertions.assertEquals(singleLinkedList.getData(dataList.length), data);
    }

    @Test
    void addWithIndex() {
        int data = 59;
        int index = 1;
        singleLinkedList.add(index, data);
        Assertions.assertEquals(singleLinkedList.getData(index), data);
    }

    @Test
    void remove() {
        int removedData = singleLinkedList.remove();
        Assertions.assertEquals(removedData, dataList[0]);
    }

    @Test
    void removeWithIndex() {
        int index = 1;
        int removedData = singleLinkedList.remove(index);
        Assertions.assertEquals(removedData, dataList[index]);
    }

    @Test
    void getSize() {
        Assertions.assertEquals(singleLinkedList.getSize(), 3);
    }

    @Test
    void getData() {
        int index = 2;
        int data = singleLinkedList.getData(index);
        Assertions.assertEquals(data, dataList[index]);
    }

    @Test
    void indexOf() {
        int index = 2;
        int listIndex = singleLinkedList.indexOf(dataList[index]);
        Assertions.assertEquals(listIndex, index);
    }

    @Test
    void clear() {
        singleLinkedList.clear();
        int size = singleLinkedList.getSize();
        Assertions.assertEquals(size, 0);
    }
}