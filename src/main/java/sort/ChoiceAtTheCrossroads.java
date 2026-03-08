package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ChoiceAtTheCrossroads {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Miniature[] miniatures = new Miniature[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int quality = Integer.parseInt(stringTokenizer.nextToken());
            int price = Integer.parseInt(stringTokenizer.nextToken());
            miniatures[i] = new Miniature(quality, price);
        }

        System.out.print(solution(miniatures));
    }

    private static String solution(Miniature[] miniatures) {
        return Arrays.stream(miniatures)
                .sorted(SelectionMethod.QUALITY_FIRST.getComparator())
                .limit(2)
                .map(Miniature::toString)
                .collect(Collectors.joining(" ")) +
                "\n" +
                Arrays.stream(miniatures)
                        .sorted(SelectionMethod.PRICE_FIRST.getComparator())
                        .limit(2)
                        .map(Miniature::toString)
                        .collect(Collectors.joining(" "));
    }

    enum SelectionMethod {
        QUALITY_FIRST(Comparator.comparingInt(Miniature::getQuality).reversed()
                .thenComparingInt(Miniature::getPrice)),
        PRICE_FIRST(Comparator.comparingInt(Miniature::getPrice)
                .thenComparing(Comparator.comparingInt(Miniature::getQuality).reversed()));

        private final Comparator<Miniature> comparator;

        SelectionMethod(Comparator<Miniature> comparator) {
            this.comparator = comparator;
        }

        public Comparator<Miniature> getComparator() {
            return comparator;
        }
    }

    static class Miniature {

        private final int quality;
        private final int price;

        public Miniature(int quality, int price) {
            this.quality = quality;
            this.price = price;
        }

        public int getQuality() {
            return quality;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return quality + " " + price;
        }
    }
}
