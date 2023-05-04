/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 42888
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatRoom {

    final static String ENTER = "Enter";
    final static String LEAVE = "Leave";
    final static String ENTER_MESSAGE = "님이 들어왔습니다.";
    final static String LEAVE_MESSAGE = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        Map<String, String> userMap = getUserInfo(record);
        List<String> answer = getAnswer(record, userMap);

        return answer.stream().map(String::valueOf).toArray(String[]::new);
    }

    private Map<String, String> getUserInfo(String[] record) {
        final Map<String, String> userInfo = new HashMap<>();
        for (String message : record) {
            String[] messageArray = message.split(" ");
            if (!messageArray[0].equals(LEAVE)) userInfo.put(messageArray[1], messageArray[2]);
        }

        return userInfo;
    }

    private List<String> getAnswer(String[] record, Map<String, String> userInfo) {
        final List<String> answer = new ArrayList<>();

        for (String message : record) {
            String[] messageArray = message.split(" ");
            String nickname = userInfo.get(messageArray[1]);

            if (messageArray[0].equals(ENTER)) answer.add(nickname + ENTER_MESSAGE);
            if (messageArray[0].equals(LEAVE)) answer.add(nickname + LEAVE_MESSAGE);
        }

        return answer;
    }
}
