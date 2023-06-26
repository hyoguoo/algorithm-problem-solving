/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1069
 * Cheat Level: 2
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Home {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double startX = info[0];
        double startY = info[1];
        double jumpDistance = info[2];
        double jumpRequireTime = info[3];
        System.out.println(getMinimumTime(startX, startY, jumpDistance, jumpRequireTime));
    }

    private static double getMinimumTime(double startX, double startY, double jumpDistance, double jumpRequireTime) {
        double euclideanDistance = getEuclideanDistance(startX, startY, 0, 0);

        int minJumpCount = (int) Math.floor(euclideanDistance / jumpDistance);
        int maxJumpCount = (int) Math.ceil(euclideanDistance / jumpDistance);

        // 점프 효율이 안 좋은 경우
        double v1 = jumpDistance / jumpRequireTime <= 1 ? euclideanDistance : Double.MAX_VALUE;
        // 점프 두 번의 길이 보다 짧은 경우 /\ 모양으로 점프
        double v2 = euclideanDistance <= jumpDistance * 2 ? jumpRequireTime * 2 : Double.MAX_VALUE;
        // 점프로 넘치지 않게 간 뒤 남은 거리를 걸어서 이동
        double v3 = euclideanDistance - jumpDistance * minJumpCount + minJumpCount * jumpRequireTime;
        // 점프로 한 번 더 넘치게 간 뒤 남은 거리를 걸어서 이동
        double v4 = jumpDistance * maxJumpCount - euclideanDistance + maxJumpCount * jumpRequireTime;
        // 점프를 두 번 이상 하는 경우 점프로만 이동
        double v5 = maxJumpCount > 1 ? maxJumpCount * jumpRequireTime : Double.MAX_VALUE;

        return Stream.of(v1, v2, v3, v4, v5).min(Double::compareTo).get();
    }

    private static double getEuclideanDistance(double startX, double startY, double endX, double endY) {
        return Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
    }
}
