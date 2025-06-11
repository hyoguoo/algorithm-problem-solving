/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32205
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SquareDreams {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int triangleCount = Integer.parseInt(bufferedReader.readLine());

        Triangle[] triangles = new Triangle[triangleCount];

        for (int i = 0; i < triangleCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            triangles[i] = new Triangle(info[0], info[1], info[2]);
        }

        System.out.print(solution(triangles) ? 1 : 0);
    }

    private static boolean solution(Triangle[] triangles) {
        Set<Integer> seenSides = new HashSet<>();

        for (Triangle triangle : triangles) {
            if (seenSides.contains(triangle.a) || seenSides.contains(triangle.b) || seenSides.contains(triangle.c)) {
                return true;
            }
            seenSides.add(triangle.a);
            seenSides.add(triangle.b);
            seenSides.add(triangle.c);
        }

        return false;
    }

    static class Triangle {

        private final int a;
        private final int b;
        private final int c;

        public Triangle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
