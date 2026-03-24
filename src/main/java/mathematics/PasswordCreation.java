/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1837
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PasswordCreation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bufferedReader.readLine().split(" ");

        BigInteger password = new BigInteger(inputs[0]);
        int limit = Integer.parseInt(inputs[1]);

        System.out.print(solution(new PasswordInfo(password, limit)));
    }

    private static Result solution(PasswordInfo passwordInfo) {
        int limit = passwordInfo.getLimit();
        BigInteger password = passwordInfo.getPassword();

        boolean[] isNotPrime = getIsNotPrimeArray(limit);

        for (int divisor = 2; divisor < limit; divisor++) {
            if (!isNotPrime[divisor]) {
                if (isDivisible(password, divisor)) {
                    return new Result(PasswordQuality.BAD, divisor);
                }
            }
        }

        return new Result(PasswordQuality.GOOD);
    }

    private static boolean[] getIsNotPrimeArray(int limit) {
        boolean[] isNotPrime = new boolean[limit];
        for (int divisor = 2; divisor * divisor < limit; divisor++) {
            if (!isNotPrime[divisor]) {
                for (int multiple = divisor * divisor; multiple < limit; multiple += divisor) {
                    isNotPrime[multiple] = true;
                }
            }
        }
        return isNotPrime;
    }

    private static boolean isDivisible(BigInteger dividend, int divisor) {
        return dividend.remainder(BigInteger.valueOf(divisor)).equals(BigInteger.ZERO);
    }

    enum PasswordQuality {
        GOOD, BAD
    }

    static class Result {

        private final PasswordQuality quality;
        private final int divisor;

        public Result(PasswordQuality quality) {
            this(quality, 0);
        }

        public Result(PasswordQuality quality, int divisor) {
            this.quality = quality;
            this.divisor = divisor;
        }

        @Override
        public String toString() {
            if (quality == PasswordQuality.GOOD) {
                return quality.name();
            }
            return quality.name() + " " + divisor;
        }
    }

    static class PasswordInfo {

        private final BigInteger password;
        private final int limit;

        public PasswordInfo(BigInteger password, int limit) {
            this.password = password;
            this.limit = limit;
        }

        public BigInteger getPassword() {
            return password;
        }

        public int getLimit() {
            return limit;
        }
    }
}
