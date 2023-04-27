/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16938
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSticker {

    final static List<Sticker> stickerList = new ArrayList<>();
    final static List<Integer> stickerSumList = new ArrayList<>();
    final static int STICKER_COUNT = 2;
    static int H, W;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        selectSticker(0, new ArrayList<>());
        System.out.println(stickerSumList.stream().mapToInt(Integer::intValue).max().getAsInt());
    }

    private static void selectSticker(int index, List<Sticker> selectedStickerList) {
        if (selectedStickerList.size() == STICKER_COUNT) {
            if (isNotOverlapTwo(selectedStickerList.get(0), selectedStickerList.get(1))) {
                int sum = selectedStickerList.stream().mapToInt(sticker -> sticker.width * sticker.height).sum();
                stickerSumList.add(sum);
            }
            return;
        }

        for (int i = index; i < stickerList.size(); i++) {
            Sticker sticker = stickerList.get(i);
            Sticker rotatedSticker = new Sticker(sticker.height, sticker.width);

            selectedStickerList.add(sticker);
            selectSticker(i + 1, selectedStickerList);
            selectedStickerList.remove(sticker);

            selectedStickerList.add(rotatedSticker);
            selectSticker(i + 1, selectedStickerList);
            selectedStickerList.remove(rotatedSticker);
        }
    }

    private static boolean isNotOverlapTwo(Sticker firstSticker, Sticker secondSticker) {
        int widthSum = firstSticker.width + secondSticker.width;
        int heightSum = firstSticker.height + secondSticker.height;

        if (firstSticker.width > W || firstSticker.height > H) return false;
        if (secondSticker.width > W || secondSticker.height > H) return false;

        return widthSum <= W || heightSum <= H;
    }


    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        H = info[0];
        W = info[1];
        int stickerCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < stickerCount; i++) {
            int[] stickerInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = stickerInfo[0];
            int y = stickerInfo[1];
            stickerList.add(new Sticker(x, y));
        }
        stickerSumList.add(0);
    }

    static class Sticker {
        int width;
        int height;

        public Sticker(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
