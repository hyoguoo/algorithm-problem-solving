/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14653
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class YourName {

    private static final char MY_NAME = 'A';
    private static final String ALL_READ = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleCount = info[0];
        int messageCount = info[1];
        int targetMessageIndex = info[2] - 1;

        Message[] messages = new Message[messageCount];

        for (int i = 0; i < messageCount; i++) {
            String[] messageInfo = bufferedReader.readLine().split(" ");
            messages[i] = new Message(Integer.parseInt(messageInfo[0]), messageInfo[1].charAt(0));
        }

        System.out.print(solution(messages, peopleCount, targetMessageIndex));
    }

    private static String solution(Message[] messages, int peopleCount, int targetMessageIndex) {
        int targetMessageUnreadCount = messages[targetMessageIndex].unreadCount;

        if (targetMessageUnreadCount == 0) {
            return ALL_READ;
        }

        Set<Character> unreadNameSet = IntStream.rangeClosed(1, peopleCount)
                .mapToObj(i -> (char) ('A' + i - 1))
                .collect(Collectors.toSet());
        unreadNameSet.remove(MY_NAME);

        Arrays.stream(messages)
                .filter(message -> message.unreadCount == targetMessageUnreadCount)
                .forEach(message -> unreadNameSet.remove(message.senderName));

        Arrays.stream(messages)
                .skip(targetMessageIndex)
                .forEach(message -> unreadNameSet.remove(message.senderName));

        return unreadNameSet.stream()
                .map(String::valueOf)
                .sorted()
                .collect(Collectors.joining(" "));
    }

    static class Message {

        private final int unreadCount;
        private final char senderName;

        public Message(int unreadCount, char senderName) {
            this.unreadCount = unreadCount;
            this.senderName = senderName;
        }
    }
}
