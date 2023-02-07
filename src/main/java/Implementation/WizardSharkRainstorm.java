/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21610
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WizardSharkRainstorm {

    final static int[][] DIRECTIONS = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    final static int[] DIAGONAL = {2, 4, 6, 8};
    final static List<MoveInfo> moveInfoList = new ArrayList<>();
    final static List<Cloud> cloudList = new ArrayList<>();
    static int N, MOVE_INFO_COUNT;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] mapInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = mapInfo[0];
        MOVE_INFO_COUNT = mapInfo[1];
        map = new int[N][N];

        initCloud();
        setMap(bufferedReader);
        setMove(bufferedReader);

        System.out.println(solution());
    }

    private static int solution() {
        for (MoveInfo moveInfo : moveInfoList) {
            moveCloud(moveInfo);
            rain();
            makeCloud();
        }
        return getWaterCount();
    }

    private static int getWaterCount() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += map[i][j];
            }
        }
        return count;
    }

    private static void makeCloud() {
        List<Cloud> existCloudList = getExistCloudList();

        cloudList.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2 && !existCloudList.contains(new Cloud(i, j))) {
                    map[i][j] -= 2;
                    cloudList.add(new Cloud(i, j));
                }
            }
        }
    }

    private static List<Cloud> getExistCloudList() {
        List<Cloud> existCloudList = new ArrayList<>();

        for (Cloud cloud : cloudList) existCloudList.add(new Cloud(cloud.x, cloud.y));
        return existCloudList;
    }

    private static void rain() {
        for (Cloud cloud : cloudList) map[cloud.x][cloud.y]++;
        for (Cloud cloud : cloudList) map[cloud.x][cloud.y] += countWaterOnDiagonal(cloud);
    }

    private static int countWaterOnDiagonal(Cloud cloud) {
        int count = 0;

        for (int diagonal : DIAGONAL) {
            int[] direction = DIRECTIONS[diagonal];
            int x = cloud.x + direction[0];
            int y = cloud.y + direction[1];
            if (x < 0 || x >= N || y < 0 || y >= N) continue;
            if (map[x][y] > 0) count++;
        }

        return count;
    }

    private static void moveCloud(MoveInfo moveInfo) {
        for (Cloud cloud : cloudList) cloud.move(moveInfo);
    }

    private static void initCloud() {
        cloudList.add(new Cloud(N - 1, 0));
        cloudList.add(new Cloud(N - 1, 1));
        cloudList.add(new Cloud(N - 2, 0));
        cloudList.add(new Cloud(N - 2, 1));
    }

    private static void setMove(BufferedReader bufferedReader) throws IOException {
        for (int i = 0; i < MOVE_INFO_COUNT; i++) {
            int[] move = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            moveInfoList.add(new MoveInfo(move[0], move[1]));
        }
    }

    private static void setMap(BufferedReader bufferedReader) throws IOException {
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    static class MoveInfo {
        int[] direction;
        int distance;

        public MoveInfo(int direction, int distance) {
            this.direction = DIRECTIONS[direction];
            this.distance = distance;
        }
    }

    static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(MoveInfo moveInfo) {
            this.x += moveInfo.direction[0] * moveInfo.distance;
            this.y += moveInfo.direction[1] * moveInfo.distance;
            while (this.x < 0) this.x += N;
            while (this.y < 0) this.y += N;
            while (this.x >= N) this.x -= N;
            while (this.y >= N) this.y -= N;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Cloud) {
                Cloud cloud = (Cloud) obj;
                return this.x == cloud.x && this.y == cloud.y;
            }
            return false;
        }
    }
}
