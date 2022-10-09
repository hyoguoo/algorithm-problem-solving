/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2609
 */

package Mathematics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GcdAndLcmTest {

    @Test
    void getGcd() {
        Assertions.assertEquals(GcdAndLcm.getGcd(24, 18), 6);
    }

    @Test
    void getLcm() {
        Assertions.assertEquals(GcdAndLcm.getGcdAndLcm(24, 18), 72);
    }
}