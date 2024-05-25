package JavaCodeTest.A_0004_Most_CommoneWord;

// https://leetcode.com/problems/most-common-word

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Most_CommoneWord {
    public static void main(String[] args) {

    }
}


class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String symbols = " !?',;.";

        int n = paragraph.length();
        for (int i = 0; i < n; i++) {
            String oneStr = Character.toString(paragraph.charAt(i));
            if (!symbols.contains(oneStr)) {
                sb.append(oneStr);
                if (i == n - 1) {
                    String temp = sb.toString().toLowerCase();
                    addToMap(map, temp, banned, sb);
                }
            } else  {
                String temp = sb.toString().toLowerCase();
                addToMap(map, temp, banned, sb);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    void addToMap(Map<String, Integer> map, String temp, String[] banned, StringBuilder sb) {
        if (temp != null) {
            if (Arrays.stream(banned).noneMatch(v -> v.equals(temp))) {
                Integer count = map.get(temp);
                if (count == null) count = 0;
                map.put(temp, count + 1);
            }
            sb.delete(0, sb.length());
        }
    }
}