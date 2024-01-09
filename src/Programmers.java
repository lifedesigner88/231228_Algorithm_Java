import java.util.*;

public class Programmers extends Print{
    public static void main(String[] args) {



        int[] arr[] = new int[2][5];

        print(Arrays.deepToString(arr));



        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);

        BFS g2 = new BFS(4);

        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(2, 0);
        g2.addEdge(2, 3);
        g2.addEdge(3, 3);

        System.out.println("Breadth First Traversal (starting from vertex 2)");

        g2.BFS(2);


        ArrayList[] arr2 = new ArrayList[3];

        arr2[0] = new ArrayList<Integer>();
        arr2[0].add(1);

    }

}

class Solution {
    public String[] solution(String[] quiz) {
        int length = quiz.length;
        String[] answer = new String[length];

        for (int i = 0; i < length; i++){
            String[] temp = quiz[i].split(" ");
            int[] num = new int[3];
            for (int j = 0; j < 3; j++)
                num[j] = Integer.parseInt(temp[j]) ;
            if (temp[1].equals("+") && num[0] + num[1] == num[2])
                answer[i] = "O";
            else if (temp[1].equals("-") && num[0] - num[1] == num[2])
                answer[i] = "O";
            else
                answer[i] = "X";
        }

        return answer;
    }
}


class DFS {
    private int V; // No. of vertices
    private final LinkedList<Integer>[] adj; //Adjacency Lists

    // Constructor
    DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v+" ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

}

class DepthFirstSearch {
    private final int totalVertices; // No. of vertices
    private final List<Integer>[] adjacencyLists; // Adjacency Lists

    // Constructor
    DepthFirstSearch(int totalVertices) {
        this.totalVertices = totalVertices;
        adjacencyLists = new List[totalVertices];
        for (int i = 0; i < totalVertices; ++i)
            adjacencyLists[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjacencyLists[v].add(w);
    }

    // The function to do DFS traversal.
    void depthFirstTraversal(int v) {
        boolean[] visited = new boolean[totalVertices];
        traverseDepthFirst(v, visited);
    }

    // Function used for DFS traversal
    private void traverseDepthFirst(int v, boolean[] visitedMarkers) {
        markAsVisited(v, visitedMarkers);

        for (int n : adjacencyLists[v]) {
            if (!visitedMarkers[n])
                traverseDepthFirst(n, visitedMarkers);
        }
    }

    // Function to mark a node as visited
    private void markAsVisited(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
    }
}




class BFS {
    private int V;
    private LinkedList<Integer> adj[];

    BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}