/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 12979
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

public class InstallStation {

    public int solution(int n, int[] stations, int w) {
        int result = 0;
        int startAt = 1;

        for (int station : stations) {
            int endAt = station - w;
            if (endAt - startAt > 0) result += Math.ceil((double) (endAt - startAt) / (w * 2 + 1));
            startAt = station + w + 1;
        }
        if (startAt <= n) result += Math.ceil((double) (n - startAt + 1) / (w * 2 + 1));

        return result;
    }
}
