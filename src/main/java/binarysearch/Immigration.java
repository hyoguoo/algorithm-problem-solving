/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 43238
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.util.Arrays;

public class Immigration {

    private static final long MAX_PEOPLE = 1_000_000_000L;
    private static final long MAX_TIME = 1_000_000_000L;
    private static final long MAX_PROCESSING_VALUE = MAX_PEOPLE * MAX_TIME;

    public static void main(String[] args) {
        Immigration immigration = new Immigration();
        long result = immigration.solution(6, new int[]{7, 10});
        long expectedResult = 28;
        assert result == expectedResult
                : String.format("Failed: result(%d) != expectedResult(%d)", result, expectedResult);
    }

    public long solution(int targetPeopleCount, int[] processTimes) {
        long answer = 0;
        long left = 0;
        long right = MAX_PROCESSING_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isProcessTargetPeople(targetPeopleCount, processTimes, mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean isProcessTargetPeople(int targetPeopleCount, int[] processTimes, long totalTime) {
        return calculateProcessCount(processTimes, totalTime) >= targetPeopleCount;
    }

    private long calculateProcessCount(int[] processTimes, long totalTime) {
        return Arrays.stream(processTimes)
                .mapToLong(processTime -> totalTime / processTime)
                .sum();
    }
}
