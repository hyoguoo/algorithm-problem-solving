/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20529
 * Cheat Level: 2
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class PsychologicalDistanceOfThreeClosestPeople {

    final static String[] MBTIS = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};
    final static int MBTI_COUNT = 16;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        for (int test = 0; test < testCaseCount; test++) {
            bufferedReader.readLine();
            String[] mbtis = bufferedReader.readLine().split(" ");
            System.out.println(solution(mbtis));
        }
    }

    private static int solution(String[] mbtis) {
        int[] mbtiCount = getMbtiCount(mbtis);
        int minDistance = Integer.MAX_VALUE;

        for (int a = 0; a < mbtiCount.length; a++) {
            if (mbtiCount[a] == 0) continue;
            String mbtiA = MBTIS[a];
            mbtiCount[a]--;
            for (int b = 0; b < mbtiCount.length; b++) {
                if (mbtiCount[b] == 0) continue;
                String mbtiB = MBTIS[b];
                mbtiCount[b]--;
                for (int c = 0; c < mbtiCount.length; c++) {
                    if (mbtiCount[c] == 0) continue;
                    String mbtiC = MBTIS[c];
                    minDistance = Math.min(minDistance, getDistanceOfThree(mbtiA, mbtiB, mbtiC));
                }
                mbtiCount[b]++;
            }
            mbtiCount[a]++;
        }

        return minDistance;
    }

    private static int[] getMbtiCount(String[] mbtis) {
        int[] mbtiCount = new int[MBTI_COUNT];

        for (String mbti : mbtis) {
            for (int i = 0; i < MBTI_COUNT; i++) {
                if (MBTIS[i].equals(mbti)) {
                    mbtiCount[i]++;
                    break;
                }
            }
        }

        return mbtiCount;
    }

    private static int getDistanceOfThree(String mbtiA, String mbtiB, String mbtiC) {
        int distanceAB = getDistance(mbtiA, mbtiB);
        int distanceAC = getDistance(mbtiA, mbtiC);
        int distanceBC = getDistance(mbtiB, mbtiC);

        return distanceAB + distanceAC + distanceBC;
    }

    private static int getDistance(String mbtiA, String mbtiB) {
        return (int) IntStream.range(0, mbtiA.length()).filter(i -> mbtiA.charAt(i) != mbtiB.charAt(i)).count();
    }
}
