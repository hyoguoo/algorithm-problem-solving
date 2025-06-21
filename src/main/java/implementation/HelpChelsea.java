/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11098
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class HelpChelsea {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int playerCount = Integer.parseInt(bufferedReader.readLine());
            Player[] players = new Player[playerCount];
            for (int i = 0; i < playerCount; i++) {
                String[] input = bufferedReader.readLine().split(" ");
                players[i] = new Player(input[1], Integer.parseInt(input[0]));
            }
            stringBuilder.append(solution(players)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Player solution(Player[] players) {
        return Arrays.stream(players)
                .max(Player::compareTo)
                .orElseThrow();
    }

    static class Player implements Comparable<Player> {

        private final String name;
        private final int price;

        public Player(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Player player = (Player) o;
            return price == player.price && Objects.equals(name, player.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }

        @Override
        public int compareTo(Player other) {
            return Integer.compare(this.price, other.price);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
