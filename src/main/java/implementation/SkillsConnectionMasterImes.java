/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25497
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkillsConnectionMasterImes {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String skills = bufferedReader.readLine();

        System.out.print(solution(skills));
    }

    private static int solution(String skills) {
        int successCount = 0;
        int pendingL = 0;
        int pendingS = 0;

        for (char skill : skills.toCharArray()) {
            SkillType type = SkillType.of(skill);
            if (type == null) continue;

            switch (type) {
                case INDEPENDENT:
                    successCount++;
                    break;
                case PRE_LR:
                    pendingL++;
                    break;
                case PRE_SK:
                    pendingS++;
                    break;
                case MAIN_LR:
                    if (pendingL <= 0) return successCount;
                    pendingL--;
                    successCount++;
                    break;
                case MAIN_SK:
                    if (pendingS <= 0) return successCount;
                    pendingS--;
                    successCount++;
                    break;
                default:
                    break;
            }
        }

        return successCount;
    }

    enum SkillType {
        INDEPENDENT,
        PRE_LR,
        MAIN_LR,
        PRE_SK,
        MAIN_SK;

        public static SkillType of(char skill) {
            if (skill >= '1' && skill <= '9') {
                return INDEPENDENT;
            }
            switch (skill) {
                case 'L':
                    return PRE_LR;
                case 'R':
                    return MAIN_LR;
                case 'S':
                    return PRE_SK;
                case 'K':
                    return MAIN_SK;
                default:
                    return null;
            }
        }
    }
}
