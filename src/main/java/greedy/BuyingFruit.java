/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 15일차
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuyingFruit {

    final static List<Fruit> fruitList = new ArrayList<>();
    static int N, money;

    public static void main(String[] args) throws Exception {
        init();

        System.out.println(solution());
    }

    private static long solution() {
        long result = 0;

        Collections.sort(fruitList);
        for (Fruit fruit : fruitList) {
            if (fruit.price <= money) {
                result += fruit.value;
                money -= fruit.price;
            } else {
                result += (long) fruit.getUnitValue() * money;
                break;
            }
        }

        return result;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        money = info[1];
        for (int n = 0; n < N; n++) {
            int[] fruitInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            fruitList.add(new Fruit(fruitInfo[0], fruitInfo[1]));
        }
    }

    static class Fruit implements Comparable<Fruit> {
        int price;
        int value;

        public Fruit(int price, int value) {
            this.price = price;
            this.value = value;
        }

        @Override
        public int compareTo(Fruit o) {
            if (this.getUnitValue() == o.getUnitValue()) return o.price - this.price;
            return o.getUnitValue() - this.getUnitValue();
        }

        private int getUnitValue() {
            return this.value / this.price;
        }
    }
}

