/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 150369
 * Cheat Level: 0
 * Algorithm: Greedy / Implementation
 */

package Greedy;

public class CourierDeliveryAndCollection {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long distance = 0;
        int availablePickup = 0;
        int availableDelivery = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > availableDelivery || pickups[i] > availablePickup) {
                double countOfPoint = getCountOfPoint(cap, Math.max(deliveries[i] - availableDelivery, pickups[i] - availablePickup));
                distance += getDistance(i, (long) countOfPoint);
                availableDelivery += cap * countOfPoint;
                availablePickup += cap * countOfPoint;
            }
            availableDelivery -= deliveries[i];
            availablePickup -= pickups[i];
        }

        return distance;
    }
    private double getCountOfPoint(int cap, double need) {
        return Math.ceil(need / cap);
    }

    private static long getDistance(int i, long countOfPoint) {
        return countOfPoint * (i + 1) * 2;
    }
}
