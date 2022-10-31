/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 4주차 문제 1
 */

package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class CheckCard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Account account = new Account(numbers[0]);
        int length = numbers[1];

        for (int i = 0; i < length; i++) {
            String[] actions = bufferedReader.readLine().split(" ");
            String action = actions[0];
            int amount = Integer.parseInt(actions[1]);

            account.action(action, amount);
        }

        System.out.println(account.getMoney());
    }
}

class Account {

    private static final String DEPOSIT = "deposit";
    private static final String PAY = "pay";
    private static final String RESERVATION = "reservation";

    private int money;
    private final Queue<Integer> reservation;

    public Account(int money) {
        this.money = money;
        this.reservation = new ArrayDeque<>();
    }

    public void action(String action, int amount) {
        switch (action) {
            case DEPOSIT:
                this.depositMoney(amount);
                break;
            case PAY:
                this.payMoney(amount);
                break;
            case RESERVATION:
                this.addReservation(amount);
                break;
        }
        this.payReservation();
    }

    public int getMoney() {
        return this.money;
    }

    private void depositMoney(int money) {
        this.money += money;
    }

    private void payMoney(int money) {
        if (this.getMoney() >= money) this.money -= money;
    }

    private void addReservation(int amount) {
        this.reservation.add(amount);
    }

    private void payReservation() {
        while (this.isValidPayReservation()) {
            this.payFirstReservation();
        }
    }

    private boolean isValidPayReservation() {
        if (this.reservation.isEmpty()) return false;
        return this.getMoney() >= this.getFirstReservation();
    }

    private int getFirstReservation() {
        return this.reservation.element();
    }

    private void payFirstReservation() {
        this.payMoney(this.reservation.remove());
    }

}
