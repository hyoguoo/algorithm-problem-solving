/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20006
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RankedPlayQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int playerCount = info[0];
        int roomLimit = info[1];

        Player[] players = new Player[playerCount];

        for (int index = 0; index < playerCount; index++) {
            String[] playerInfo = bufferedReader.readLine().split(" ");
            players[index] = new Player(Integer.parseInt(playerInfo[0]), playerInfo[1]);
        }

        System.out.print(solution(players, roomLimit));
    }

    private static String solution(Player[] players, int roomLimit) {
        List<Room> roomList = new ArrayList<>();

        Arrays.stream(players)
                .forEach(player -> addPlayer(roomList, player, roomLimit));

        return roomList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
    }

    private static void addPlayer(List<Room> roomList, Player player, int roomLimit) {
        Optional<Room> validRoom = roomList.stream()
                .filter(room -> room.isValid(player))
                .findFirst();
        validRoom.ifPresentOrElse(
                room -> room.addPlayer(player),
                () -> roomList.add(new Room(player, roomLimit)));
    }

    static class Player {

        private final int level;
        private final String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.level + " " + this.name;
        }
    }

    static class Room {

        private static final int BASE_DIFFERENT = 10;
        private final int roomLimit;
        private final int baseLevel;
        private final List<Player> playerList;

        public Room(Player player, int roomLimit) {
            this.playerList = new ArrayList<>();
            this.playerList.add(player);
            this.roomLimit = roomLimit;
            this.baseLevel = player.level;
        }

        public void addPlayer(Player player) {
            if (!isValid(player)) {
                return;
            }
            playerList.add(player);
        }

        public boolean isValid(Player player) {
            return this.isValidLevel(player.level) && !this.isRoomFull();
        }

        public boolean isRoomFull() {
            return this.playerList.size() == this.roomLimit;
        }

        public boolean isValidLevel(int level) {
            return this.baseLevel - BASE_DIFFERENT <= level &&
                    level <= this.baseLevel + BASE_DIFFERENT;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            if (isRoomFull()) {
                stringBuilder.append("Started!").append("\n");
            } else {
                stringBuilder.append("Waiting!").append("\n");
            }

            playerList.stream()
                    .sorted(Comparator.comparing(p -> p.name))
                    .forEach(player -> stringBuilder.append(player).append("\n"));

            return stringBuilder.toString().trim();
        }
    }
}
