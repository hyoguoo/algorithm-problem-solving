/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1012
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OrganicCabbage {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = infos[0];
            int N = infos[1];
            int cabbageCount = infos[2];
            List<Cabbage> cabbageList = new ArrayList<>();
            for (int j = 0; j < cabbageCount; j++) {
                int[] cabbage = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                cabbageList.add(new Cabbage(cabbage[0], cabbage[1]));
            }
            int count = cabbageTravel(cabbageList, M, N);
            System.out.println(count);
        }
    }

    private static int cabbageTravel(List<Cabbage> cabbageList, int m, int n) {
        int count = 0;
        Queue<Cabbage> visitCabbage = new LinkedList<>();

        while (!cabbageList.isEmpty()) {
            visitCabbage.add(cabbageList.remove(0));
            count++;
            while (!visitCabbage.isEmpty()) {
                travelCabbage(cabbageList, visitCabbage, m, n);
            }
        }

        return count;
    }

    private static void travelCabbage(List<Cabbage> cabbageList, Queue<Cabbage> visitCabbage, int m, int n) {
        Cabbage cabbage = visitCabbage.remove();
        int x = cabbage.x;
        int y = cabbage.y;

        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                Cabbage adjacencyCabbage = findCabbageIndex(cabbageList, nx, ny);
                if (adjacencyCabbage != null) {
                    visitCabbage.add(adjacencyCabbage);
                    cabbageList.remove(adjacencyCabbage);
                }
            }
        }
    }

    private static Cabbage findCabbageIndex(List<Cabbage> cabbageList, int x, int y) {
        for (Cabbage cabbage : cabbageList) {
            if (cabbage.x == x && cabbage.y == y) return cabbage;
        }

        return null;
    }
}

class Cabbage {

    public final int x;
    public final int y;

    public Cabbage(int x, int y) {
        this.x = x;
        this.y = y;
    }
}