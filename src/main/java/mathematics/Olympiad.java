/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 8979
 * Cheat Level: 0
 * Algorithm: Sort
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Olympiad {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Country[] countries = new Country[info[0]];

        for (int i = 0; i < countries.length; i++) {
            int[] countryInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            countries[i] = new Country(countryInfo[0], countryInfo[1], countryInfo[2], countryInfo[3]);
        }

        System.out.println(solution(countries, info[1]));
    }

    private static int solution(Country[] countries, int targetCountryId) {
        Arrays.sort(countries);

        int findRank = getRank(countries, targetCountryId);
        Country targetCountry = countries[findRank - 1];

        while (findRank > 1 && targetCountry.equals(countries[findRank - 2])) {
            findRank--;
        }

        return findRank;
    }

    private static int getRank(Country[] countries, int targetCountryId) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].id == targetCountryId) return i + 1;
        }

        return -1;
    }

    static class Country implements Comparable<Country> {
        int id;
        int gold;
        int silver;
        int bronze;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Country country = (Country) o;
            return gold == country.gold && silver == country.silver && bronze == country.bronze;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gold, silver, bronze);
        }
    }
}
