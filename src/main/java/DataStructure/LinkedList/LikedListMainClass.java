package DataStructure.LinkedList;

public class LikedListMainClass {
    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();

        singleLinkedList.add(5);
        singleLinkedList.add(9);
        singleLinkedList.remove();
        singleLinkedList.add(59);
        singleLinkedList.add(95);
        int removedData = singleLinkedList.remove(1);

        for (int i = 0; i < singleLinkedList.getSize(); i++) System.out.println(singleLinkedList.getData(i));
        System.out.println(singleLinkedList.indexOf(95));
        System.out.println(removedData);
    }
}