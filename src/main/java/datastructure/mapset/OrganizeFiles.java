/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20291
 * Cheat Level: 0
 * Algorithm: Implementation / Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class OrganizeFiles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String[] fileNames = new String[n];
        for (int i = 0; i < n; i++) {
            fileNames[i] = bufferedReader.readLine();
        }

        System.out.print(solution(fileNames));
    }

    private static String solution(String[] fileNames) {
        Map<String, Integer> fileExtensionCount = getFileExtensionCount(fileNames);

        return keyValueToString(fileExtensionCount);
    }

    private static Map<String, Integer> getFileExtensionCount(String[] fileNames) {
        Map<String, Integer> fileExtensionCount = new TreeMap<>();

        for (String fileName : fileNames) {
            String fileExtension = getFileExtension(fileName);
            fileExtensionCount.put(fileExtension,
                    fileExtensionCount.getOrDefault(fileExtension, 0) + 1);
        }
        return fileExtensionCount;
    }

    private static String keyValueToString(Map<String, Integer> fileExtensionCount) {
        StringBuilder stringBuilder = new StringBuilder();

        fileExtensionCount
                .forEach(
                        (key, value) ->
                                stringBuilder
                                        .append(key)
                                        .append(" ")
                                        .append(value)
                                        .append("\n")
                );

        return stringBuilder.toString();
    }

    private static String getFileExtension(String fileName) {
        String[] splitName = fileName.split("\\.");

        return splitName[splitName.length - 1];
    }
}
