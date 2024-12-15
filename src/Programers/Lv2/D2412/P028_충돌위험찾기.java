package Programers.Lv2.D2412;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/340211
public class P028_충돌위험찾기 {

    private int[][] points;

    public int solution(int[][] points, int[][] routes) {
        this.points = points;

        List<List<int[]>> lists = new ArrayList<>();

        for (int[] r : routes) {
            List<int[]> list = new ArrayList<>();
            int[] tempPoint = points[r[0] - 1];
            list.add(tempPoint.clone()); // 첫 시작위치 지정.
            for (int i = 0; i < r.length - 1; i++)
                calrouteAtoB(r[i], r[i + 1], list); // A 부터 B 까지 경로 List 에 저장.
            lists.add(list);
        }

        int answer = 0;

        // 경로의 최대길이 조사.
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (List<int[]> list : lists) pq.offer(list.size());
        pq.poll(); // 제일 긴 것 제외
        int maxlength = pq.poll(); // 다음 긴 것.

//        Map<List<Integer>, Integer> collisionMap = new HashMap<>(); 키를 이런식으로 만들 수 있음.
//        List<Integer> keyList = Arrays.asList(point[0], point[1]);


        Map<String, Integer> map = new HashMap<>();
        for (int t = 0; t < maxlength; t++) { // 시간 축t
            map.clear();
            for (List<int[]> tempList : lists) {
                if (t < tempList.size()) {
                    int[] temp = tempList.get(t);
                    String key = Arrays.toString(temp);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            // 2회 이상 충돌한 포인트 누적 합.
            answer += (int) map.values().stream().filter(a -> a >= 2).count();
        }
        return answer;
    }

    // 두개의 routes 좌표가 주어졌을 때 이동경로를 List 로 출력하는 함수
    private void calrouteAtoB(int a, int b, List<int[]> list) {

        int sR = points[a - 1][0];
        int eR = points[b - 1][0];
        int sC = points[a - 1][1];
        int eC = points[b - 1][1];

        while (sR != eR)
            list.add(new int[]{sR < eR ? ++sR : --sR, sC});
        while (sC != eC)
            list.add(new int[]{eR, sC < eC ? ++sC : --sC});
    }
}
