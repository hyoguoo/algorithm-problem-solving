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