/*
 * sBAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20116
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EnergyDrink {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(getEnergies()));
    }

    private static double[] getEnergies() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        return Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
    }

    private static double solution(double[] energies) {
        double sum = 0;
        double max = 0;

        for (double energy : energies) {
            sum += energy;
            max = Math.max(max, energy);
        }

        return (sum + max) / 2;
    }
}
