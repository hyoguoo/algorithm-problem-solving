/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10808
 * Cheat Level: 0
 * Algorithm: String
 */

import java.io.*;
import java.util.*;

public class AlphabetCount {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        char[] input = bufferedReader.readLine().toCharArray();
        int[] count = new int[26];
        
        for(int i = 0; i < input.length; i++) {
            count[(int)input[i] - 97]++;
        }
        
        System.out.println(Arrays.toString(count).replaceAll("[\\]\\[\\,]",""));
    }
}
