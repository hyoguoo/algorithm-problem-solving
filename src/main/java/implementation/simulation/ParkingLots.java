package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ParkingLots {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int spaceCount = info[0];
        int carCount = info[1];

        int[] kiloPerPrices = new int[spaceCount];

        for (int i = 0; i < spaceCount; i++) {
            kiloPerPrices[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Car[] cars = new Car[carCount + 1];

        for (int i = 1; i <= carCount; i++) {
            cars[i] = new Car(i, Integer.parseInt(bufferedReader.readLine()));
        }

        EntryInfo[] entryInfos = new EntryInfo[carCount * 2];

        for (int i = 0; i < entryInfos.length; i++) {
            int value = Integer.parseInt(bufferedReader.readLine());
            EntryType entryType = EntryType.of(value);
            int carIndex = Math.abs(value);

            entryInfos[i] = new EntryInfo(cars[carIndex], entryType);
        }

        System.out.print(solution(entryInfos, kiloPerPrices));
    }

    private static long solution(EntryInfo[] entryInfos, int[] kiloPerPrices) {
        ParkingLot parkingLot = new ParkingLot(kiloPerPrices);

        Arrays.stream(entryInfos)
                .forEach(parkingLot::park);

        return parkingLot.totalCost;
    }

    enum EntryType {
        IN, OUT;

        public static EntryType of(int value) {
            return value > 0 ? IN : OUT;
        }
    }

    static class ParkingLot {

        private static final int CANT_PARK = -1;
        private static final int NOT_PARKING = 0;

        private final Queue<Car> waitingQueue;
        private final int[] isParking;
        private final int[] kiloPerPrices;
        private long totalCost;

        public ParkingLot(int[] kiloPerPrices) {
            this.kiloPerPrices = kiloPerPrices;
            this.isParking = new int[kiloPerPrices.length];
            this.waitingQueue = new LinkedList<>();
        }

        public void park(EntryInfo entryInfo) {
            switch (entryInfo.entryType) {
                case IN:
                    Car car = entryInfo.car;
                    if (!parkCar(car)) {
                        waitingQueue.add(car);
                    }
                    break;
                case OUT:
                    leaveCar(entryInfo.car);
                    while (!waitingQueue.isEmpty() && parkCar(waitingQueue.peek())) {
                        parkCar(waitingQueue.poll());
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        private boolean parkCar(Car car) {
            int parkingSpace = findFirstEmptySpaceIndex();
            if (parkingSpace == CANT_PARK) {
                return false;
            }
            isParking[parkingSpace] = car.carIndex;
            return true;
        }

        private void leaveCar(Car car) {
            int parkingSpace = findCarParkingIndex(car.carIndex);
            isParking[parkingSpace] = NOT_PARKING;
            addCost(car, parkingSpace);
        }

        private void addCost(Car car, int parkingSpace) {
            totalCost += (long) kiloPerPrices[parkingSpace] * car.weight;
        }

        private int findFirstEmptySpaceIndex() {
            for (int i = 0; i < isParking.length; i++) {
                if (isParking[i] == NOT_PARKING) {
                    return i;
                }
            }

            return CANT_PARK;
        }

        private int findCarParkingIndex(int carIndex) {
            for (int i = 0; i < isParking.length; i++) {
                if (isParking[i] == carIndex) {
                    return i;
                }
            }

            return CANT_PARK;
        }
    }

    static class Car {

        private final int carIndex;
        private final int weight;

        public Car(int carIndex, int weight) {
            this.carIndex = carIndex;
            this.weight = weight;
        }
    }

    static class EntryInfo {

        private final Car car;
        private final EntryType entryType;

        public EntryInfo(Car car, EntryType entryType) {
            this.car = car;
            this.entryType = entryType;
        }
    }
}
