/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 33691
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ArkainDashboard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int useLogCount = Integer.parseInt(bufferedReader.readLine());
        String[] containerUseLog = new String[useLogCount];
        for (int i = 0; i < useLogCount; i++) {
            containerUseLog[i] = bufferedReader.readLine();
        }
        int fixedContainerCount = Integer.parseInt(bufferedReader.readLine());
        String[] containerFixedContainer = new String[fixedContainerCount];
        for (int i = 0; i < fixedContainerCount; i++) {
            containerFixedContainer[i] = bufferedReader.readLine();
        }

        System.out.print(solution(containerUseLog, containerFixedContainer));
    }

    private static String solution(String[] containerUseLog, String[] containerFixedContainer) {
        StringBuilder otherContainerList = new StringBuilder();
        StringBuilder fixedContainerList = new StringBuilder();
        Set<String> useContainerSet = Arrays.stream(containerUseLog)
                .collect(Collectors.toSet());
        Set<String> fixedContainerSet = Arrays.stream(containerFixedContainer)
                .collect(Collectors.toSet());

        for (int i = containerUseLog.length - 1; i >= 0; i--) {
            String useContainer = containerUseLog[i];
            if (fixedContainerSet.contains(useContainer)) {
                fixedContainerList.append(useContainer).append(System.lineSeparator());
                fixedContainerSet.remove(useContainer);
            } else if (useContainerSet.contains(useContainer)) {
                otherContainerList.append(useContainer).append(System.lineSeparator());
            }
            useContainerSet.remove(useContainer);
        }

        return fixedContainerList.append(otherContainerList).toString();
    }
}
