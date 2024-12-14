package Programers.Lv2.D2412;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/258711
public class P027_도넛과막대그래프 {

    public int[] solution0(int[][] edges) {
        Map<Integer, Integer> outMap = new HashMap<>();
        Map<Integer, Integer> inMap = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();

        for (int[] i : edges) {
            int start = i[0];
            int desti = i[1];
            outMap.merge(start, 1, Integer::sum); // 나가는 간선 개수
            inMap.merge(desti, 1, Integer::sum);  // 들어오는 간선의 개수
            nodes.add(start); // 존재하는 모든 노드 수
            nodes.add(desti);
        }

        int[] answer = new int[4]; //  정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수
        for (Integer n : nodes) {
            if (outMap.get(n) == null)
                answer[2]++; // 막대모양
            else if (!inMap.containsKey(n) && outMap.get(n) > 1) { // 센터 노드, in = 0 , out > 1;
                answer[0] = n;
                answer[1] = outMap.get(n);    // 총 그래프 수
            } else if (outMap.get(n) == 2)   // in 2~3 개, out 2개
                answer[3]++;
        }

        answer[1] = answer[1] - answer[2] - answer[3];
        return answer;
    }


    /*
     *
     * 시간초과 풀이 초안.
     *
     * */
    private Set<Integer> nodes = new HashSet<>(); // 노드들
    private Map<Integer, Set<Integer>> path = new HashMap<>(); // 연결 정보

    public int[] solution1(int[][] edges) {
        int[] answer = new int[4];

        for (int[] e : edges) {
            nodes.add(e[0]);
            nodes.add(e[1]);
            path.computeIfAbsent(e[0], key -> new HashSet<>()).add(e[1]); // 연결 정보
        }

        for (Integer i : path.keySet()) // 중앙노드 찿기
            if (in(i) == 0 && out(i) > 1) {
                answer[0] = i;
                break;
            }

        int totalGraph = out(answer[0]); // 노드 연결 갯수
        nodes.remove(answer[0]); // 중앙 노드 삭제.
        path.remove(answer[0]); // 연결 노드 삭제

        for (Integer i : path.keySet()) {
            int inPath = in(i);
            int outPath = out(i);
            nodes.remove(i);
            if (inPath == 2 && outPath == 2) answer[3]++;  // 도너츠 중심 노드
        }

        for (Integer i : nodes) {
            if (out(i) == 0) answer[2]++; // 막대 마지막 노드
        }

        answer[1] = totalGraph - answer[2] - answer[3]; // 전체 노드 갯수에서 도너츠, 막대 삭제
        return answer;
    }

    private int out(int num) { // 나가는 연결 카운트
        if (path.containsKey(num))
            return path.get(num).size();
        return 0;
    }

    private int in(int num) { // 들어오는 연결 카운트
        int sum = 0;
        if (path.containsKey(num))
            for (Set<Integer> s : path.values())
                if (s.contains(num) && ++sum == 2) // 2개 이상이면 리턴.
                    return 2;
        return sum;
    }


}