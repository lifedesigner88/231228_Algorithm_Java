package JavaCodeTest_Non_Linear.B_0062_Implement_Trie;

//https://leetcode.com/problems/implement-trie-prefix-tree/

import java.util.ArrayList;
import java.util.List;

public class ImplementTrie {
    public static void main(String[] args) {

        List<Boolean> answer = new ArrayList<>();

        Trie trie = new Trie();

        trie.insert("apple");
        answer.add(trie.search("apple"));
        answer.add(trie.search("app"));
        answer.add(trie.startsWith("app"));
        trie.insert("app");
        answer.add(trie.search("app"));

        System.out.println(answer);

    }
}

// ❤️ Beautiful Solution ❤️

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[toCharNum(c)] == null)
                cur.children[toCharNum(c)] = new TrieNode();
            cur = cur.children[toCharNum(c)];
        }
        cur.word = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[toCharNum(c)] == null)
                return false;
            cur = cur.children[toCharNum(c)];
        }
        return cur.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[toCharNum(c)] == null)
                return false;
            cur = cur.children[toCharNum(c)];
        }
        return true;
    }

    int toCharNum(char c) {
        return c - 'a';
    }
}

class TrieNode {
    boolean word;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
        word = false;
    }
}