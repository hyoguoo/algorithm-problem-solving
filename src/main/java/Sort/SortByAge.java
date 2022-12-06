/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10814
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByAge {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String[] info = bufferedReader.readLine().split(" ");
            people.add(new Person(Integer.parseInt(info[0]), info[1]));
        }

        Collections.sort(people);
        for (Person person : people) person.printInfo();
    }
}

class Person implements Comparable<Person> {
    private final int age;
    private final String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;

    }

    public void printInfo() {
        System.out.println(age + " " + name);
    }
}