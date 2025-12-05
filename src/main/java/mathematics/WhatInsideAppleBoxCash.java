/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 29724
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WhatInsideAppleBoxCash {

    private static final int APPLE_EDGE_LENGTH = 12;
    private static final int APPLE_WEIGHT = 500;
    private static final int APPLE_PRICE = 4_000;
    private static final int APPLE_BOX_WEIGHT = 1_000;

    private static final int BAEJU_COUNT_PER_BOX = 50;
    private static final int BAEJU_WEIGHT_PER_POUCH = 120;
    private static final int BAEJU_BOX_WEIGHT = BAEJU_COUNT_PER_BOX * BAEJU_WEIGHT_PER_POUCH;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int boxCount = Integer.parseInt(bufferedReader.readLine());
        Box[] boxes = new Box[boxCount];

        for (int i = 0; i < boxCount; i++) {
            String[] inputs = bufferedReader.readLine().split(" ");
            Type type = Type.fromCode(inputs[0]);
            int width = Integer.parseInt(inputs[1]);
            int height = Integer.parseInt(inputs[2]);
            int depth = Integer.parseInt(inputs[3]);
            boxes[i] = new Box(type, width, height, depth);
        }

        System.out.print(solution(boxes));
    }

    private static Result solution(Box[] boxes) {
        int totalWeight = 0;
        int totalAppleCount = 0;

        for (Box box : boxes) {
            int appleCountInBox = box.calculateAppleCount();
            totalAppleCount += appleCountInBox;
            totalWeight += box.calculateWeight(appleCountInBox);
        }

        int totalAppleValue = totalAppleCount * APPLE_PRICE;
        return new Result(totalWeight, totalAppleValue);
    }

    enum Type {
        APPLE("A"),
        BAE("B");

        private final String code;

        Type(String code) {
            this.code = code;
        }

        public static Type fromCode(String code) {
            return Arrays.stream(Type.values())
                    .filter(type -> type.code.equals(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    static class Box {

        private final Type type;
        private final int width;
        private final int height;
        private final int depth;

        public Box(Type type, int width, int height, int depth) {
            this.type = type;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        public int calculateAppleCount() {
            if (type != Type.APPLE) {
                return 0;
            }

            int applesAlongWidth = width / APPLE_EDGE_LENGTH;
            int applesAlongHeight = height / APPLE_EDGE_LENGTH;
            int applesAlongDepth = depth / APPLE_EDGE_LENGTH;

            return applesAlongWidth * applesAlongHeight * applesAlongDepth;
        }

        public int calculateWeight(int appleCountInBox) {
            if (type == Type.APPLE) {
                return APPLE_BOX_WEIGHT + appleCountInBox * APPLE_WEIGHT;
            }
            return BAEJU_BOX_WEIGHT;
        }
    }

    static class Result {

        private final int weight;
        private final int value;

        public Result(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return weight + "\n" + value;
        }
    }
}
