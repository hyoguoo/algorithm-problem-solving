/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 29813
 * Cheat Level: 0
 * Algorithm: Queue
 */

package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class FavoriteTeamMember {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int memberCount = Integer.parseInt(bufferedReader.readLine());
        Queue<Member> queue = new LinkedList<>();

        for (int i = 1; i <= memberCount; i++) {
            String[] info = bufferedReader.readLine().split(" ");
            queue.add(new Member(info[0], Integer.parseInt(info[1])));
        }

        System.out.print(solution(queue));
    }

    private static String solution(Queue<Member> queue) {
        return Optional.ofNullable(queue)
                .filter(q -> !q.isEmpty())
                .map(FavoriteTeamMember::findLastMember)
                .map(member -> member.name)
                .orElseThrow();
    }

    private static Member findLastMember(Queue<Member> q) {
        while (q.size() > 1) {
            Optional.ofNullable(q.poll()).ifPresent(member -> {
                for (int i = 0; i < member.favoriteNumber - 1; i++) {
                    Optional.ofNullable(q.poll()).ifPresent(q::add);
                }
            });
            q.poll();
        }

        return q.poll();
    }

    static class Member {

        private final String name;
        private final int favoriteNumber;

        public Member(String name, int favoriteNumber) {
            this.name = name;
            this.favoriteNumber = favoriteNumber;
        }
    }
}
