/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17615
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectingBalls {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        Color[] colors = bufferedReader.readLine().chars()
                .mapToObj(c -> (char) c)
                .map(Color::of)
                .toArray(Color[]::new);

        System.out.print(solution(colors));
    }

    private static long solution(Color[] colors) {
        return Stream.of(Color.values())
                .flatMap(
                        color -> Stream.of(Direction.values())
                                .map(dir -> countGatheredBalls(colors, color, dir))
                )
                .min(Long::compareTo)
                .orElseThrow();
    }

    private static long countGatheredBalls(Color[] colors, Color baseColor, Direction direction) {
        return IntStream.of(direction.getIndices(colors.length))
                .dropWhile(i -> colors[i].isSameColor(baseColor))
                .filter(i -> colors[i].isSameColor(baseColor))
                .count();
    }

    enum Direction {
        LEFT(length -> IntStream.range(0, length).toArray()),
        RIGHT(length -> IntStream.range(0, length).map(i -> length - 1 - i).toArray());

        private final Function<Integer, int[]> indexMapper;

        Direction(Function<Integer, int[]> indexMapper) {
            this.indexMapper = indexMapper;
        }

        public int[] getIndices(int length) {
            return indexMapper.apply(length);
        }
    }

    enum Color {
        RED('R'),
        BLUE('B');

        private final char colorValue;

        Color(char colorValue) {
            this.colorValue = colorValue;
        }

        public static Color of(char colorValue) {
            return Arrays.stream(Color.values())
                    .filter(color -> color.colorValue == colorValue)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public boolean isSameColor(Color color) {
            return this == color;
        }
    }
}
