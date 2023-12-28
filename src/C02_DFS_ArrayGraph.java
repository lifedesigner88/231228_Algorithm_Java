import java.util.Arrays;

public class C02_DFS_ArrayGraph extends Print {

    public static void main(String[] args) {
        print();

        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}};
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            DFS(graph, visited, i);
            Arrays.fill(visited, false);
            print();}

    } // main

    static void DFS(int[][] graph, boolean[] visited, int start) {
        visited[start] = true;
        P(" > " + start);
        for (int i = 0; i < graph[start].length ; i++)
            if (!visited[i] && graph[start][i] == 1)
                DFS(graph, visited, i);}

}
