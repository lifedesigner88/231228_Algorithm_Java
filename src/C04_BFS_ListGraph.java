import java.util.*;

public class C04_BFS_ListGraph extends Print {
    public static void main(String[] args) {

        print();

        int[][] graph = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        List<List<Integer>> adjList = new ArrayList<>();
        int node_n = 5;
        boolean[] visited = new boolean[node_n];
        int[] distace = new int [node_n];

        for (int i = 0; i < node_n; i++)
            adjList.add(new ArrayList<>());

        for (int[] a : graph)
            addEdge(adjList, a[0], a[1]);


        BFS(adjList, visited, distace,0);

        print(adjList);
        print(Arrays.toString(distace));

        int count = 0;

    } // main

    static void BFS(List<List<Integer>> adjList, boolean[] visited, int[] distance, int start) {
        Queue<Integer> Que = new LinkedList<>();
        visited[start] = true;
        Que.add(start);
        while(!Que.isEmpty()){
            int next = Que.poll();
            P(" > " + next);
            for (int taget : adjList.get(next))
                if(!visited[taget]){
                    distance[taget] = distance[next] +1;
                    Que.add(taget);
                    visited[taget] = true;}
        }print();
    }


    static void addEdge(List<List<Integer>> adjList, int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}


