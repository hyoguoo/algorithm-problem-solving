package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindSuccessfulCandidate {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testLength = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testLength; i++) {
            int studentLength = Integer.parseInt(bufferedReader.readLine());
            String[] inputString = bufferedReader.readLine().split(" ");
            List<Integer> inputNumberList = new ArrayList<>();
            for (String s : inputString) {
                inputNumberList.add(Integer.parseInt(s));
            }
            System.out.println(solution(inputNumberList));
        }
    }

    public static String solution(List<Integer> list) {
        double average = average(list);
        int length = list.size();
        int count = 0;
        for (Integer num : list) {
            if (num >= average) count++;
        }
        return count + "/" + length;
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public static double average(List<Integer> list) {
        return (double) sum(list) / list.size();
    }
}

