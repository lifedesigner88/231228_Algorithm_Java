package JavaCodeTest.A_0005_Group_Anagrams;

// https://leetcode.com/problems/group-anagrams


import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {


        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[][] result = {{"bat"}, {"nat", "tan"}, {"ate", "eat", "tea"}};


        Solution solution = new Solution();
        List<List<String>> ga1 = solution.groupAnagrams(strs);
        System.out.println(Arrays.toString(ga1.toArray()));

    }
}


// ❤️ Beautiful Solution ❤️




class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
