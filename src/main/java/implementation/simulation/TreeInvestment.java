/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16235
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

/* Key Point *
문제의 지시대로 코드를 구현하면 크게 어려운 문제는 아니다.
하지만 시간복잡도 측면에서 문제가 발생하여 이에 주의를 하며 구현해야 한다.
나무 나이가 낮은 순으로 정렬이 되어 있어야하는 것이 핵심이다.
처음엔 ArrayList를 사용하여 봄 직전에 정렬을 하였으나 시간초과가 발생하였다.
이를 해결하기 위해 우선순위큐를 사용하였으나 오히려 삽입과 삭제 시 정렬이 발생하여 더 큰 시간초과가 발생하였다.
이를 해결하기 위해 Deque와 임시로 담아 둘 구조형 변수들을 사용하여 논리적으로 항상 정렬된 상태를 유지해 풀이할 수 있었다.
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeInvestment {

    final static int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    final static Deque<Tree> treeDeque = new ArrayDeque<>();
    final static Queue<Tree> deadTreeQueue = new LinkedList<>();
    static int N;
    static int[][] map;
    static int[][] FOODS;
    static int TREE_COUNT;
    static int TARGET_YEAR;

    public static void main(String[] args) throws IOException {
        init();
        simulation();

        System.out.println(treeDeque.size());
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Tree> treeList = new ArrayList<>();
        N = info[0];
        TREE_COUNT = info[1];
        TARGET_YEAR = info[2];

        map = new int[N][N];
        FOODS = new int[N][N];
        for (int i = 0; i < N; i++) {
            FOODS[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(map[i], 5);
        }
        for (int i = 0; i < TREE_COUNT; i++) {
            int[] treeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            treeList.add(new Tree(treeInfo[0] - 1, treeInfo[1] - 1, treeInfo[2]));
        }

        treeList.sort(Comparator.comparingInt(o -> o.age));
        treeDeque.addAll(treeList);
    }


    private static void simulation() {
        for (int year = 1; year <= TARGET_YEAR; year++) {
            spring();
            summer();
            fall();
            winter();
        }
    }

    private static void spring() {
        List<Tree> treeList = new ArrayList<>();
        while (!treeDeque.isEmpty()) {
            Tree tree = treeDeque.pollFirst();
            if (map[tree.x][tree.y] >= tree.age) {
                map[tree.x][tree.y] -= tree.age;
                tree.age++;
                treeList.add(tree);
            } else {
                deadTreeQueue.add(tree);
            }
        }

        treeDeque.addAll(treeList);
    }

    private static void summer() {
        while (!deadTreeQueue.isEmpty()) {
            Tree tree = deadTreeQueue.poll();
            map[tree.x][tree.y] += tree.age / 2;
        }
    }

    private static void fall() {
        List<Tree> babyTreeList = new ArrayList<>();
        List<Tree> existTreeList = new ArrayList<>();
        while (!treeDeque.isEmpty()) {
            Tree tree = treeDeque.pollFirst();
            if (tree.age % 5 == 0) {
                for (int[] direction : DIRECTIONS) {
                    int x = tree.x + direction[0];
                    int y = tree.y + direction[1];
                    if (x < 0 || x >= N || y < 0 || y >= N) continue;
                    babyTreeList.add(new Tree(x, y, 1));
                }
            }
            existTreeList.add(tree);
        }

        treeDeque.addAll(babyTreeList);
        treeDeque.addAll(existTreeList);
    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += FOODS[i][j];
            }
        }
    }

    static class Tree {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }
}
