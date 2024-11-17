/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 60059
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LockAndKey {

    private static final int ROTATE_COUNT = 4;

    public static void main(String[] args) {
        LockAndKey lockAndKey = new LockAndKey();
        boolean result = lockAndKey.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
                new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
        boolean expectedResult = true;
        assert result == expectedResult
                : String.format("Failed: result(%b) != expectedResult(%b)", result, expectedResult);
    }

    public boolean solution(int[][] key, int[][] lock) {
        int[][] extendedLock = extendLock(lock, key.length);

        for (int r = 0; r < ROTATE_COUNT; r++) {
            key = rotateKey(key);
            for (int x = 0; x < extendedLock.length - key.length + 1; x++) {
                for (int y = 0; y < extendedLock.length - key.length + 1; y++) {
                    if (isUnlock(extendedLock, key, x, y)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[][] extendLock(int[][] lock, int length) {
        int extendedLength = lock.length + 2 * length - 2;
        int[][] extendedLock = new int[extendedLength][extendedLength];

        IntStream.range(0, lock.length)
                .forEach(i -> IntStream.range(0, lock.length)
                        .forEach(j -> extendedLock[i + length - 1][j + length - 1] = lock[i][j]));

        return extendedLock;
    }

    private int[][] rotateKey(int[][] key) {
        int length = key.length;
        int[][] rotatedKey = new int[length][length];

        IntStream.range(0, length)
                .forEach(i -> IntStream.range(0, length)
                        .forEach(j -> rotatedKey[j][length - i - 1] = key[i][j]));

        return rotatedKey;
    }

    private boolean isUnlock(int[][] extendedLock, int[][] key, int x, int y) {
        int[][] copiedLock = Arrays.stream(extendedLock)
                .map(int[]::clone)
                .toArray(int[][]::new);

        int length = key.length;

        IntStream.range(0, length)
                .forEach(i -> IntStream.range(0, length)
                        .forEach(j -> copiedLock[x + i][y + j] += key[i][j]));

        return isAllOne(copiedLock, length);
    }

    private boolean isAllOne(int[][] copiedLock, int length) {
        return IntStream.range(length - 1, copiedLock.length - length + 1)
                .allMatch(i -> IntStream.range(length - 1, copiedLock.length - length + 1)
                        .allMatch(j -> copiedLock[i][j] == 1));
    }
}
