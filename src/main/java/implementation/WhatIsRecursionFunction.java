/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17478
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhatIsRecursionFunction {

    static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        solution(Integer.parseInt(bufferedReader.readLine()));

        System.out.print(stringBuilder.toString().trim());
    }

    private static void solution(int depth) {
        appendString("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.", 0);
        recursion(depth, 0);
    }

    private static void recursion(int depth, int currentDepth) {
        appendString("\"재귀함수가 뭔가요?\"", currentDepth);
        if (currentDepth == depth) {
            appendString("\"재귀함수는 자기 자신을 호출하는 함수라네\"", currentDepth);
        } else {
            appendString("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.", currentDepth);
            appendString("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", currentDepth);
            appendString("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"", currentDepth);
            recursion(depth, currentDepth + 1);
        }
        appendString("라고 답변하였지.", currentDepth);
    }

    private static void appendString(String string, int depth) {
        stringBuilder.append("____".repeat(depth))
                .append(string)
                .append("\n");
    }
}
