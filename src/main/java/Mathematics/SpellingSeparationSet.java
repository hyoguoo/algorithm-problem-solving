/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 2주차 문제 2
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

public class SpellingSeparationSet {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        String[] inputString = bufferedReader.readLine().split("");

        System.out.println(solution(inputString));
    }

    public static int solution(String[] inputString) {
        Stack<String> stack = new Stack<>();
        int count = 0;
        for (String s : inputString) {
            if (stack.size() <= 0) {
                stack.push(s);
                count++;
            } else {
                String str = stack.pop();
                if (Objects.equals(str, s)) {
                    stack.push(s);
                } else {
                    stack.push(s);
                    count++;
                }
            }
        }
        return count;
    }
}
