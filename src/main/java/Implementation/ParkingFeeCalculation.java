/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 92341
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implementation;

import java.util.*;

public class ParkingFeeCalculation {

    final static String IN = "IN";
    final static String OUT = "OUT";
    final static int END_OF_DAY = 60 * 23 + 59;
    static int BASE_TIME, BASE_FEE, UNIT_TIME, UNIT_FEE;

    public int[] solution(int[] fees, String[] records) {
        init(fees);
        Map<String, Integer> cumulativeMinuteMap = getCumulativeMinuteMap(records);
        List<ParkingCar> answerList = calculateFeeEachCar(cumulativeMinuteMap);

        return getAnswer(answerList);
    }

    private Map<String, Integer> getCumulativeMinuteMap(String[] records) {
        Map<String, Integer> parkingRecordMap = new HashMap<>();
        Map<String, Integer> cumulativeMinuteMap = new HashMap<>();

        for (String record : records) {
            String[] recordArray = record.split(" ");
            int minute = getMinute(recordArray[0]);
            String carNumber = recordArray[1];
            String action = recordArray[2];

            if (action.equals(IN)) {
                parkingRecordMap.put(carNumber, minute);
            } else if (action.equals(OUT)) {
                int inMinute = parkingRecordMap.get(carNumber);
                parkingRecordMap.remove(carNumber);
                int cumulativeMinute = cumulativeMinuteMap.getOrDefault(carNumber, 0);
                int parkingTime = minute - inMinute;
                cumulativeMinuteMap.put(carNumber, cumulativeMinute + parkingTime);
            }
        }
        for (String carNumber : parkingRecordMap.keySet()) {
            int inMinute = parkingRecordMap.get(carNumber);
            int cumulativeMinute = cumulativeMinuteMap.getOrDefault(carNumber, 0);
            int parkingTime = END_OF_DAY - inMinute;
            cumulativeMinuteMap.put(carNumber, cumulativeMinute + parkingTime);
        }

        return cumulativeMinuteMap;
    }


    private int getMinute(String timeString) {
        String[] timeStringArray = timeString.split(":");
        int hour = Integer.parseInt(timeStringArray[0]);
        int minute = Integer.parseInt(timeStringArray[1]);

        return hour * 60 + minute;
    }

    private List<ParkingCar> calculateFeeEachCar(Map<String, Integer> cumulativeMinuteMap) {
        List<ParkingCar> answerList = new ArrayList<>();
        for (String carNumber : cumulativeMinuteMap.keySet()) {
            answerList.add(new ParkingCar(carNumber, calculateFee(cumulativeMinuteMap.get(carNumber))));
        }
        return answerList;
    }

    private int calculateFee(int minute) {
        if (minute <= BASE_TIME) return BASE_FEE;
        return BASE_FEE + (int) Math.ceil(((double) minute - (double) BASE_TIME) / (double) UNIT_TIME) * UNIT_FEE;
    }

    private static int[] getAnswer(List<ParkingCar> answerList) {
        Collections.sort(answerList);
        return answerList.stream().mapToInt(ParkingCar::getFee).toArray();
    }

    private void init(int[] fees) {
        BASE_TIME = fees[0];
        BASE_FEE = fees[1];
        UNIT_TIME = fees[2];
        UNIT_FEE = fees[3];
    }

    static class ParkingCar implements Comparable<ParkingCar> {
        String carNumber;
        int fee;

        public ParkingCar(String carNumber, int fee) {
            this.carNumber = carNumber;
            this.fee = fee;
        }


        public int getFee() {
            return fee;
        }

        @Override
        public int compareTo(ParkingCar other) {
            return this.carNumber.compareTo(other.carNumber);
        }
    }
}