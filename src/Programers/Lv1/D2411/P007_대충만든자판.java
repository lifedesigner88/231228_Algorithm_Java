package Programers.Lv1.D2411;
import java.util.*;


//https://school.programmers.co.kr/learn/courses/30/lessons/160586

// 나의 플이 코드.
class Solution7 {

    String[] keymap;
    Map<Character, Integer> map = new HashMap<>();

    public int[] solution(String[] keymap, String[] targets) {
        this.keymap = keymap;

        return Arrays.stream(targets)
                .mapToInt(this::totalTouch)
                .toArray();
    }

    // 최소 터치 수 리턴
    private int minimumTouch(char c) {
        for (String s : keymap)
            for (int i = 0; i < Math.min(map.getOrDefault(c, Integer.MAX_VALUE), s.length()); i++) {
                if (s.charAt(i) == c) map.put(c, i + 1);
                if (map.get(c) != null && map.get(c) == 1) return 1; // 1 등장하면 종료.
            }
        return map.get(c) == null ? -1 : map.get(c); // map.containsKey()
    }

    // 입력해야할 토탈 횟수 계산
    private int totalTouch(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = minimumTouch(s.charAt(i));
            if (temp == -1) return -1;
            sum += temp;
        }
        return sum;
    }

}




// AI 최적화 코드
public class P007_대충만든자판 {

    private final Map<Character, Integer> map = new HashMap<>();

    public int[] solution(String[] keymap, String[] targets) {
        // Initialize the map with minimum touch positions
        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char c = keys.charAt(i);
                map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), i + 1));
            }
        }

        // Calculate total touch for each target
        return Arrays.stream(targets)
                .mapToInt(this::totalTouch) // 💖 this :: 문법.
                .toArray();
    }

    // Calculate total touch for a given string
    private int totalTouch(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {   // 💖 toCharArry() **
            Integer touches = map.get(c);
            if (touches == null) {   // 💖map.containsKey() 문법 고려.
                // If a character is not found in any keymap
                return -1;
            }
            sum += touches;
        }
        return sum;
    }
}

// Test case for the P007_대충만든자판 class
class P007_대충만든자판Test {
    public static void main(String[] args) {
        P007_대충만든자판 solution = new P007_대충만든자판();

        // Test case 1
        String[] keymap = {"abc", "def", "ghi"};
        String[] targets = {"adg", "fg", "hi"};
        int[] result = solution.solution(keymap, targets);
        System.out.println(Arrays.toString(result)); // Expected output: [7, 5, 5]

        // Test case 2
        String[] keymap2 = {"abcde"};
        String[] targets2 = {"ed", "bc", "aez"};
        int[] result2 = solution.solution(keymap2, targets2);
        System.out.println(Arrays.toString(result2)); // Expected output: [8, 5, -1]

        // Test case 3
        String[] keymap3 = {"acxz"};
        String[] targets3 = {"za", "cx", "zx"};
        int[] result3 = solution.solution(keymap3, targets3);
        System.out.println(Arrays.toString(result3)); // Expected output: [5, 4, 7]
    }
}