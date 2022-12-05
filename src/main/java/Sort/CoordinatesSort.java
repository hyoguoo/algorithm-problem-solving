/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11650
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoordinatesSort {

    static final List<Coordinate> coordinateList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = numberArray[0];
            int y = numberArray[1];
            coordinateList.add(new Coordinate(x, y));
        }
        Collections.sort(coordinateList);

        for (Coordinate coordinate : coordinateList) coordinate.print();

    }
}

class Coordinate implements Comparable<Coordinate> {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
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
