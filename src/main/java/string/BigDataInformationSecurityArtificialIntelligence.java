/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30957
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BigDataInformationSecurityArtificialIntelligence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        Course[] courses = Arrays.stream(bufferedReader.readLine().split(""))
                .map(Course::of)
                .toArray(Course[]::new);

        System.out.print(solution(courses));
    }

    private static String solution(Course[] courses) {
        Map<Course, Integer> countMap = new EnumMap<>(Course.class);
        for (Course course : Course.values()) {
            countMap.put(course, 0);
        }

        for (Course course : courses) {
            countMap.put(course, countMap.get(course) + 1);
        }

        int max = countMap.values().stream().max(Integer::compareTo).orElse(0);

        List<Course> topCourses = countMap.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparingInt(Course::getPriority))
                .collect(Collectors.toList());

        if (topCourses.size() == Course.values().length) {
            return "SCU";
        }

        return topCourses.stream()
                .map(Course::getInitial)
                .collect(Collectors.joining());
    }

    enum Course {
        BIGDATA("B", 1),
        INFORMATION_SECURITY("S", 2),
        AI("A", 3);

        private final String initial;
        private final int priority;

        Course(String initial, int priority) {
            this.initial = initial;
            this.priority = priority;
        }

        public static Course of(String initial) {
            return Arrays.stream(Course.values())
                    .filter(c -> c.initial.equals(initial))
                    .findFirst()
                    .orElseThrow();
        }

        public String getInitial() {
            return this.initial;
        }

        public int getPriority() {
            return this.priority;
        }
    }
}
