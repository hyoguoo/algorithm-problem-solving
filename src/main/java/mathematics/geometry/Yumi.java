/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17286
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Yumi {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] startInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] aInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] bInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Coordinate start = new Coordinate(startInfo[0], startInfo[1]);
        List<Coordinate> destinationList = Arrays.asList(new Coordinate(aInfo[0], aInfo[1]), new Coordinate(bInfo[0], bInfo[1]), new Coordinate(cInfo[0], cInfo[1]));
        System.out.println((int) getMinDistance(start, destinationList));
    }

    private static double getMinDistance(Coordinate start, List<Coordinate> destinationList) {
        AtomicReference<Double> minDistance = new AtomicReference<>(Double.MAX_VALUE);

        getPermutations(new int[]{0, 1, 2}).forEach(permutation -> {
            double distance = 0;
            distance += getDistance(start, destinationList.get(permutation[0]));
            distance += getDistance(destinationList.get(permutation[0]), destinationList.get(permutation[1]));
            distance += getDistance(destinationList.get(permutation[1]), destinationList.get(permutation[2]));
            minDistance.set(Math.min(minDistance.get(), distance));
        });

        return minDistance.get();
    }

    private static double getDistance(Coordinate c1, Coordinate c2) {
        return Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2));
    }

    public static List<int[]> getPermutations(int[] nums) {
        List<int[]> permutations = new ArrayList<>();
        backtrack(permutations, new ArrayList<>(), nums);
        return permutations;
    }

    private static void backtrack(List<int[]> permutations, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            int[] permutation = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                permutation[i] = current.get(i);
            }
            permutations.add(permutation);
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) continue;
            current.add(num);
            backtrack(permutations, current, nums);
            current.remove(current.size() - 1);
        }
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
