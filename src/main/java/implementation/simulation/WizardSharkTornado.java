/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20057
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WizardSharkTornado {

    static final int REPEAT_TIME = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(map));
    }

    private static int solution(int[][] map) {
        int currentN = map.length / 2;
        int currentM = map.length / 2;
        Direction direction = Direction.LEFT;
        int result = 0;
        int distance = 1;

        while (true) {
            for (int repeat = 0; repeat < REPEAT_TIME; repeat++) {
                for (int i = 0; i < distance; i++) {
                    currentN += direction.n;
                    currentM += direction.m;
                    if (!isInBound(currentN, currentM, map.length)) return result;
                    int totalAmount = map[currentN][currentM];

                    for (SPREAD spread : SPREAD.values()) {
                        int spreadN = currentN + spread.getCoordinate(direction).n;
                        int spreadM = currentM + spread.getCoordinate(direction).m;
                        int spreadAmount = (int) (totalAmount * spread.getPercent());
                        map[currentN][currentM] -= spreadAmount;
                        if (isInBound(spreadN, spreadM, map.length)) map[spreadN][spreadM] += spreadAmount;
                        else result += spreadAmount;
                    }

                    int alphaN = currentN + direction.n;
                    int alphaM = currentM + direction.m;
                    if (isInBound(alphaN, alphaM, map.length)) map[alphaN][alphaM] += map[currentN][currentM];
                    else result += map[currentN][currentM];
                }
                direction = getNextDirection(direction);
            }
            distance++;
        }
    }

    private static Direction getNextDirection(Direction direction) {
        switch (direction) {
            case LEFT:
                return Direction.DOWN;
            case DOWN:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.UP;
            case UP:
                return Direction.LEFT;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static boolean isInBound(int currentN, int currentM, int length) {
        return 0 <= currentN && currentN < length && 0 <= currentM && currentM < length;
    }

    enum SPREAD {
        E(0.07, 0, 1),
        W(0.07, 0, -1),
        EE(0.02, 0, 2),
        WW(0.02, 0, -2),
        NN(0.05, -2, 0),
        NE(0.1, -1, 1),
        NW(0.1, -1, -1),
        SW(0.01, 1, -1),
        SE(0.01, 1, 1);

        final double percent;
        final int n;
        final int m;

        SPREAD(double percent, int n, int m) {
            this.percent = percent;
            this.n = n;
            this.m = m;
        }

        public double getPercent() {
            return percent;
        }

        public Coordinate getCoordinate(Direction direction) {
            switch (direction) {
                case UP:
                    return new Coordinate(n, m);
                case DOWN:
                    return new Coordinate(-n, -m);
                case LEFT:
                    return new Coordinate(-m, n);
                case RIGHT:
                    return new Coordinate(m, -n);
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    enum Direction {
        LEFT(0, -1),
        RIGHT(0, 1),
        UP(-1, 0),
        DOWN(1, 0);

        final int n;
        final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
