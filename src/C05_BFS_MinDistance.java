
import java.util.*;

public class C05_BFS_MinDistance extends Print{

    public static void main(String[] args) {
        print();

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int answer = 0;

        int row = maps.length;
        int col = maps[0].length;

        for (int[] map : maps) {       // 2차원 맵 인쇄
            for (int j = 0; j < col; j++) P(map[j] + "  ");
            print();}


        int node_n = row*col;
        boolean[] visited = new boolean[node_n];
        int[] distace = new int [node_n];
        Arrays.fill(distace,1);

        List<List<Integer>> adjList = new ArrayList<>();  // 깡통 어래이
        for (int i = 0; i < node_n; i++) adjList.add(new ArrayList<>());


        print("\n[][] => 리스트 변환");
        for(int i=0; i<row; i++)
            for (int j = 0; j < col; j++) {
                if (maps[i][j] == 0) continue;
                int[] dx = {-1, 1,  0, 0};
                int[] dy = { 0, 0, -1, 1};
                for (int d = 0; d < 4; d++) {
                    int target_i = i + dx[d];
                    int target_j = j + dy[d];
                    if (    target_i >= 0 && target_i < row &&
                            target_j >= 0 && target_j < col && maps[target_i][target_j] == 1)
                        addEdge(adjList, (i) * col + j, (target_i) * col + target_j);
//                        adjList.get( (i) * col + j ).add((target_i) * col + target_j);   // 수정
                }
            }

        int count = 0;          // 리스트 인쇄
        for (List<Integer> a : adjList) print(" " + count++ +" : " + a);



//        향향시킨 리스트 변환
        adjList = new ArrayList<>();
        for (int i = 0; i < node_n; i++) adjList.add(new ArrayList<>());

        print("\n향상된 [][] => 리스트 변환");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++){
                if(maps[i][j] == 0) continue;               // 자신이 0 이면
                if( j!=(col-1) && maps[i][j+1]==1)          // (맨 오른쪽이 아니면, 오른쪽 체크)
                    addEdge(adjList, i*col + j, i*col + j+1);
                if( i!=(row-1) && maps[i+1][j]==1)          // (맨 아래쪽이 아니면, 아래 체크)
                    addEdge(adjList, i*col + j, (i+1)*col + j);
            }

        count = 0;          // 리스트 인쇄
        for (List<Integer> a : adjList) print(" " + count++ +" : " + a);


        // BFS 탐색
        answer = BFS(adjList, visited, distace, 0,24);
        print("\n 최단거리: " + answer);
    }


    static int BFS(List<List<Integer>> adjList, boolean[] visited, int[] distance, int start, int end) {
        if(start == end) return 1;
        Queue<Integer> Que = new LinkedList<>();
        visited[start] = true;
        Que.add(start);
        while(!Que.isEmpty()){
            int next = Que.poll();
            for (int taget : adjList.get(next)) {
                if (taget == end) return distance[next] + 1;
                if (!visited[taget]) {
                    distance[taget] = distance[next] + 1;
                    Que.add(taget);
                    visited[taget] = true;
                }
            }
        }return -1;
    }

    static void addEdge(List<List<Integer>> adjList, int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}



