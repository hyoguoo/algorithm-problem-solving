/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5612
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EntranceAndExitOfTunnel {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int minutes = Integer.parseInt(bufferedReader.readLine());
        int initialCars = Integer.parseInt(bufferedReader.readLine());

        int[][] trafficLogs = new int[minutes][2];
        for (int i = 0; i < minutes; i++) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            trafficLogs[i][0] = Integer.parseInt(tokenizer.nextToken());
            trafficLogs[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        System.out.print(solution(initialCars, trafficLogs));
    }

    private static int solution(int initialCars, int[][] trafficLogs) {
        Tunnel tunnel = new Tunnel(initialCars);

        for (int[] log : trafficLogs) {
            tunnel.processMinute(log[0], log[1]);
            if (tunnel.isInvalid()) {
                return 0;
            }
        }

        return tunnel.getMaxCars();
    }

    static class Tunnel {

        private int currentCars;
        private int maxCars;
        private boolean invalidState;

        public Tunnel(int initialCars) {
            this.currentCars = initialCars;
            this.maxCars = initialCars;
            this.invalidState = false;
        }

        public void processMinute(int entrance, int exit) {
            currentCars += entrance;
            currentCars -= exit;

            if (currentCars < 0) {
                invalidState = true;
                return;
            }

            maxCars = Math.max(maxCars, currentCars);
        }

        public boolean isInvalid() {
            return invalidState;
        }

        public int getMaxCars() {
            return maxCars;
        }
    }
}
