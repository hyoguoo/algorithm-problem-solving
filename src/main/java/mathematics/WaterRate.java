/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1070
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterRate {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CompanyRate companyARate = new CompanyRate(Integer.parseInt(bufferedReader.readLine()));
        CompanyRate companyBRate = new CompanyRate(Integer.parseInt(bufferedReader.readLine()),
                Integer.parseInt(bufferedReader.readLine()),
                Integer.parseInt(bufferedReader.readLine()));
        int usedLiter = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(companyARate, companyBRate, usedLiter));
    }


    private static int solution(CompanyRate companyARate, CompanyRate companyBRate, int usedLiter) {
        return Math.min(companyARate.calculate(usedLiter), companyBRate.calculate(usedLiter));
    }

    static class CompanyRate {

        private final int baseRate;
        private final int baseLiter;
        private final int ratePerLiter;

        public CompanyRate(int ratePerLiter) {
            this(0, 0, ratePerLiter);
        }

        public CompanyRate(int baseRate, int baseLiter, int ratePerLiter) {
            this.baseRate = baseRate;
            this.baseLiter = baseLiter;
            this.ratePerLiter = ratePerLiter;
        }

        public int calculate(int usedLiter) {
            if (usedLiter <= baseLiter) {
                return baseRate;
            }
            return baseRate + (usedLiter - baseLiter) * ratePerLiter;
        }
    }
}
