/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9322
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Encryption {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            bufferedReader.readLine();
            String[] firstPublicKey = bufferedReader.readLine().split(" ");
            String[] secondPublicKey = bufferedReader.readLine().split(" ");
            String[] passphrase = bufferedReader.readLine().split(" ");

            stringBuilder
                    .append(solution(firstPublicKey, secondPublicKey, passphrase))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String[] firstPublicKey, String[] secondPublicKey, String[] passphrase) {
        Map<String, Integer> firstPublicKeyIndexMap =
                IntStream.range(0, firstPublicKey.length)
                        .boxed()
                        .collect(Collectors.toMap(i -> firstPublicKey[i], i -> i));

        return IntStream.range(0, passphrase.length)
                .boxed()
                .collect(Collectors.toMap(
                        i -> firstPublicKeyIndexMap.get(secondPublicKey[i]),
                        i -> passphrase[i]
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(" "));
    }
}
