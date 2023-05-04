/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9536
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhatDoesTheFoxSay {

    final static String GOES = "goes";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            System.out.println(solution(bufferedReader));
        }
    }

    private static String solution(BufferedReader bufferedReader) throws IOException {
        String[] animalSounds = bufferedReader.readLine().split(" ");

        while (true) {
            String[] sound = bufferedReader.readLine().split(" ");
            if (sound[1].equals(GOES)) {
                for (int i = 0; i < animalSounds.length; i++) {
                    if (animalSounds[i].equals(sound[2])) animalSounds[i] = "";
                }
            } else break;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String animalSound : animalSounds) {
            if (!animalSound.equals("")) stringBuilder.append(animalSound).append(" ");
        }

        return stringBuilder.toString();
    }
}
