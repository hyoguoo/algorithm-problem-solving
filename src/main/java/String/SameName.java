/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge:
 */

/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 1주차 문제 2
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class SameName {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int length = Integer.parseInt(firstLine[0]);
        String baseName = firstLine[1];
        String[] nameList = new String[length];

        for (int i = 0; i < length; i++) {
            nameList[i] = bufferedReader.readLine();
        }

        int count = countContainName(length, baseName, nameList);
        System.out.println(count);
    }

    public static int countContainName(int length, String baseName, String[] nameList) {
        Pattern pattern = Pattern.compile(".*" + baseName + ".*");
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (pattern.matcher(nameList[i]).find()) count++;
        }

        return count;
    }
}
