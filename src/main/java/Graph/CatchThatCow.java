package Graph;/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1697
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CatchThatCow {

    public static void main(String[] args) throws IOException {
        int[] numbers = Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = numbers[0];
        int end = numbers[1];
        System.out.println(solution(start, end));
    }

    private static int solution(int start, int end) {
        int[] visited = new int[100001];
        int[] queue = new int[100001];
        int front = 0;
        int rear = 0;
        queue[rear++] = start;
        visited[start] = 1;
        while (front < rear) {
            int current = queue[front++];
            if (current == end) return visited[current] - 1;
            if (current - 1 >= 0 && visited[current - 1] == 0) {
                queue[rear++] = current - 1;
                visited[current - 1] = visited[current] + 1;
            }
            if (current + 1 <= 100000 && visited[current + 1] == 0) {
                queue[rear++] = current + 1;
                visited[current + 1] = visited[current] + 1;
            }
            if (current * 2 <= 100000 && visited[current * 2] == 0) {
                queue[rear++] = current * 2;
                visited[current * 2] = visited[current] + 1;
            }
        }
        return -1;
    }
}
