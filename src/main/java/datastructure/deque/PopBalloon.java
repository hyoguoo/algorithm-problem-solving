/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2346
 * Cheat Level: 0
 * Algorithm: Deque
 */

package datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PopBalloon {

    final static List<Balloon> ballonList = new ArrayList<>();
    final static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
        printAnswer();
    }

    private static void solution() {
        int index = 0;

        while (true) {
            Balloon removed = ballonList.remove(index);
            answer.add(removed.index);
            int move = removed.value;
            if (ballonList.isEmpty()) break;
            index = getNextIndex(index, move);
        }
    }

    private static int getNextIndex(int index, int move) {
        if (move > 0) return (index + move - 1) % ballonList.size();
        int nextIndex = index + move;
        while (nextIndex < 0) nextIndex = ballonList.size() + nextIndex;
        return nextIndex;
    }

    private static void printAnswer() {
        System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] values = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < values.length; i++) ballonList.add(new Balloon(i + 1, values[i]));
    }

    static class Balloon {
        int index;
        int value;

        public Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
