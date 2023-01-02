/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16165
 * Cheat Level: 2
 * Algorithm: Map
 */

package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GirlGroupMasterJunseok {

    private static final Map<String, String[]> groupMember = new HashMap<>();
    private static final Map<String, String> memberGroup = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int girlGroupCount = info[0];
        int questionCount = info[1];


        for (int i = 0; i < girlGroupCount; i++) {
            mapping(bufferedReader);
        }


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < questionCount; i++) {
            String question = bufferedReader.readLine();
            String questionType = bufferedReader.readLine();
            getAnswer(stringBuilder, question, questionType);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }

    private static void mapping(BufferedReader bufferedReader) throws IOException {
        String groupName = bufferedReader.readLine();
        int memberCount = Integer.parseInt(bufferedReader.readLine());
        String[] groupMembers = new String[memberCount];
        for (int j = 0; j < memberCount; j++) {
            String memberName = bufferedReader.readLine();
            memberGroup.put(memberName, groupName);
            groupMembers[j] = memberName;
        }
        Arrays.sort(groupMembers);
        groupMember.put(groupName, groupMembers);
    }

    private static void getAnswer(StringBuilder stringBuilder, String question, String questionType) {
        if (questionType.equals("1")) stringBuilder.append(memberGroup.get(question)).append("\n");
        else if (questionType.equals("0")) {
            String[] strings = groupMember.get(question);
            for (String string : strings) stringBuilder.append(string).append("\n");
        }
    }
}
