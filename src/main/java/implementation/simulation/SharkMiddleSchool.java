/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21609
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation / Graph / BFS
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SharkMiddleSchool {

    public static void main(String[] args) throws IOException {
        BlockSimulator blockSimulator = createBlockSimulator();

        System.out.print(blockSimulator.simulate());
    }

    private static BlockSimulator createBlockSimulator() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];

        int[][] map = new int[sizeN][sizeN];

        for (int n = 0; n < sizeN; n++) {
            map[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return new BlockSimulator(map);
    }

    enum Direction {
        UP(-1, 0), RIGHT(0, 1), DOWN(1, 0), LEFT(0, -1);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class BlockSimulator {

        private static final int EMPTY = -99;
        private static final int BLACK = -1;
        private static final int RAINBOW = 0;
        private static final int NORMAL_BLOCK_MINIMUM = 1;
        private static final int MINIMUM_BLOCK_COUNT = 2;
        private final int[][] map;

        public BlockSimulator(int[][] map) {
            this.map = map;
        }

        public int simulate() {
            int score = 0;

            while (true) {
                BlockGroup blockGroup = findMostBlockGroup();
                if (!blockGroup.getCount().isMoreThan(MINIMUM_BLOCK_COUNT)) {
                    break;
                }

                score += popBlock(blockGroup);
                gravity();
                rotate();
                gravity();
            }

            return score;
        }

        private int popBlock(BlockGroup blockGroup) {
            removeBlockGroup(blockGroup.getCoordinateList());
            return (int) Math.pow(blockGroup.getCount().getTotalBlockCount(), 2);
        }

        private void gravity() {
            for (int m = 0; m < map[0].length; m++) {
                for (int n = map.length - 1; n >= 0; n--) {
                    if (map[n][m] == EMPTY || map[n][m] == BLACK) {
                        continue;
                    }

                    int value = map[n][m];
                    Coordinate coordinate = new Coordinate(n, m);

                    while (true) {
                        Coordinate next = coordinate.getNext(Direction.DOWN);
                        if (isOutBound(next) || map[next.n][next.m] != EMPTY) {
                            break;
                        }
                        map[next.n][next.m] = value;
                        map[coordinate.n][coordinate.m] = EMPTY;
                        coordinate = next;
                    }
                }
            }
        }

        private void removeBlockGroup(List<Coordinate> coordinateList) {
            coordinateList
                    .forEach(coordinate -> map[coordinate.n][coordinate.m] = EMPTY);
        }

        private BlockGroup findMostBlockGroup() {
            BlockGroup bestBlockGroup = new BlockGroup(NORMAL_BLOCK_MINIMUM - 1);

            boolean[][] normalBlockVisited = new boolean[map.length][map[0].length];

            for (int n = 0; n < map.length; n++) {
                for (int m = 0; m < map[n].length; m++) {
                    if (map[n][m] < NORMAL_BLOCK_MINIMUM || normalBlockVisited[n][m]) {
                        continue;
                    }

                    BlockGroup currentBlockGroup = findBlockGroup(new Coordinate(n, m), normalBlockVisited);
                    if (bestBlockGroup.getCount().isLessOrEqual(currentBlockGroup.getCount())) {
                        bestBlockGroup = currentBlockGroup;
                    }
                }
            }

            return bestBlockGroup;
        }

        private BlockGroup findBlockGroup(Coordinate start, boolean[][] normalBlockVisited) {
            boolean[][] visited = new boolean[map.length][map[0].length];
            Deque<Coordinate> deque = new ArrayDeque<>();
            deque.add(start);
            visited[start.n][start.m] = true;
            BlockGroup blockGroup = new BlockGroup(map[start.n][start.m]);

            while (!deque.isEmpty()) {
                Coordinate current = deque.poll();

                if (map[current.n][current.m] == RAINBOW) {
                    blockGroup.getCount().addRainbowBlockCount();
                } else if (map[current.n][current.m] == map[start.n][start.m]) {
                    normalBlockVisited[current.n][current.m] = true;
                    blockGroup.getCount().addNormalBlockCount();
                }

                blockGroup.addCoordinate(current);

                for (Direction direction : Direction.values()) {
                    Coordinate next = current.getNext(direction);
                    if (isOutBound(next) || visited[next.n][next.m]) {
                        continue;
                    }

                    if (map[next.n][next.m] == RAINBOW ||
                            blockGroup.isBlockValueEqual(map[next.n][next.m])) {
                        deque.add(next);
                        visited[next.n][next.m] = true;
                    }
                }
            }

            return blockGroup;
        }

        private boolean isOutBound(Coordinate coordinate) {
            return coordinate.n < 0 || coordinate.n >= map.length ||
                    coordinate.m < 0 || coordinate.m >= map[0].length;
        }

        private void rotate() {
            int[][] temp = new int[map.length][map.length];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    temp[i][j] = map[j][map.length - 1 - i];
                }
            }

            updateMap(temp);
        }

        private void updateMap(int[][] temp) {
            for (int i = 0; i < map.length; i++) {
                System.arraycopy(temp[i], 0, map[i], 0, map.length);
            }
        }
    }

    static class BlockGroup {

        private final Count count;
        private final int blockValue;
        private final List<Coordinate> coordinateList;

        public BlockGroup(int blockValue) {
            this.count = new Count();
            this.blockValue = blockValue;
            this.coordinateList = new ArrayList<>();
        }

        public boolean isBlockValueEqual(int blockValue) {
            return this.blockValue == blockValue;
        }

        public Count getCount() {
            return count;
        }

        public void addCoordinate(Coordinate coordinate) {
            coordinateList.add(coordinate);
        }

        public List<Coordinate> getCoordinateList() {
            return coordinateList;
        }
    }

    static class Count {

        private int normalBlockCount;
        private int rainbowBlockCount;

        public Count() {
            this.normalBlockCount = 0;
            this.rainbowBlockCount = 0;
        }

        public void addNormalBlockCount() {
            this.normalBlockCount++;
        }

        public void addRainbowBlockCount() {
            this.rainbowBlockCount++;
        }

        public boolean isLessOrEqual(Count count) {
            if (this.normalBlockCount + this.rainbowBlockCount
                    < count.normalBlockCount + count.rainbowBlockCount) {
                return true;
            }

            return this.normalBlockCount + this.rainbowBlockCount
                    == count.normalBlockCount + count.rainbowBlockCount
                    && this.rainbowBlockCount <= count.rainbowBlockCount;
        }

        public int getTotalBlockCount() {
            return this.normalBlockCount + this.rainbowBlockCount;
        }

        public boolean isMoreThan(int n) {
            return this.normalBlockCount + this.rainbowBlockCount >= n;
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Coordinate getNext(Direction direction) {
            return new Coordinate(n + direction.n, m + direction.m);
        }
    }
}
