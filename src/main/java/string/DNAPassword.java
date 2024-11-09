/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12891
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.IntStream;

public class DNAPassword {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int passwordLength = info[1];

        String dnaSequence = bufferedReader.readLine();

        int[] needCountInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        EnumMap<DNA, Integer> requiredCounts = new EnumMap<>(DNA.class);

        int i = 0;
        for (DNA dnaType : DNA.values()) {
            requiredCounts.put(dnaType, needCountInfo[i++]);
        }

        System.out.print(solution(dnaSequence, passwordLength, requiredCounts));
    }

    private static long solution(String dnaSequence, int passwordLength, EnumMap<DNA, Integer> requiredCounts) {
        EnumMap<DNA, Integer> currentCounts = new EnumMap<>(DNA.class);

        dnaSequence.chars()
                .limit(passwordLength)
                .mapToObj(c -> DNA.valueOf(String.valueOf((char) c)))
                .forEach(dna -> currentCounts.merge(dna, 1, Integer::sum));

        return IntStream.rangeClosed(0, dnaSequence.length() - passwordLength)
                .filter(i -> {
                    boolean isValid = isPasswordValid(requiredCounts, currentCounts);

                    if (i + passwordLength < dnaSequence.length()) {
                        DNA outgoing = DNA.valueOf(String.valueOf(dnaSequence.charAt(i)));
                        DNA incoming = DNA.valueOf(String.valueOf(dnaSequence.charAt(i + passwordLength)));

                        currentCounts.merge(outgoing, -1, Integer::sum);
                        currentCounts.merge(incoming, 1, Integer::sum);
                    }

                    return isValid;
                })
                .count();
    }

    private static boolean isPasswordValid(EnumMap<DNA, Integer> requiredCounts, EnumMap<DNA, Integer> currentCounts) {
        return requiredCounts.entrySet().stream()
                .allMatch(entry -> entry.getValue() <= currentCounts.getOrDefault(entry.getKey(), 0));
    }

    enum DNA {
        A, C, G, T
    }
}
