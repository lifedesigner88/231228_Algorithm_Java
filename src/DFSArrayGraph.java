import java.util.Arrays;

public class DFSArrayGraph extends Print {

    public static void main(String[] args) {

        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}};
        print();
        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            dfs(graph, visited, i);
            Arrays.fill(visited, false);
            print();
        }

    } // main

    static void dfs(int[][] graph, boolean[] visited, int start){
        visited[start] = true; P(" > " + start);
        for (int i = 0; i < graph.length; i++)
            if (!visited[i] && graph[start][i] == 1)
                dfs(graph, visited, i);
    }

}
