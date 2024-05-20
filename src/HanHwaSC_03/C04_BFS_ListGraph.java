package HanHwaSC_03;

import java.util.*;

public class C04_BFS_ListGraph extends Print {
    public static void main(String[] args) {
        print();

        List<List<Integer>> adjList = new ArrayList<>();
        int[][] graph = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        int node_n = 5;
        boolean[] visited = new boolean[node_n];
        int[] distace = new int [node_n];

        for (int i = 0; i < node_n; i++)
            adjList.add(new ArrayList<>());

        for (int[] a : graph)
            addEdge(adjList, a[0], a[1]);

        P("0부터 BFS 탐색한 순서 : \t\t");
        BFS(adjList, visited, distace,0);       // BFS 탐색

        print("제공된 리스트 형식 : \t\t" + Arrays.deepToString(graph));
        print("리스트에 삽입된 형식 : \t" + adjList);
        print("각 노드의 거리 : \t\t\t" + Arrays.toString(distace));

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


