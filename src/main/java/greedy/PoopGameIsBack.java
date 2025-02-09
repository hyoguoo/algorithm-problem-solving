/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30701
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PoopGameIsBack {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int roomCount = info[0];
        int power = info[1];
        List<Integer> monsterRoomList = new ArrayList<>();
        List<Integer> equipmentRoomList = new ArrayList<>();

        for (int i = 0; i < roomCount; i++) {
            int[] roomInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            switch (roomInfo[0]) {
                case 1:
                    monsterRoomList.add(roomInfo[1]);
                    break;
                case 2:
                    equipmentRoomList.add(roomInfo[1]);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        System.out.print(solution(monsterRoomList, equipmentRoomList, power));
    }

    private static int solution(List<Integer> monsterRoomList, List<Integer> equipmentRoomList, int power) {
        Collections.sort(monsterRoomList);
        Collections.sort(equipmentRoomList);
        Character character = new Character(power);
        int monsterIndex = 0;
        int equipmentIndex = 0;

        while (true) {
            if (monsterIndex < monsterRoomList.size() && character.killMonster(monsterRoomList.get(monsterIndex))) {
                monsterIndex++;
            } else if (equipmentIndex < equipmentRoomList.size()) {
                character.upgradeEquipment(equipmentRoomList.get(equipmentIndex));
                equipmentIndex++;
            } else {
                break;
            }
        }

        return character.roomCount;
    }

    static class Character {

        private long power;
        private int roomCount;

        public Character(int initialPower) {
            this.power = initialPower;
            this.roomCount = 0;
        }

        public boolean killMonster(int monsterPower) {
            if (power > monsterPower) {
                power += monsterPower;
                roomCount++;
                return true;
            }
            return false;
        }

        public void upgradeEquipment(int equipmentPower) {
            power *= equipmentPower;
            roomCount++;
        }
    }
}
