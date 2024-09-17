/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11557
 * Cheat Level: 0
 * Algorithm: Sort / Implementation
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class YangjojangOfTheYear {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int schoolCount = Integer.parseInt(bufferedReader.readLine());
            School[] schools = new School[schoolCount];

            for (int i = 0; i < schoolCount; i++) {
                String[] input = bufferedReader.readLine().split(" ");
                schools[i] = new School(input[0], Integer.parseInt(input[1]));
            }

            stringBuilder.append(solution(schools)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(School[] schools) {
        Arrays.sort(schools);

        return schools[0].name;
    }

    static class School implements Comparable<School> {

        private final String name;
        private final int alcohol;

        public School(String name, int alcohol) {
            this.name = name;
            this.alcohol = alcohol;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            School school = (School) o;
            return alcohol == school.alcohol && Objects.equals(name, school.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, alcohol);
        }

        @Override
        public int compareTo(School o) {
            return Integer.compare(o.alcohol, this.alcohol);
        }
    }
}
