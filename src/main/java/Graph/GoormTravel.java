/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 3주차 문제 3
 * Cheat Level: 0
 * Algorithm: Graph
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GoormTravel {
    public static GraphList graphList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int islandLength = array[0];
        int bridgeLength = array[1];
        int maximumLength = array[2];

        graphList = new GraphList(islandLength);
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>();


        for (int i = 0; i <= islandLength; i++) visited.add(-1);
        for (int i = 0; i < bridgeLength; i++) {
            int[] bridge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graphList.put(bridge[0], bridge[1]);
        }
        solution(graphList, queue, visited);
        if (visited.get(islandLength) <= maximumLength && visited.get(islandLength) != -1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


    public static void solution(GraphList graphList, Queue<Integer> queue, List<Integer> visited) {
        visited.set(1, 0);
        queue.add(1);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            ArrayList<Integer> adjacentList = graphList.getNode(current);
            for (int next : adjacentList) {
                if (visited.get(next) == -1) {
                    queue.add(next);
                    visited.set(next, visited.get(current) + 1);
                }
            }
        }
    }
}

class GraphList {

    private final ArrayList<ArrayList<Integer>> graphList;

    public GraphList(int initSize) {
        this.graphList = new ArrayList<>();
        for (int i = 0; i < initSize + 1; i++) {
            this.graphList.add(new ArrayList<>());
        }
    }

    public ArrayList<Integer> getNode(int i) {
        return this.graphList.get(i);
    }

    public void put(int x, int y) {
        this.graphList.get(x).add(y);
        this.graphList.get(y).add(x);
    }
}