/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1717
 * Cheat Level: 3
 * Algorithm: Union Find
 */

package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RepresentationOfSet {

    final static int CHECK = 1;
    final static int ADD = 0;
    final static int MAX_SET_SIZE = 1000000;
    final static int[] parents = new int[MAX_SET_SIZE + 1];
    static int SET_COUNT, COMMAND_COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        SET_COUNT = info[0];
        COMMAND_COUNT = info[1];
        for (int i = 0; i < parents.length; i++) parents[i] = i;

        System.out.println(solution(bufferedReader));
    }

    private static String solution(BufferedReader bufferedReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < COMMAND_COUNT; i++) {
            int[] command = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int commandType = command[0];
            int a = command[1];
            int b = command[2];
            if (commandType == CHECK) {
                stringBuilder.append(isEqualsSet(a, b) ? "YES" : "NO").append("\n");
            } else if (commandType == ADD){
                union(a, b);
            }
        }

        return stringBuilder.toString();
    }

    private static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA < parentB) parents[parentB] = parentA;
        else parents[parentA] = parentB;
    }

    private static boolean isEqualsSet(int setNumber, int element) {
        return findParent(setNumber) == findParent(element);
    }

    private static int findParent(int element) {
        if (parents[element] == element) return element;
        int parent = findParent(parents[element]);
        parents[element] = parent;
        return parent;
    }
}
