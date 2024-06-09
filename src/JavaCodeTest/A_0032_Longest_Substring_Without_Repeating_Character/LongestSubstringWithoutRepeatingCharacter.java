package JavaCodeTest.A_0032_Longest_Substring_Without_Repeating_Character;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {

        String s = "abcabcbb";

        MapLeftPointer MLP = new MapLeftPointer();
        System.out.println(MLP.lengthOfLongestSubstring(s));

        WhileLeftPointer WLP = new WhileLeftPointer();
        System.out.println(WLP.lengthOfLongestSubstring(s));

    }
}


// ❤️ Beautiful Solution ❤️

class MapLeftPointer {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int maxLength = 0;

        Map<Character, Integer> used = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (used.containsKey(c) && left <= used.get(c))
                left = used.get(c) + 1;
            else
                maxLength = Math.max(maxLength, right - left + 1);
            used.put(c, right);
            right++;
        }
        return maxLength;

    }
}


class WhileLeftPointer {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int maxLength = 0;

        Map<Character, Integer> used = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            used.put(c, used.getOrDefault(c, 0) + 1);
            while (used.get(c) > 1) {
                char dupli = s.charAt(left);
                used.put(dupli, used.get(dupli) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}