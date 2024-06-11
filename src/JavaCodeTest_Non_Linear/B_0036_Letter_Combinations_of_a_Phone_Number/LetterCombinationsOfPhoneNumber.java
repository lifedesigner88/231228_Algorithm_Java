package JavaCodeTest_Non_Linear.B_0036_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {

        String digits = "23";
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);

    }
}


// ❤️ Beautiful Solution ❤️


class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;

        Map<Character, List<Character>> dic = new HashMap<>();

        dic.put('2', List.of('a', 'b', 'c'));
        dic.put('3', List.of('d', 'e', 'f'));
        dic.put('4', List.of('g', 'h', 'i'));
        dic.put('5', List.of('j', 'k', 'l'));
        dic.put('6', List.of('m', 'n', 'o'));
        dic.put('7', List.of('p', 'q', 'r', 's'));
        dic.put('8', List.of('t', 'u', 'v'));
        dic.put('9', List.of('w', 'x', 'y', 'z'));

        DFS(result, dic, digits, 0, new StringBuilder());
        return result;

    }

    public void DFS(List<String> result,
                    Map<Character, List<Character>> dic,
                    String digits, int index,
                    StringBuilder path) {

        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }

        for (Character c : dic.get(digits.charAt(index)))
            DFS(result, dic, digits, index + 1,
                    new StringBuilder(path).append(c));

    }
}