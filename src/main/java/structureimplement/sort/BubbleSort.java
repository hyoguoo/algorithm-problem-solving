package structureimplement.sort;

public class BubbleSort extends Util implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();

        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i] > result[j]) swap(result, i, j);
            }
        }
        return result;
    }
}
