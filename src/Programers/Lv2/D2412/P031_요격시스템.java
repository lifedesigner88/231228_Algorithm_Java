package Programers.Lv2.D2412;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/181188
public class P031_요격시스템 {

    // 격추 할 수 있는 미사일 ID 정보 < x 좌표 , 미사일 Id 정보>
    private final Map<Integer, Set<Integer>> map = new HashMap<>();
    private int[][] targets;

    public int solution1(int[][] targets) {
        this.targets = targets;

        for (int i = 0; i < targets.length; i++)
            addMisail(i); // 미사일 삽입

        int counter = 0;
        while (!map.isEmpty()) {
            Set<Integer> max = new HashSet<>(getMaxValue()); // 순회를 위해 복제.
            for (Integer id : max)
                deleteMisail(id);    // 미사일 삭제
            counter++;                                  // 삭제 한 미사일 카운트
        }

        return counter;
    }

    // 미사일 등록
    private void addMisail(int id) {
        int start = targets[id][0];
        int end = targets[id][1];
        for (int m = start + 1; m <= end; m++)
            map.computeIfAbsent(m, key -> new HashSet<>()).add(id);
    }

    // 미사일 제거
    private void deleteMisail(int id) {
        int start = targets[id][0];
        int end = targets[id][1];
        for (int m = start + 1; m <= end; m++)
            map.computeIfPresent(m, (key, value) -> {
                if (value.size() == 1 && value.contains(id))
                    return null;
                else
                    value.remove(id);
                return value;
            });
    }

    // 최대 리스트 반환
    private Set<Integer> getMaxValue() {
        return map.values().stream()
                .max(Comparator.comparingInt(Set::size))
                .orElse(null);
    }



//✅ 요격시스템
    public int solution2(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(i -> i[1]));

        int count = 0;
        double cannon = -1;

        for (int[] t : targets) {
            int start = t[0];
            int end = t[1];
            if (cannon < start) {
                count++;
                cannon = end - 0.5;
            }
        }

        return count;
    }
}
