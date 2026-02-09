/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27162
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class YachtDice {

    private static final int NUM_DICE_TOTAL = 5;
    private static final int MIN_DIE_FACE = 1;
    private static final int MAX_DIE_FACE = 6;
    private static final int STRAIGHT_SCORE = 30;
    private static final int YACHT_SCORE = 50;
    private static final int FOUR_OF_A_KIND_COUNT = 4;
    private static final int FULL_HOUSE_THREE_COUNT = 3;
    private static final int FULL_HOUSE_TWO_COUNT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String availableCategoriesStr = bufferedReader.readLine();
        boolean[] availableCategories = new boolean[Category.values().length];
        for (int i = 0; i < Category.values().length; i++) {
            availableCategories[i] = availableCategoriesStr.charAt(i) == 'Y';
        }

        List<Integer> fixedDice = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        System.out.print(solution(availableCategories, fixedDice));
    }

    public static int solution(boolean[] availableCategories, List<Integer> fixedDice) {
        AtomicInteger maxScore = new AtomicInteger();

        for (int die4 = MIN_DIE_FACE; die4 <= MAX_DIE_FACE; die4++) {
            for (int die5 = MIN_DIE_FACE; die5 <= MAX_DIE_FACE; die5++) {
                List<Integer> currentDice = new ArrayList<>(fixedDice);
                currentDice.add(die4);
                currentDice.add(die5);

                Collections.sort(currentDice);

                int[] counts = countDice(currentDice);

                Arrays.stream(Category.values())
                        .filter(category -> availableCategories[category.getId()])
                        .forEach(category -> {
                            int score = calculateCategoryScore(category, currentDice, counts);
                            maxScore.set(Math.max(maxScore.get(), score));
                        });
            }
        }

        return maxScore.get();
    }

    private static int[] countDice(List<Integer> dice) {
        int[] counts = new int[MAX_DIE_FACE + 1];
        for (int die : dice) {
            counts[die]++;
        }
        return counts;
    }

    private static int calculateCategoryScore(Category category, List<Integer> dice, int[] counts) {
        switch (category) {
            case ONES:
            case TWOS:
            case THREES:
            case FOURS:
            case FIVES:
            case SIXES:
                return calculateNumberedScore(category, counts);
            case FOUR_OF_A_KIND:
                return calculateFourOfAKindScore(counts);
            case FULL_HOUSE:
                return calculateFullHouseScore(counts);
            case LITTLE_STRAIGHT:
            case BIG_STRAIGHT:
                return calculateStraightScore(category, dice);
            case YACHT:
                return calculateYachtScore(counts);
            case CHOICE:
                return calculateChoiceScore(dice);
            default:
                return 0;
        }
    }

    private static int calculateNumberedScore(Category category, int[] counts) {
        int faceValue = category.getId() + MIN_DIE_FACE;
        return counts[faceValue] * faceValue;
    }

    private static int calculateFourOfAKindScore(int[] counts) {
        for (int i = MIN_DIE_FACE; i <= MAX_DIE_FACE; i++) {
            if (counts[i] >= FOUR_OF_A_KIND_COUNT) {
                return i * FOUR_OF_A_KIND_COUNT;
            }
        }
        return 0;
    }

    private static int calculateFullHouseScore(int[] counts) {
        boolean hasThree = false;
        boolean hasTwo = false;
        int sum = 0;
        for (int i = MIN_DIE_FACE; i <= MAX_DIE_FACE; i++) {
            if (counts[i] == FULL_HOUSE_THREE_COUNT) {
                hasThree = true;
                sum += i * FULL_HOUSE_THREE_COUNT;
            } else if (counts[i] == FULL_HOUSE_TWO_COUNT) {
                hasTwo = true;
                sum += i * FULL_HOUSE_TWO_COUNT;
            }
        }
        return (hasThree && hasTwo) ? sum : 0;
    }

    private static int calculateStraightScore(Category category, List<Integer> dice) {
        if (checkStraight(dice, category.getStraightSequence())) {
            return STRAIGHT_SCORE;
        }
        return 0;
    }

    private static int calculateYachtScore(int[] counts) {
        for (int i = MIN_DIE_FACE; i <= MAX_DIE_FACE; i++) {
            if (counts[i] == NUM_DICE_TOTAL) {
                return YACHT_SCORE;
            }
        }
        return 0;
    }

    private static int calculateChoiceScore(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean checkStraight(List<Integer> dice, int[] requiredSequence) {
        for (int i = 0; i < NUM_DICE_TOTAL; i++) {
            if (dice.get(i) != requiredSequence[i]) {
                return false;
            }
        }
        return true;
    }

    enum Category {
        ONES(0), TWOS(1), THREES(2), FOURS(3), FIVES(4), SIXES(5),
        FOUR_OF_A_KIND(6), FULL_HOUSE(7),
        LITTLE_STRAIGHT(8, new int[]{1, 2, 3, 4, 5}),
        BIG_STRAIGHT(9, new int[]{2, 3, 4, 5, 6}),
        YACHT(10), CHOICE(11);

        private final int id;
        private final int[] straightSequence;

        Category(int id) {
            this(id, null);
        }

        Category(int id, int[] straightSequence) {
            this.id = id;
            this.straightSequence = straightSequence;
        }


        public int getId() {
            return id;
        }

        public int[] getStraightSequence() {
            return straightSequence;
        }
    }
}
