/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31562
 * Cheat Level: 0
 * Algorithm: Map / Implementation
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class GuessSongFromIntro {

    private static final int INTRO_LENGTH = 5;
    private static final String DUPLICATED = "?";
    private static final String NOT_FOUND = "!";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int songCount = info[0];
        int introSheetCount = info[1];

        Song[] songs = new Song[songCount];
        for (int i = 0; i < songCount; i++) {
            String songInfo = bufferedReader.readLine();
            String title = songInfo.split(" ")[1];
            String sheet = songInfo.substring(songInfo.indexOf(title) + title.length() + 1);
            songs[i] = new Song(title, sheet);
        }

        String[] introSheets = new String[introSheetCount];
        for (int i = 0; i < introSheetCount; i++) {
            introSheets[i] = bufferedReader.readLine();
        }

        System.out.print(solution(songs, introSheets));
    }

    private static String solution(Song[] songs, String[] introSheets) {
        Map<String, String> sheetToTitleMap = Arrays.stream(songs)
                .collect(Collectors.toMap(
                        Song::getIntroSheet,
                        song -> song.title,
                        (existing, next) -> DUPLICATED
                ));

        return Arrays.stream(introSheets)
                .map(introSheet -> sheetToTitleMap.getOrDefault(introSheet, NOT_FOUND))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    static class Song {

        private final String title;
        private final String sheet;

        public Song(String title, String sheet) {
            this.title = title;
            this.sheet = sheet;
        }

        public String getIntroSheet() {
            return sheet.substring(0, INTRO_LENGTH);
        }
    }
}
