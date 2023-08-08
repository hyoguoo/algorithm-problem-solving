/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: -
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

public class Pandemic {

    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Pandemic pandemic = new Pandemic();
        System.out.println(pandemic.solution(3, 4, 2, new int[][]{{3, 2}, {3, 2}, {2, 2}, {3, 2}, {1, 4}, {3, 2}, {2, 3}, {3, 1}}));
    }

    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] graph = new int[rows][columns];

        for (int[] query : queries) {
            int row = query[0] - 1;
            int column = query[1] - 1;
            int value = graph[row][column];
            boolean[][] visited = new boolean[rows][columns];
            visited[row][column] = true;
            if (value == max_virus) spreadVirus(graph, row, column, max_virus, visited);
            else graph[row][column]++;
        }

        return graph;
    }

    private void spreadVirus(int[][] graph, int row, int column, int max_virus, boolean[][] visited) {
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextColumn = column + direction[1];
            if (isInGraph(nextRow, nextColumn, graph) && !visited[nextRow][nextColumn]) {
                visited[nextRow][nextColumn] = true;
                if (graph[nextRow][nextColumn] == max_virus) spreadVirus(graph, nextRow, nextColumn, max_virus, visited);
                else graph[nextRow][nextColumn]++;
            }
        }
    }

    private boolean isInGraph(int row, int column, int[][] graph) {
        return row >= 0 && row < graph.length && column >= 0 && column < graph[0].length;
    }
}
