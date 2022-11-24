package DataStructureImplement.Sort;

public class SortMain {

    public static void main(String[] args) {
        int[] array = {5, 4, 10, 7, 11, 13, 6, 9, 8};

        printArray(new SelectionSort().sort(array));
        printArray(new BubbleSort().sort(array));
        printArray(new InsertionSort().sort(array));
        printArray(new MergeSort().sort(array));
        printArray(new QuickSort().sort(array));
    }

    public static void printArray(int[] array) {
        for (int el : array) System.out.print(el + " ");
        System.out.println();
    }
}
