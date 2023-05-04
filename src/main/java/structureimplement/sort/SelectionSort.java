package structureimplement.sort;

public class SelectionSort extends Util implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();

        for (int i = 0; i < result.length; i++) swap(result, i, findMinIndex(result, i));
        return result;
    }

    private int findMinIndex(int[] array, int start) {
        int minIndex = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) minIndex = i;
        }
        return minIndex;
    }
}
