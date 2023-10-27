/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7785
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PeopleInCompany {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Set<String> people = new HashSet<>();

        while (n-- > 0) {
            String[] input = bufferedReader.readLine().split(" ");
            String name = input[0];
            String actionString = input[1];
            Action.valueOf(actionString.toUpperCase()).action(people, name);
        }

        printArray(people.toArray(new String[0]));
    }

    private static void printArray(String[] answer) {
        Arrays.sort(answer);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = answer.length - 1; i >= 0; i--) {
            stringBuilder.append(answer[i]).append("\n");
        }

        System.out.println(stringBuilder);
    }

    enum Action {
        ENTER {
            @Override
            void action(Set<String> people, String name) {
                people.add(name);
            }
        },
        LEAVE {
            @Override
            void action(Set<String> people, String name) {
                people.remove(name);
            }
        };

        abstract void action(Set<String> people, String name);
    }
}
