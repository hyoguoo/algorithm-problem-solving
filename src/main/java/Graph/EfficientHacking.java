/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1325
 * Cheat Level: 2
 * Algorithm: Graph
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EfficientHacking {

    public static List<Integer>[] ADJACENCY_LIST;
    public static int[] connectedCount;
    public static int VERTEX_COUNT, EDGE_COUNT;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        for (int i = 1; i <= VERTEX_COUNT; i++) bfs(i);

        ArrayList<Integer> answer = getAnswerList();
        printAnswer(answer);
    }

    public static void bfs(int startVertex) {
        boolean[] visited = new boolean[VERTEX_COUNT + 1];
        visited[startVertex] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : ADJACENCY_LIST[current]) {
                if (!visited[next]) {
                    connectedCount[next]++;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    private static ArrayList<Integer> getAnswerList() {
        ArrayList<Integer> answerList = new ArrayList<>();

        int max_value = 0;
        for (int i = 1; i <= VERTEX_COUNT; i++) {
            if (connectedCount[i] > max_value) {
                max_value = connectedCount[i];
                answerList.clear();
                answerList.add(i);
            } else if (connectedCount[i] == max_value) {
                answerList.add(i);
            }
        }

        return answerList;
    }

    private static void printAnswer(ArrayList<Integer> answerList) {
        for (int answer : answerList) System.out.print(answer + " ");
    }


    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VERTEX_COUNT = info[0];
        EDGE_COUNT = info[1];
        ADJACENCY_LIST = new ArrayList[VERTEX_COUNT + 1];
        for (int i = 0; i <= VERTEX_COUNT; i++) ADJACENCY_LIST[i] = new ArrayList<>();
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ADJACENCY_LIST[edge[1]].add(edge[0]);
        }

        connectedCount = new int[VERTEX_COUNT + 1];
    }
}