/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9372
 * Cheat Level: 0
 * Algorithm: Graph
 */

package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlyingSafety {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bufferedReader.readLine());
        while (caseCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int vertexCount = info[0];
            int edgeCount = info[1];
            for (int i = 0; i < edgeCount; i++) bufferedReader.readLine();
            System.out.println(vertexCount - 1);
        }
    }
}
