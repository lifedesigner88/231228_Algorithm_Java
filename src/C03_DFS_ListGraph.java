import java.util.ArrayList;
import java.util.List;

public class C03_DFS_ListGraph extends Print{
    public static void main(String[] args) {
        print();

        int[][] graph = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        List<List<Integer>> adjList = new ArrayList<>();
        int node_n = 5;
        boolean[] visited = new boolean[node_n];

        for (int i = 0; i < node_n; i++)
            adjList.add(new ArrayList<>());

        for (int[] a : graph){
            addEdge(adjList,a[0],a[1]);}

        DFS(adjList, visited, 0);
        print(adjList);

    } // main

    static void DFS(List<List<Integer>> adjList, boolean[] visited, int start) {
        visited[start] = true;
        P(" > " + start);
        for (Integer target : adjList.get(start)) {
            if(!visited[target])
                DFS(adjList,visited,target);}
        }

    static void addEdge(List<List<Integer>> adjList, int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

}
