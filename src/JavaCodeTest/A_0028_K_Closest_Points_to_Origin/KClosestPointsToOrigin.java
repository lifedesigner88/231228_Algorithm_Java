package JavaCodeTest.A_0028_K_Closest_Points_to_Origin;

import java.util.*;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {


        UsePointClass usePointClass = new UsePointClass();
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {-1, 2}};
        int k = 2;
        int[][] closestPoints = usePointClass.kClosest(points, k);
        System.out.println(Arrays.deepToString(closestPoints));

        PQCustom pqCustom = new PQCustom();
        int[][] closestPointsCustom = pqCustom.kClosest(points, k);
        System.out.println(Arrays.deepToString(closestPointsCustom));

    }
}



// ❤️ Beautiful Solution ❤️


class UsePointClass {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pQue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.distance));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int distance = x * x + y * y;
            pQue.add(new Point(distance, point));
        }

        int [][] results = new int[k][];
        for (int i = 0; i < k; i++)
            results[i] = Objects.requireNonNull(pQue.poll()).point;

        return results;

    }
    static class Point {
        int distance;
        int[] point;

        public Point(int distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }
}


class PQCustom {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pQue = new PriorityQueue<>(
                (o1, o2) -> {
                    int Do1 = o1[0] * o1[0] + o1[1] * o1[1];
                    int Do2 = o2[0] * o2[0] + o2[1] * o2[1];
                    return Do1 - Do2;
                });
        Collections.addAll(pQue, points);

        int [][] results = new int[k][];
        for (int i = 0; i < k; i++)
            results[i] = Objects.requireNonNull(pQue.poll());
        return results;

    }
}