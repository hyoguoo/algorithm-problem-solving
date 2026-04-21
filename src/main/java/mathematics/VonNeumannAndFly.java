/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14924
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VonNeumannAndFly {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        ProblemInput problemInput = new ProblemInput(
                Integer.parseInt(stringTokenizer.nextToken()),
                Integer.parseInt(stringTokenizer.nextToken()),
                Integer.parseInt(stringTokenizer.nextToken())
        );

        System.out.print(solution(problemInput));
    }

    private static int solution(ProblemInput problemInput) {
        int timeToCollision = problemInput.getDistance() / (2 * problemInput.getSpeed(Participant.TRAIN));
        return timeToCollision * problemInput.getSpeed(Participant.FLY);
    }

    enum Participant {
        TRAIN, FLY
    }

    private static class ProblemInput {
        private final int trainSpeed;
        private final int flySpeed;
        private final int distance;

        public ProblemInput(int trainSpeed, int flySpeed, int distance) {
            this.trainSpeed = trainSpeed;
            this.flySpeed = flySpeed;
            this.distance = distance;
        }

        public int getSpeed(Participant participant) {
            return participant == Participant.TRAIN ? trainSpeed : flySpeed;
        }

        public int getDistance() {
            return distance;
        }
    }
}
