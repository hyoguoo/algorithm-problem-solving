/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12018
 * Cheat Level: 0
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class YonseiTOTO {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int subjectCount = info[0];
        int initMileage = info[1];
        Subject[] subjects = new Subject[subjectCount];

        for (int i = 0; i < subjectCount; i++) {
            int[] subjectInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int capacity = subjectInfo[1];
            int[] mileages = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            subjects[i] = new Subject(capacity, mileages);
        }

        System.out.print(solution(subjects, initMileage));
    }

    private static long solution(Subject[] subjects, int initMileage) {
        int[] requiredMileages = Arrays.stream(subjects)
                .mapToInt(Subject::getRequiredMileage)
                .sorted()
                .toArray();

        MileageCounter counter = new MileageCounter(initMileage);

        return Arrays.stream(requiredMileages)
                .filter(counter::canEnroll)
                .count();
    }

    static class Subject {

        private final int capacity;
        private final int[] mileages;

        public Subject(int capacity, int[] mileages) {
            this.capacity = capacity;
            this.mileages = mileages;
        }

        public int getRequiredMileage() {
            return Arrays.stream(mileages)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .skip(capacity - 1L)
                    .findFirst()
                    .orElse(1);
        }
    }

    static class MileageCounter {

        private int mileage;

        public MileageCounter(int mileage) {
            this.mileage = mileage;
        }

        public boolean canEnroll(int cost) {
            if (mileage >= cost) {
                mileage -= cost;
                return true;
            }
            return false;
        }
    }
}
