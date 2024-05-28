package JavaCodeTest.A_0006_Longest_Palindromic;

// https://leetcode.com/problems/longest-palindromic-substring
// https://blog.naver.com/lifedesigner88/223460417222


import java.util.*;

public class Longest_palindromic {
    public static void main(String[] args) {


        String s = "kbakdkad";
        String result = "akdka";


        ShortFirst sf = new ShortFirst();
        String sfStr = sf.longestPalindrome(s);
        System.out.println(sfStr);

        LongFirst lf = new LongFirst();
        String lfStr = lf.longestPalindrome(s);
        System.out.println(lfStr);

    }
}


// ❤️ Beautiful Solution ❤️

class ShortFirst {

    int left;
    int maxLength;

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        for (int i = 0; i < n - 1; i++) {
            checkPalin(s, i, i + 1);
            checkPalin(s, i, i + 2);
        }
        return s.substring(left, left + maxLength);
    }

    public void checkPalin(String s, int start, int end) {
        int n = s.length();
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (maxLength < end - start - 1) {
            left = start + 1;
            maxLength = end - start - 1;
        }
    }
}


class LongFirst {
    public String longestPalindrome(String s) {
        int n = s.length();
        for (int length = n; length > 0; length--)
            for (int i = 0; i + length <= n; i++) {
                String sub = s.substring(i, i + length);
                if (isPalin(sub)) return sub;
            }
        return null;
    }

    boolean isPalin(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++)
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        return true;
    }
}
