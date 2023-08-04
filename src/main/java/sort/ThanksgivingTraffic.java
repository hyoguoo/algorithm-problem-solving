/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 17676
 * Cheat Level: 0
 * Algorithm: Sort / Implementation
 */

package sort;

import java.util.ArrayList;
import java.util.List;

public class ThanksgivingTraffic {

    public static void main(String[] args) {
        ThanksgivingTraffic thanksgivingTraffic = new ThanksgivingTraffic();
        System.out.println(thanksgivingTraffic.solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}));
    }

    public int solution(String[] lines) {
        List<Request> requestList = new ArrayList<>();
        for (String line : lines) requestList.add(new Request(line));
        requestList.sort(Request::compareTo);

        int max = 0;
        for (int i = 0; i < requestList.size(); i++) {
            int count = 0;
            int startTime = requestList.get(i).endTime;
            int endTime = startTime + 1000;
            for (int j = i; j < requestList.size(); j++) {
                Request nextRequest = requestList.get(j);
                if (nextRequest.startTime < endTime) count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    static class Request implements Comparable<Request> {
        int startTime;
        int endTime;

        public Request(String line) {
            String[] split = line.split(" ");
            String[] time = split[1].split(":");
            int endTime = Integer.parseInt(time[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(time[1]) * 60 * 1000;
            endTime += (int) (Double.parseDouble(time[2]) * 1000);
            this.endTime = endTime;
            this.startTime = endTime - (int) (Double.parseDouble(split[2].substring(0, split[2].length() - 1)) * 1000) + 1;
        }

        @Override
        public int compareTo(Request o) {
            return this.endTime - o.endTime;
        }
    }
}
