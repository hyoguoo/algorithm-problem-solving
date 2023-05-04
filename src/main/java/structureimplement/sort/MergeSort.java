package structureimplement.sort;

public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();

        mergeSort(result, 0, result.length - 1);
        return result;
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = getMid(start, end);
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[array.length];
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) temp[k++] = array[i++];
            else temp[k++] = array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= end) temp[k++] = array[j++];

        copyValue(array, start, end, temp);

    }

    private static void copyValue(int[] array, int start, int end, int[] temp) {
        if (end + 1 - start >= 0) System.arraycopy(temp, start, array, start, end + 1 - start);
    }

    private int getMid(int start, int end) {
        return (start + end) / 2;
    }
}
