/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9753
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductOfTwoPrimes {

    private static final int SIEVE_LIMIT = 100000;
    private static final int MAX_PRODUCT = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int threshold = Integer.parseInt(bufferedReader.readLine());
            stringBuilder
                    .append(solution(threshold))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int threshold) {
        List<Integer> primes = findPrimes(SIEVE_LIMIT);
        List<Integer> primeProducts = generatePrimeProducts(primes, MAX_PRODUCT);

        return searchSmallestProductAtLeast(primeProducts, threshold);
    }

    private static List<Integer> findPrimes(int limit) {
        NumberStatus[] statuses = new NumberStatus[limit + 1];
        Arrays.fill(statuses, NumberStatus.PRIME);
        statuses[0] = statuses[1] = NumberStatus.COMPOSITE;

        for (int i = 2; i * i <= limit; i++) {
            if (statuses[i] == NumberStatus.PRIME) {
                for (int j = i * i; j <= limit; j += i) {
                    statuses[j] = NumberStatus.COMPOSITE;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (statuses[i] == NumberStatus.PRIME) {
                primes.add(i);
            }
        }

        return primes;
    }

    private static List<Integer> generatePrimeProducts(List<Integer> primes, int limit) {
        List<Integer> products = new ArrayList<>();
        for (int i = 0; i < primes.size() - 1; i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                long product = (long) primes.get(i) * primes.get(j);
                if (product > limit) {
                    break;
                }
                products.add((int) product);
            }
        }
        Collections.sort(products);
        return products;
    }

    private static int searchSmallestProductAtLeast(List<Integer> products, int threshold) {
        int index = Collections.binarySearch(products, threshold);
        if (index < 0) {
            index = -(index + 1);
        }
        return products.get(index);
    }

    enum NumberStatus {
        PRIME, COMPOSITE
    }
}
