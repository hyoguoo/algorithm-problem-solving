/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27111
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AccessHistory {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int accessRecordCount = Integer.parseInt(bufferedReader.readLine());
        AccessRecord[] accessRecords = new AccessRecord[accessRecordCount];
        for (int i = 0; i < accessRecords.length; i++) {
            int[] accessRecordInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            accessRecords[i] = new AccessRecord(accessRecordInfo[0], AccessType.of(accessRecordInfo[1]));
        }

        System.out.print(solution(accessRecords));
    }

    private static int solution(AccessRecord[] accessRecords) {
        Set<Integer> peopleSet = new HashSet<>();
        int count = 0;

        for (AccessRecord accessRecord : accessRecords) {
            switch (accessRecord.accessType) {
                case IN:
                    if (!peopleSet.add(accessRecord.personId)) {
                        count++;
                    }
                    break;
                case OUT:
                    if (!peopleSet.remove(accessRecord.personId)) {
                        count++;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        return count + peopleSet.size();
    }

    enum AccessType {
        IN(1), OUT(0);

        private final int value;

        AccessType(int value) {
            this.value = value;
        }

        public static AccessType of(int value) {
            return Arrays.stream(AccessType.values())
                    .filter(accessType -> accessType.value == value)
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class AccessRecord {

        private final int personId;
        private final AccessType accessType;

        public AccessRecord(int personId, AccessType accessType) {
            this.personId = personId;
            this.accessType = accessType;
        }
    }
}
