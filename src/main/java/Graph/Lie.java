/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1043
 * Cheat Level: 0
 * Algorithm: Graph
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lie {

    static final List<Integer> KNOWN_TRUTH_PEOPLE = new ArrayList<>();
    static final List<Integer> knownLieList = new ArrayList<>();
    static int[][] GRAPH;
    static List<Integer>[] PARTY_LIST;
    static int PEOPLE_COUNT;
    static int PARTY_COUNT;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        if (KNOWN_TRUTH_PEOPLE.isEmpty()) return PARTY_COUNT;
        bfs();
        return getCount();
    }

    private static int getCount() {
        int count = 0;
        for (List<Integer> party : PARTY_LIST) {
            boolean isLie = false;
            for (Integer person : party) {
                if (knownLieList.contains(person)) {
                    isLie = true;
                    break;
                }
            }
            if (!isLie) count++;
        }
        return count;
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>(KNOWN_TRUTH_PEOPLE);

        while (!queue.isEmpty()) {
            int person = queue.poll();
            knownLieList.add(person);
            for (int i = 1; i < GRAPH[person].length; i++) {
                if (GRAPH[person][i] == 1 && !knownLieList.contains(i)) {
                    queue.add(i);
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PEOPLE_COUNT = info[0];
        PARTY_COUNT = info[1];
        PARTY_LIST = new ArrayList[PARTY_COUNT];

        int[] truthInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (truthInfo[0] != 0) {
            for (int i = 1; i < truthInfo.length; i++) KNOWN_TRUTH_PEOPLE.add(truthInfo[i]);
        }

        for (int i = 0; i < PARTY_COUNT; i++) {
            PARTY_LIST[i] = new ArrayList<>();
            int[] partyInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < partyInfo.length; j++) PARTY_LIST[i].add(partyInfo[j]);
        }

        GRAPH = new int[PEOPLE_COUNT + 1][PEOPLE_COUNT + 1];
        for (int i = 0; i < PARTY_COUNT; i++) {
            for (int j = 0; j < PARTY_LIST[i].size() - 1; j++) {
                for (int k = j + 1; k < PARTY_LIST[i].size(); k++) {
                    GRAPH[PARTY_LIST[i].get(j)][PARTY_LIST[i].get(k)] = 1;
                    GRAPH[PARTY_LIST[i].get(k)][PARTY_LIST[i].get(j)] = 1;
                }
            }
        }
    }
}
