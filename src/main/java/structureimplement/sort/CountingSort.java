package structureimplement.sort;

public class CountingSort {

    public int[] sort(int[] array) {
        int[] result = new int[array.length];
        // 효율적인 정렬을 위해 사용한 것이라면 배열의 범위(min~max)를 미리 알고있어야 한다.
        int max = getMax(array);
        int min = getMin(array);
        int size = max - min + 1;
        int[] count = new int[size];

        for (int number : array) count[number - min]++;
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];

        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            int index = --count[value - min];
            result[index] = value;
        }

        return result;
    }

    private int getMax(int[] array) {
        int max = array[0];
        for (int el : array) {
            if (el > max) max = el;
        }
        return max;
    }

    private int getMin(int[] array) {
        int min = array[0];
        for (int el : array) {
            if (el < min) min = el;
        }
        return min;
    }
}
