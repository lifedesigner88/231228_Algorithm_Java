import java.util.*;

public class C05_BFS_Temp extends Print {

        public static void main(String[] args) {

            print();

            int[][] graph = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
            List<List<Integer>> adjList = new ArrayList<>();
            int node_n = 5;
            boolean[] visited = new boolean[node_n];
            int[] distace = new int [node_n];

            for (int i = 0; i < node_n; i++)
                adjList.add(new ArrayList<>());

//            for(int i
//              for (int 1

//                  1) 시작노드 표현식
//                  2) 타겟의 번호와 타겟의 유효성(2)
//                  2-1) 타겟의 번호
//                  2-2) i와 ㅓ 가 상하좌우 길이 체크

//                상하좌우 체크 로직,
//            for (int i = 1; i <= 3; i++)
//                for (int j = 1; j <= 5; j++) {
//                    int[] dx = {-1, 1, 0, 0};
//                    int[] dy = {0, 0, -1, 1};
//                    for (int d = 0; d < 4; d++) {
//                        int target_i = i + dx[d];
//                        int target_j = j + dy[d];
//                        if (target_i >= 1 && target_i <= 3 && target_j >= 1 && target_j <= 5) {
//                            addEdge(adjList,(i - 1) * 5 + j, (target_i - 1) * 5 + target_j);
//                        }
//                    }
//                }

            for (int[] a : graph)
                addEdge(adjList, a[0], a[1]);


            print("최단거리 리턴: " + BFS(adjList, visited, distace,0,4));

            print(adjList);
            print(Arrays.toString(distace));



        } // main

        static int BFS(List<List<Integer>> adjList, boolean[] visited, int[] distance, int start, int end) {
            if(start == end) return 0;
            Queue<Integer> Que = new LinkedList<>();
            visited[start] = true;
            Que.add(start);
            while(!Que.isEmpty()){
                int next = Que.poll();
                P(" > " + next);
                for (int taget : adjList.get(next)) {
                    if (taget == end) return distance[next] + 1;
                    if (!visited[taget]) {
                        distance[taget] = distance[next] + 1;
                        Que.add(taget);
                        visited[taget] = true;
                    }
                }
            }print();
            return -1;
        }



        static void addEdge(List<List<Integer>> adjList, int a, int b) {
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }


}
