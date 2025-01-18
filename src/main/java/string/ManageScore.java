/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30647
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class ManageScore {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (lineCount-- > 0) {
            String input = bufferedReader.readLine();
            stringBuilder.append(input);
        }

        System.out.print(solution(stringBuilder.toString()));
    }

    private static String solution(String rawJson) {
        ScoreInfo[] scoreInfos = new JsonParser(rawJson).parse();

        return new ScoreBoard(scoreInfos).getScoreBoard();
    }

    static class JsonParser {

        private final String rawJson;

        public JsonParser(String rawJson) {
            this.rawJson = rawJson;
        }

        private static String[] parseJson(String rawJson) {
            String[] splitJson = rawJson.trim().substring(1, rawJson.length() - 1).split("},");

            return Arrays.stream(splitJson).map(
                    object -> {
                        object = object.trim();
                        if (!object.endsWith("}")) {
                            object += "}";
                        }
                        return object;
                    }
            ).toArray(String[]::new);
        }

        private static String extractValue(String jsonObject, String fieldName) {
            String prefix = "\"" + fieldName + "\":";
            int start = jsonObject.indexOf(prefix) + prefix.length();
            int end = jsonObject.indexOf(",", start);

            if (end == -1) {
                end = jsonObject.indexOf("}", start);
            }

            return jsonObject.substring(start, end)
                    .replace("\"", "")
                    .trim();
        }

        public ScoreInfo[] parse() {
            String[] objects = parseJson(rawJson);

            return Arrays.stream(objects).map(
                    object -> {
                        String name = extractValue(object, "name");
                        int score = Integer.parseInt(extractValue(object, "score"));
                        int isHidden = Integer.parseInt(extractValue(object, "isHidden"));

                        return new ScoreInfo(name, score, isHidden);
                    }
            ).toArray(ScoreInfo[]::new);
        }
    }

    static class ScoreBoard {

        private final ScoreInfo[] scoreInfos;

        public ScoreBoard(ScoreInfo[] scoreInfos) {
            this.scoreInfos = Arrays.stream(scoreInfos)
                    .sorted()
                    .toArray(ScoreInfo[]::new);
        }

        public String getScoreBoard() {
            StringBuilder stringBuilder = new StringBuilder();

            int[] ranks = calculateRanks();

            IntStream.range(0, scoreInfos.length)
                    .filter(i -> !scoreInfos[i].isHidden())
                    .forEach(i -> stringBuilder
                            .append(ranks[i]).append(" ")
                            .append(scoreInfos[i].getName()).append(" ")
                            .append(scoreInfos[i].getScore()).append("\n"));

            return stringBuilder.toString().trim();
        }

        private int[] calculateRanks() {
            int[] ranks = new int[scoreInfos.length];
            int rank = 1;

            for (int i = 0; i < scoreInfos.length; i++) {
                if (i > 0 && scoreInfos[i].getScore() < scoreInfos[i - 1].getScore()) {
                    rank = i + 1;
                }
                ranks[i] = rank;
            }

            return ranks;
        }
    }

    static class ScoreInfo implements Comparable<ScoreInfo> {

        private final String name;
        private final int score;
        private final boolean isHidden;

        public ScoreInfo(String name, int score, int isHidden) {
            this.name = name;
            this.score = score;
            this.isHidden = isHidden == 1;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public boolean isHidden() {
            return isHidden;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ScoreInfo scoreInfo = (ScoreInfo) o;
            return score == scoreInfo.score && isHidden == scoreInfo.isHidden && Objects.equals(name, scoreInfo.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, score, isHidden);
        }

        @Override
        public int compareTo(ScoreInfo o) {
            if (score == o.score) {
                return name.compareTo(o.name);
            }
            return Integer.compare(o.score, score);
        }
    }
}
