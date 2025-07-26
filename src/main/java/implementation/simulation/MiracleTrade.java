/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32982
 * Cheat Level: 0
 * Algorithm: Simulation / Implementation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MiracleTrade {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int currentAsset = Integer.parseInt(bufferedReader.readLine());
        int[] stockPrices = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(stockPrices, currentAsset));
    }

    private static StrategyResult solution(int[] stockPrices, int currentAsset) {
        Asset bnpAsset = new Asset(currentAsset, 0);
        Strategy bnpStrategy = new BNPStrategy(bnpAsset);
        int bnpResult = bnpStrategy.execute(stockPrices);
        Asset timingAsset = new Asset(currentAsset, 0);
        Strategy timingStrategy = new TimingStrategy(timingAsset);
        int timingResult = timingStrategy.execute(stockPrices);

        return StrategyResult.decide(bnpResult, timingResult);
    }

    enum StrategyResult {
        BNP, TIMING, SAMESAME;

        public static StrategyResult decide(int bnpResult, int timingResult) {
            if (bnpResult > timingResult) {
                return BNP;
            } else if (bnpResult < timingResult) {
                return TIMING;
            } else {
                return SAMESAME;
            }
        }
    }

    interface Strategy {

        int execute(int[] stockPrices);
    }

    static class BNPStrategy implements Strategy {

        private final Asset asset;

        public BNPStrategy(Asset asset) {
            this.asset = asset;
        }

        @Override
        public int execute(int[] stockPrices) {
            for (int stockPrice : stockPrices) {
                asset.buy(stockPrice);
            }
            return asset.getTotalAsset(stockPrices[stockPrices.length - 1]);
        }
    }

    static class TimingStrategy implements Strategy {

        private static final int CONTINUOUS_DAY = 3;
        private final Asset asset;
        private int continuousIncreaseCount;
        private int continuousDecreaseCount;

        public TimingStrategy(Asset asset) {
            this.asset = asset;
            this.continuousIncreaseCount = 0;
            this.continuousDecreaseCount = 0;
        }

        @Override
        public int execute(int[] stockPrices) {
            int currentPrice = stockPrices[0];

            for (int i = 1; i < stockPrices.length; i++) {
                int nextPrice = stockPrices[i];
                updateContinuousCount(currentPrice, nextPrice);
                currentPrice = nextPrice;
                executeTrade(currentPrice);
            }

            return asset.getTotalAsset(stockPrices[stockPrices.length - 1]);
        }

        private void updateContinuousCount(int currentPrice, int nextPrice) {
            if (nextPrice > currentPrice) {
                continuousIncreaseCount++;
                continuousDecreaseCount = 0;
            } else if (nextPrice < currentPrice) {
                continuousDecreaseCount++;
                continuousIncreaseCount = 0;
            }
        }

        private void executeTrade(int currentPrice) {
            if (continuousIncreaseCount >= CONTINUOUS_DAY) {
                asset.sell(currentPrice);
                continuousDecreaseCount = 0;
            } else if (continuousDecreaseCount >= CONTINUOUS_DAY) {
                asset.buy(currentPrice);
                continuousIncreaseCount = 0;
            }
        }
    }

    static class Asset {

        private int currentAsset;
        private int totalStocks;

        public Asset(int currentAsset, int totalStocks) {
            this.currentAsset = currentAsset;
            this.totalStocks = totalStocks;
        }

        public void buy(int stockPrice) {
            if (canBuy(stockPrice)) {
                totalStocks += currentAsset / stockPrice;
                currentAsset %= stockPrice;
            }
        }

        public void sell(int stockPrice) {
            if (totalStocks > 0) {
                currentAsset += totalStocks * stockPrice;
                totalStocks = 0;
            }
        }

        private boolean canBuy(int stockPrice) {
            return currentAsset >= stockPrice;
        }

        public int getTotalAsset(int lastStockPrice) {
            return totalStocks * lastStockPrice + currentAsset;
        }
    }
}
