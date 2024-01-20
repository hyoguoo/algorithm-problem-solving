/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5959
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CropCircles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());

        List<Circle> circles = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int[] circleInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            circles.add(new Circle(circleInfo[0], circleInfo[1], circleInfo[2]));
        }

        solution(circles);
    }

    private static void solution(List<Circle> circles) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < circles.size(); i++) {
            Circle circle = circles.get(i);
            int count = 0;
            for (int j = 0; j < circles.size(); j++) {
                if (i == j) continue;
                if (circle.isInside(circles.get(j))) count++;
            }
            stringBuilder.append(count).append("\n");
        }

        System.out.print(stringBuilder);
    }

    static class Circle {
        int x;
        int y;
        int r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        boolean isInside(Circle circle) {
            double distance = Math.sqrt(Math.pow((double) x - circle.x, 2) + Math.pow((double) y - circle.y, 2));
            return distance < r + circle.r;
        }
    }
}
