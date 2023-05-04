/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2026
 * Cheat Level: 0
 * Algorithm: Backtracking
 */

/*
1. 현재 소풍 멤버들을 boolean 배열로 관리했을 때 시간 초과
2. List<Integer>로 관리했을 때 메모리 초과
3. 결정적으로 방문 할 필요가 없는 노드를 제외하고 탐색하면 시간 초과가 해결되면서 불필요한 호출이 줄어 메모리 초과도 해결
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Picnic {

    static List<Integer>[] relationList;
    static int TARGET_NUMBER, N;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println((-1));
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            List<Integer> picnicStudentList = new ArrayList<>();
            // TARGET_NUMBER - 1 : 자기 자신을 제외한 친구의 수보다 적다면 소풍을 가지 못하므로 탐색할 필요 없음
            if (relationList[i].size() < TARGET_NUMBER - 1) continue;
            picnicStudentList.add(i);
            backtracking(picnicStudentList, i);
        }
    }

    private static void backtracking(List<Integer> picnicStudentList, int currentRelationIndex) {
        if (picnicStudentList.size() == TARGET_NUMBER) {
            printAnswer(picnicStudentList);
            System.exit(0);
        }

        for (Integer to : relationList[currentRelationIndex]) {
            if (picnicStudentList.contains(to)) continue;
            if (!isAllMemberFriend(picnicStudentList, to)) continue;
            picnicStudentList.add(to);
            backtracking(picnicStudentList, to);
            picnicStudentList.remove(picnicStudentList.size() - 1);
        }
    }

    private static boolean isAllMemberFriend(List<Integer> picnicStudentList, int to) {
        for (Integer from : picnicStudentList) {
            if (!relationList[from].contains(to)) return false;
        }
        return true;
    }

    private static void printAnswer(List<Integer> picnicStudentList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer student : picnicStudentList) {
            stringBuilder.append(student).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TARGET_NUMBER = info[0];
        N = info[1];
        int length = info[2];
        relationList = new ArrayList[N + 1];
        for (int i = 0; i < relationList.length; i++) relationList[i] = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int[] relationInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = relationInfo[0];
            int to = relationInfo[1];
            relationList[from].add(to);
            relationList[to].add(from);
        }
        for (List<Integer> relationList : relationList) {
            Collections.sort(relationList);
        }
    }
}
