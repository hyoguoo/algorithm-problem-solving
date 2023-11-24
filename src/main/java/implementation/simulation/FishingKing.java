/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17143
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FishingKing {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int sharkCount = info[2];
        Shark[][] map = new Shark[n][m];
        for (int i = 0; i < sharkCount; i++) {
            int[] sharkInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[sharkInfo[0] - 1][sharkInfo[1] - 1] = new Shark(sharkInfo[0] - 1, sharkInfo[1] - 1, sharkInfo[2], sharkInfo[3], sharkInfo[4]);
        }

        System.out.println(solution(map));
    }

    private static int solution(Shark[][] map) {
        int result = 0;

        for (int m = 0; m < map[0].length; m++) {
            result += catchShark(map, m);
            moveSharks(map);
        }

        return result;
    }

    private static int catchShark(Shark[][] map, int m) {
        for (int n = 0; n < map.length; n++) {
            if (map[n][m] != null) {
                Shark shark = map[n][m];
                map[n][m] = null;
                return shark.size;
            }
        }

        return 0;
    }

    private static void moveSharks(Shark[][] map) {
        List<Shark> sharks = Arrays.stream(map)
                .flatMap(Arrays::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        for (Shark shark : sharks) {
            map[shark.n][shark.m] = null;
            shark.move(map.length, map[0].length);
        }

        for (Shark shark : sharks) {
            updateSharkPosition(map, shark);
        }
    }

    private static void updateSharkPosition(Shark[][] map, Shark shark) {
        Shark existShark = map[shark.n][shark.m];
        if (existShark != null) {
            if (map[shark.n][shark.m].size < shark.size) map[shark.n][shark.m] = shark;
        } else {
            map[shark.n][shark.m] = shark;
        }
    }

    enum Direction {
        UP(-1, 0, 1),
        DOWN(1, 0, 2),
        RIGHT(0, 1, 3),
        LEFT(0, -1, 4);

        final int n;
        final int m;
        final int value;

        Direction(int n, int m, int value) {
            this.n = n;
            this.m = m;
            this.value = value;
        }

        static Direction getDirection(int value) {
            return Arrays.stream(Direction.values())
                    .filter(direction -> direction.value == value)
                    .findFirst()
                    .orElseThrow();
        }

        Direction getOppositeDirection() {
            return Arrays.stream(Direction.values())
                    .filter(direction -> direction.value == (this.value % 2 == 0 ? this.value - 1 : this.value + 1))
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class Shark {
        int n;
        int m;
        int speed;
        Direction direction;
        int size;

        public Shark(int n, int m, int speed, int direction, int size) {
            this.n = n;
            this.m = m;
            this.speed = speed;
            this.direction = Direction.getDirection(direction);
            this.size = size;
        }

        public void move(int limitN, int limitM) {
            int moveCount = getMoveCount(limitN, limitM);

            for (int i = 0; i < moveCount; i++) {
                int nextN = this.n + this.direction.n;
                int nextM = this.m + this.direction.m;

                if (!isInBound(nextN, nextM, limitN, limitM)) {
                    this.direction = this.direction.getOppositeDirection();
                    nextN = this.n + this.direction.n;
                    nextM = this.m + this.direction.m;
                }

                this.n = nextN;
                this.m = nextM;
            }
        }

        private int getMoveCount(int limitN, int limitM) {
            if (this.direction == Direction.UP || this.direction == Direction.DOWN) {
                return this.speed % ((limitN - 1) * 2);
            } else {
                return this.speed % ((limitM - 1) * 2);
            }
        }

        private boolean isInBound(int n, int m, int limitN, int limitM) {
            return 0 <= n && n < limitN && 0 <= m && m < limitM;
        }
    }
}
