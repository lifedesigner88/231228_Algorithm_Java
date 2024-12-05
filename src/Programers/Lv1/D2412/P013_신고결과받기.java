package Programers.Lv1.D2412;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class P013_신고결과받기 {
    public int[] solution1(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();

        // 신고 받은 사람 = Key, 신고한 사람들 = Value
        for (String r : report) {
            String[] temp = r.split(" ");
            String reporter = temp[0];
            String reported = temp[1];

            if (map.containsKey(reported))
                map.get(reported).add(reporter);
            else {
                Set<String> users = new HashSet<>();
                users.add(reporter);
                map.put(reported, users);
            }
        }

        // email 전송하고 카운트
        Map<String, Integer> email = new HashMap<>();
        for (Set<String> s : map.values())
            if (s.size() >= k)
                for (String u : s)
                    email.put(u, email.getOrDefault(u, 0) + 1);

        // 받은 이메일 수 삽입
        for (int i = 0; i < id_list.length; i++)
            answer[i] = email.getOrDefault(id_list[i], 0);

        return answer;
    }

    public int[] solution2(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportedMap = new HashMap<>(); // 신고당한 유저
        Map<String, Integer> idIndexMap = new HashMap<>(); // id와 인덱스 매핑

        // id_list를 미리 Map에 저장하여 인덱스 검색 속도 향상
        for (int i = 0; i < id_list.length; i++) {
            idIndexMap.put(id_list[i], i);
        }

        for (String r : report) {
            String[] temp = r.split(" ");
            String reporter = temp[0];
            String reported = temp[1];

            reportedMap.computeIfAbsent(reported, key -> new HashSet<>()).add(reporter);
        }

        for (String reportedUser : reportedMap.keySet()) {
            Set<String> reporters = reportedMap.get(reportedUser);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    // idIndexMap을 사용하여 answer 배열의 인덱스를 빠르게 찾습니다.
                    answer[idIndexMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}
