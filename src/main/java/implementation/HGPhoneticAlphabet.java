/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25594
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HGPhoneticAlphabet {

    private static final Map<Character, String> phoneticAlphabet;

    static {
        phoneticAlphabet = new HashMap<>();
        phoneticAlphabet.put('a', "aespa");
        phoneticAlphabet.put('b', "baekjoon");
        phoneticAlphabet.put('c', "cau");
        phoneticAlphabet.put('d', "debug");
        phoneticAlphabet.put('e', "edge");
        phoneticAlphabet.put('f', "firefox");
        phoneticAlphabet.put('g', "golang");
        phoneticAlphabet.put('h', "haegang");
        phoneticAlphabet.put('i', "iu");
        phoneticAlphabet.put('j', "java");
        phoneticAlphabet.put('k', "kotlin");
        phoneticAlphabet.put('l', "lol");
        phoneticAlphabet.put('m', "mips");
        phoneticAlphabet.put('n', "null");
        phoneticAlphabet.put('o', "os");
        phoneticAlphabet.put('p', "python");
        phoneticAlphabet.put('q', "query");
        phoneticAlphabet.put('r', "roka");
        phoneticAlphabet.put('s', "solvedac");
        phoneticAlphabet.put('t', "tod");
        phoneticAlphabet.put('u', "unix");
        phoneticAlphabet.put('v', "virus");
        phoneticAlphabet.put('w', "whale");
        phoneticAlphabet.put('x', "xcode");
        phoneticAlphabet.put('y', "yahoo");
        phoneticAlphabet.put('z', "zebra");
    }

    public static void main(String[] args) throws IOException {
        solution(new BufferedReader(new InputStreamReader(System.in)).readLine())
                .ifPresentOrElse(
                        value -> System.out.println("It's HG!\n" + value),
                        () -> System.out.println("ERROR!")
                );
    }

    private static Optional<String> solution(String input) {
        int index = 0;
        StringBuilder result = new StringBuilder();

        while (index < input.length()) {
            char key = input.charAt(index);
            String phonetic = phoneticAlphabet.get(key);
            if (input.startsWith(phonetic, index)) {
                result.append(key);
                index += phonetic.length();
            } else {
                return Optional.empty();
            }
        }

        return Optional.of(result.toString());
    }
}
