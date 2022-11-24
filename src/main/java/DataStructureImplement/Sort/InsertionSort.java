package DataStructureImplement.Sort;

public class InsertionSort extends Util implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();

        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < i; j++) {
                if (result[i] < result[j]) swap(result, i, j);
            }
        }
        return result;
    }
}
