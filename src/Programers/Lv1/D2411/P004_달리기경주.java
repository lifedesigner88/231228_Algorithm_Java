package Programers.Lv1.D2411;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871
public class P004_달리기경주 {


    // 시간초과
    public static String[] solution(String[] players, String[] callings) {

        List<String> temp = new ArrayList<>(List.of(players));

        for (String c : callings) {
            int target = temp.indexOf(c);
            temp.set(target, temp.get(target - 1));
            temp.set(target - 1, c);
        }

        return temp.toArray(new String[0]);
    }

    // 시간초과
    public static String[] solution2(String[] players, String[] callings) {

        for (String c : callings)
            for (int i = 0; i < players.length; i++)
                if (c.equals(players[i])) {
                    players[i] = players[i - 1];
                    players[i - 1] = c;
                }

        return players;
    }

    public static String[] solution3(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();

        int index = 0; // 인댁스 검색속도 향상을 위한 Map 사용
        for (String p : players) map.put(p, index++);

        for (String c : callings) {
            int callIndex = map.get(c);
            int targetIndex = callIndex - 1;

            // 위치 변경
            String targetPlayer = players[targetIndex];
            players[callIndex] = players[targetIndex];
            players[targetIndex] = c;

            // 인덱스 수정
            map.put(c, targetIndex);
            map.put(targetPlayer, callIndex);
        }

        return players;
    }



    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] result = solution3(players, callings);
        System.out.println(Arrays.toString(result));
    }


}

