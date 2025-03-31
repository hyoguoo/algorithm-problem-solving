/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2083
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RugbyClub {

    private static final int JUNIOR_MAX_AGE = 17;
    private static final int JUNIOR_MAX_WEIGHT = 80;
    private static final String END_SIGN = "# 0 0";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Member> memberList = new ArrayList<>();

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals(END_SIGN)) {
                break;
            }
            String[] info = input.split(" ");

            memberList.add(new Member(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2])));
        }

        System.out.print(solution(memberList));
    }

    private static String solution(List<Member> memberList) {
        return memberList.stream()
                .map(Member::toString)
                .collect(Collectors.joining("\n"));
    }

    enum Division {
        JUNIOR("Junior"),
        SENIOR("Senior");

        private final String name;

        Division(String name) {
            this.name = name;
        }

        public static Division of(int age, int weight) {
            return age > JUNIOR_MAX_AGE || weight >= JUNIOR_MAX_WEIGHT
                    ? SENIOR
                    : JUNIOR;
        }
    }

    static class Member {

        private final String name;
        private final int age;
        private final int weight;
        private final Division division;

        public Member(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.division = Division.of(this.age, this.weight);
        }

        @Override
        public String toString() {
            return String.format("%s %s", name, division.name);
        }
    }
}
