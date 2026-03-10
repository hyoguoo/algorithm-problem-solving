/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18113
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kimbap {

    private static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int kimbapCount = info[0];
        int cutLength = info[1];
        int requiredKimbapCount = info[2];
        int[] kimbapLengths = new int[kimbapCount];
        for (int i = 0; i < kimbapCount; i++) {
            kimbapLengths[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(solution(kimbapLengths, cutLength, requiredKimbapCount));
    }

    private static int solution(int[] kimbapLengths, int cutLength, int requiredKimbapCount) {
        int[] trimmedLengths = new int[kimbapLengths.length];
        int validCount = 0;
        int maxLen = 0;

        for (int len : kimbapLengths) {
            int trimmed = getTrimmedLength(len, cutLength);
            if (trimmed > 0) {
                trimmedLengths[validCount++] = trimmed;
                maxLen = Math.max(maxLen, trimmed);
            }
        }

        if (validCount == 0) return NOT_FOUND;

        return findMaxPieceLength(trimmedLengths, validCount, requiredKimbapCount, maxLen);
    }

    private static int getTrimmedLength(int length, int cutLength) {
        if (length >= 2 * cutLength) {
            return length - 2 * cutLength;
        } else if (length > cutLength) {
            return length - cutLength;
        }
        return 0;
    }

    private static int findMaxPieceLength(int[] trimmedLengths, int validCount, int requiredKimbapCount, int maxLen) {
        int low = 1;
        int high = maxLen;
        int result = NOT_FOUND;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (calculateTotalPieces(trimmedLengths, validCount, mid) >= requiredKimbapCount) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static long calculateTotalPieces(int[] trimmedLengths, int validCount, int pieceLength) {
        long total = 0;
        for (int i = 0; i < validCount; i++) {
            total += (long) trimmedLengths[i] / pieceLength;
        }
        return total;
    }
}
