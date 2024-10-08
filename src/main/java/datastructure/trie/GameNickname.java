/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16934
 * Cheat Level: 2
 * Algorithm: Trie
 */

package datastructure.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GameNickname {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nicknameCount = Integer.parseInt(bufferedReader.readLine());
        String[] nicknames = new String[nicknameCount];

        for (int i = 0; i < nicknameCount; i++) {
            nicknames[i] = bufferedReader.readLine();
        }

        System.out.print(solution(nicknames));
    }

    private static String solution(String[] nicknames) {
        NicknameCount nicknameCount = new NicknameCount();
        StringBuilder stringBuilder = new StringBuilder();
        Trie trie = new Trie();
        for (String nickname : nicknames) {
            nicknameCount.insert(nickname);

            int matchedLastIndex = trie.searchMatchLastIndex(nickname);
            if (matchedLastIndex == nickname.length() - 1) {
                int count = nicknameCount.getCount(nickname);
                if (count > 1) {
                    stringBuilder.append(nickname).append(count).append("\n");
                } else {
                    stringBuilder.append(nickname).append("\n");
                }
            } else if (matchedLastIndex > -1) {
                stringBuilder.append(nickname, 0, matchedLastIndex + 2).append("\n");
            } else if (matchedLastIndex == -1) {
                stringBuilder.append(nickname.charAt(0)).append("\n");
            }

            trie.insert(nickname);
        }

        return stringBuilder.toString().trim();
    }

    static class Trie {

        Node rootNode;

        public Trie() {
            this.rootNode = new Node();
        }

        public void insert(String word) {
            Node thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.children.computeIfAbsent(word.charAt(i), c -> new Node());
            }
            thisNode.isEndOfWord = true;
        }

        public int searchMatchLastIndex(String word) {
            int index = -1;
            Node thisNode = this.rootNode;
            for (char character : word.toCharArray()) {
                thisNode = thisNode.children.getOrDefault(character, null);
                if (thisNode == null) {
                    break;
                }
                index++;
            }
            return index;
        }
    }

    static class Node {

        private final Map<Character, Node> children;
        private boolean isEndOfWord;

        public Node() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }
    }

    static class NicknameCount {

        private final Map<String, Integer> nicknameCountMap;

        public NicknameCount() {
            this.nicknameCountMap = new HashMap<>();
        }

        public void insert(String nickname) {
            if (nicknameCountMap.containsKey(nickname)) {
                nicknameCountMap.put(nickname, this.getCount(nickname) + 1);
            } else {
                nicknameCountMap.put(nickname, 1);
            }
        }

        public int getCount(String nickname) {
            return nicknameCountMap.getOrDefault(nickname, 0);
        }
    }
}
