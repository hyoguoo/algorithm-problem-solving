/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17091
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordClock {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int hour = Integer.parseInt(bufferedReader.readLine());
        int minute = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(hour, minute));
    }

    private static TimeFormatter solution(int hour, int minute) {
        return TimeFormatter.format(hour, minute);
    }

    enum NumberWord {
        ONE(1, "one"), TWO(2, "two"), THREE(3, "three"), FOUR(4, "four"), FIVE(5, "five"),
        SIX(6, "six"), SEVEN(7, "seven"), EIGHT(8, "eight"), NINE(9, "nine"), TEN(10, "ten"),
        ELEVEN(11, "eleven"), TWELVE(12, "twelve"), THIRTEEN(13, "thirteen"), FOURTEEN(14, "fourteen"),
        FIFTEEN(15, "fifteen"), SIXTEEN(16, "sixteen"), SEVENTEEN(17, "seventeen"), EIGHTEEN(18, "eighteen"),
        NINETEEN(19, "nineteen"), TWENTY(20, "twenty");

        private final int value;
        private final String word;

        NumberWord(int value, String word) {
            this.value = value;
            this.word = word;
        }

        public static NumberWord fromInt(int n) {
            for (NumberWord nw : values()) {
                if (nw.value == n) {
                    return nw;
                }
            }
            return null;
        }

        public static String toWord(int n) {
            if (n <= 0) {
                throw new IllegalArgumentException();
            }
            if (n <= 20) {
                NumberWord nw = fromInt(n);
                if (nw != null) {
                    return nw.word();
                }
            }
            if (n < 30) {
                int rem = n - 20;
                NumberWord remWord = fromInt(rem);
                return "twenty " + (remWord != null ? remWord.word() : String.valueOf(rem));
            }
            if (n == 30) {
                return "thirty";
            }
            throw new IllegalArgumentException();
        }

        public String word() {
            return word;
        }
    }

    private static class TimeFormatter {

        private final String text;

        private TimeFormatter(String text) {
            this.text = text;
        }

        public static TimeFormatter format(int hour, int minute) {
            if (minute == 0) {
                return new TimeFormatter(String.format("%s o' clock", NumberWord.toWord(hour)));
            }

            if (minute <= 30) {
                return past(hour, minute);
            } else {
                return to(hour, minute);
            }
        }

        public static TimeFormatter past(int hour, int minute) {
            if (minute == 15) {
                return new TimeFormatter(String.format("quarter past %s", NumberWord.toWord(hour)));
            }
            if (minute == 30) {
                return new TimeFormatter(String.format("half past %s", NumberWord.toWord(hour)));
            }
            String minuteWord = NumberWord.toWord(minute);
            String unit = minute == 1 ? "minute" : "minutes";
            return new TimeFormatter(String.format("%s %s past %s", minuteWord, unit, NumberWord.toWord(hour)));
        }

        public static TimeFormatter to(int hour, int minute) {
            int minutesTo = 60 - minute;
            int nextHour = hour == 12 ? 1 : hour + 1;
            if (minutesTo == 15) {
                return new TimeFormatter(String.format("quarter to %s", NumberWord.toWord(nextHour)));
            }
            String minuteWord = NumberWord.toWord(minutesTo);
            String unit = minutesTo == 1 ? "minute" : "minutes";
            return new TimeFormatter(String.format("%s %s to %s", minuteWord, unit, NumberWord.toWord(nextHour)));
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
