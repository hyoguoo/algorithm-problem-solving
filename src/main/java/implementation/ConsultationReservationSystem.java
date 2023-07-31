/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: -
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsultationReservationSystem {

    final static int PROCESSING_TIME = 10;
    final static int DAY_MINUTES = 60 * 24;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConsultationReservationSystem().solution(new String[][]{{"09:10", "lee"}}, new String[][]{{"09:00", "kim"}, {"09:05", "bae"}})));
    }

    public String[] solution(String[][] booked, String[][] unbooked) {
        List<Customer> bookedCustomerList = getCustomerList(booked);
        List<Customer> unbookedCustomerList = getCustomerList(unbooked);
        List<String> processingOrderList = getProcessingOrderList(bookedCustomerList, unbookedCustomerList);

        return processingOrderList.toArray(new String[0]);
    }

    private List<Customer> getCustomerList(String[][] customers) {
        List<Customer> customerList = new ArrayList<>();
        for (String[] customer : customers) {
            String[] times = customer[0].split(":");
            customerList.add(new Customer(customer[1], Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1])));
        }
        return customerList;
    }

    private List<String> getProcessingOrderList(List<Customer> bookedCustomerList, List<Customer> unbookedCustomerList) {
        List<String> processingOrderList = new ArrayList<>();
        int currentTime = 0;
        do {
            if (processingCustomer(bookedCustomerList, processingOrderList, currentTime)) {
                currentTime += PROCESSING_TIME;
                continue;
            }
            if (processingCustomer(unbookedCustomerList, processingOrderList, currentTime)) {
                currentTime += PROCESSING_TIME;
                continue;
            }

            currentTime++;
        } while (currentTime < DAY_MINUTES);

        return processingOrderList;
    }

    private boolean processingCustomer(List<Customer> customerList, List<String> processingOrderList, int currentTime) {
        for (Customer customer : customerList) {
            if (customer.time <= currentTime) {
                processingOrderList.add(customer.name);
                customerList.remove(customer);
                return true;
            }
        }
        return false;
    }

    static class Customer {
        String name;
        int time;

        public Customer(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
}
