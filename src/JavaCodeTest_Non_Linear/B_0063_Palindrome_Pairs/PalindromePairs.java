package JavaCodeTest_Non_Linear.B_0063_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/palindrome-pairs/description/

public class PalindromePairs {
    public static void main(String[] args) {

        String[] words = {
                "a", "b", "ban", "banana", "bat",
                "lolcat", "mana", "nab", "nana",
                "noon", "on", "ta", "tac"
        };

        Solution s = new Solution();
        List<List<Integer>> res = s.palindromePairs(words);
        System.out.println(res);

    }
}

// ❤️ Beautiful Solution ❤️

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        Trie t = new Trie();
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < words.length; i++)
            t.insert(i, words[i]);
        for (int i = 0; i < words.length; i++)
            results.addAll(t.search(i, words[i]));

        return results;
    }

    static class TrieNode {
        int wordId;
        TrieNode[] children;
        List<Integer> palindromeWordIds;

        TrieNode() {
            wordId = -1;
            children = new TrieNode[26];
            palindromeWordIds = new ArrayList<>();
        }
    }

    static class Trie {

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        boolean isPalindrome(String str, int start, int end) {
            while (start < end)
                if (str.charAt(start++) != str.charAt(end--))
                    return false;
            return true;
        }

        void insert(int index, String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (isPalindrome(word, 0, i))
                    cur.palindromeWordIds.add(index);
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.wordId = index;
        }

        List<List<Integer>> search(int index, String word) {

            TrieNode cur = root;
            List<List<Integer>> result = new ArrayList<>();

            for (int j = 0; j < word.length(); j++) {
                if (cur.wordId >= 0 && isPalindrome(word, j, word.length() - 1))
                    result.add(Arrays.asList(index, cur.wordId));
                if (cur.children[word.charAt(j) - 'a'] == null)
                    return result;
                cur = cur.children[word.charAt(j) - 'a'];
            }

            if (cur.wordId >= 0 && cur.wordId != index)
                result.add(Arrays.asList(index, cur.wordId));
            for (int palindromeWordId : cur.palindromeWordIds)
                result.add(Arrays.asList(index, palindromeWordId));

            return result;
        }
    }
}