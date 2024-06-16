/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1672
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecodingDNA {

    private static final char[][] DNA = {
            {'A', 'C', 'A', 'G'},
            {'C', 'G', 'T', 'A'},
            {'A', 'T', 'C', 'G'},
            {'G', 'A', 'G', 'T'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        String dna = bufferedReader.readLine();

        System.out.print(solution(dna));
    }

    private static char solution(String dna) {
        char result = dna.charAt(dna.length() - 1);

        for (int i = dna.length() - 2; i >= 0; i--) {
            result = DNA[getIndex(result)][getIndex(dna.charAt(i))];
        }

        return result;
    }

    private static int getIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'G':
                return 1;
            case 'C':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }
}
