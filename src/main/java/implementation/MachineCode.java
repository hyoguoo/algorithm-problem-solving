/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2929
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MachineCode {

    private static final int ALIGNMENT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String input) {
        ExecutionContext context = new ExecutionContext();

        input.chars()
                .mapToObj(c -> (char) c)
                .forEach(context::consume);

        return context.getNopCount();
    }

    private static class ExecutionContext {

        private int position;
        private int nopCount;

        private void consume(char current) {
            if (Character.isUpperCase(current)) {
                int offset = position % ALIGNMENT;
                if (offset != 0) {
                    int toInsert = ALIGNMENT - offset;
                    nopCount += toInsert;
                    position += toInsert;
                }
            }
            position++;
        }

        private int getNopCount() {
            return nopCount;
        }
    }
}
