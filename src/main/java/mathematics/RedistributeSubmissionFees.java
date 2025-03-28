/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26145
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RedistributeSubmissionFees {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int authorCount = info[0];
        int reviewerCount = info[1];
        int totalCount = authorCount + reviewerCount;

        int[] authorRewards = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Author[] authors = new Author[authorCount];

        for (int i = 0; i < authorCount; i++) {
            int[] transfers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] toAuthors = Arrays.copyOfRange(transfers, 0, authorCount);
            int[] toReviewers = Arrays.copyOfRange(transfers, authorCount, totalCount);
            authors[i] = new Author(authorRewards[i], toAuthors, toReviewers);
        }

        System.out.print(solution(authors, authorCount, reviewerCount));
    }

    private static String solution(Author[] authors, int authorCount, int reviewerCount) {
        int[] authorRewards = new int[authorCount];
        int[] reviewerRewards = new int[reviewerCount];

        for (int i = 0; i < authors.length; i++) {
            Author author = authors[i];
            authorRewards[i] += author.reward;
            for (int j = 0; j < author.toAuthors.length; j++) {
                authorRewards[j] += author.toAuthors[j];
                authorRewards[i] -= author.toAuthors[j];
            }
            for (int j = 0; j < author.toReviewers.length; j++) {
                reviewerRewards[j] += author.toReviewers[j];
                authorRewards[i] -= author.toReviewers[j];
            }
        }

        return new Result(authorRewards, reviewerRewards).toString();
    }

    static class Author {

        private final int reward;
        private final int[] toAuthors;
        private final int[] toReviewers;

        public Author(int reward, int[] toAuthors, int[] toReviewers) {
            this.reward = reward;
            this.toAuthors = toAuthors;
            this.toReviewers = toReviewers;
        }
    }

    static class Result {

        private final int[] authorRewards;
        private final int[] reviewerRewards;

        public Result(int[] authorRewards, int[] reviewerRewards) {
            this.authorRewards = authorRewards;
            this.reviewerRewards = reviewerRewards;
        }

        @Override
        public String toString() {
            return Arrays.stream(authorRewards)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")) +
                    " " +
                    Arrays.stream(reviewerRewards)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" "));
        }
    }
}
