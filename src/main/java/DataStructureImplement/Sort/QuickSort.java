package DataStructureImplement.Sort;

public class QuickSort extends Util implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();
        quickSort(result, 0, result.length - 1);
        return result;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) swap(array, ++i, j);
        }
        swap(array, ++i, end);
        return i;
    }
}
