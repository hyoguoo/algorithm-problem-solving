/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 1주차 문제 2
 */

package String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SameNameTest {

    @Test
    void countContainName() {
        int length = 4;
        String[] nameList = {"sam", "fredy", "fredi", "ilium"};
        String baseName = "fred";
        assertEquals(SameName.countContainName(length, baseName, nameList), 2);
    }
}