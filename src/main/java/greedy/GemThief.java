/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1202
 * Cheat Level: 2
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GemThief {

    final static List<Gem> gems = new ArrayList<>();
    final static TreeMap<Integer, Integer> bags = new TreeMap<>();
    static int GEM_COUNT, BAG_COUNT;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        long answer = 0;

        for (Gem gem : gems) {
            int weight = gem.weight;
            int value = gem.value;

            Integer bag = bags.ceilingKey(weight);
            if (bag != null) {
                int bagCount = bags.get(bag);
                if (bagCount > 1) bags.put(bag, bagCount - 1);
                else bags.remove(bag);
                answer += value;
            }
        }

        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        GEM_COUNT = info[0];
        BAG_COUNT = info[1];

        for (int i = 0; i < GEM_COUNT; i++) {
            int[] gemInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            gems.add(new Gem(gemInfo[0], gemInfo[1]));
        }
        Collections.sort(gems);

        for (int i = 0; i < BAG_COUNT; i++) {
            int bag = Integer.parseInt(bufferedReader.readLine());
            bags.put(bag, bags.getOrDefault(bag, 0) + 1);
        }
    }

    static class Gem implements Comparable<Gem> {
        int weight;
        int value;

        public Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Gem o) {
            return o.value - this.value;
        }
    }
}
