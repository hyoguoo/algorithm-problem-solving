/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11650
 * Cheat Level: 0
 * Algorithm: Sort
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

interface Coordinate extends Comparable<Coordinate> {
    int getX();

    int getY();

    void print();

}

public class CoordinatesSort {

    static final List<Coordinate> coordinateList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = numberArray[0];
            int y = numberArray[1];
            coordinateList.add(new Coordinate2(x, y));
        }
        Collections.sort(coordinateList);

        for (Coordinate coordinate : coordinateList) coordinate.print();

    }
}

class Coordinate1 implements Comparable<Coordinate>, Coordinate {
    private final int x;
    private final int y;

    public Coordinate1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void print() {
        System.out.println(this.getX() + " " + this.getY());
    }

    @Override
    public int compareTo(Coordinate coordinate) {
        if (this.getX() != coordinate.getX()) return this.getX() - coordinate.getX();
        else return this.getY() - coordinate.getY();
    }
}

class Coordinate2 implements Comparable<Coordinate>, Coordinate {
    private final int x;
    private final int y;

    public Coordinate2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void print() {
        System.out.println(this.getX() + " " + this.getY());
    }

    @Override
    public int compareTo(Coordinate coordinate) {
        if (this.getY() != coordinate.getY()) return this.getY() - coordinate.getY();
        else return this.getX() - coordinate.getX();
    }
}
