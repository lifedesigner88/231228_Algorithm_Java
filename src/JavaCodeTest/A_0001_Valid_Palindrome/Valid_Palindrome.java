package JavaCodeTest.A_0001_Valid_Palindrome;

// https://leetcode.com/problems/valid-palindrome/
public class Valid_Palindrome {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        FilterByReg regexp = new FilterByReg();
        System.out.println(regexp.isPalindrome(s));

        ElseIfPointer elif = new ElseIfPointer();
        System.out.println(elif.isPalindrome(s));

        WhilePointer whilep = new WhilePointer();
        System.out.println(whilep.isPalindrome(s));

    }
}

class FilterByReg {
    public boolean isPalindrome(String s) {
        String filter = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = filter.length();
        if (n <= 1) return true;
        for (int i = 0; i < n / 2; i++)
            if (filter.charAt(i) != filter.charAt(n - i - 1)) return false;
        return true;
    }
}

class ElseIfPointer {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end)
            if (!Character.isLetterOrDigit(s.charAt(start))) start++;
            else if (!Character.isLetterOrDigit(s.charAt(end))) end--;
            else {
                if (Character.toLowerCase(s.charAt(start))
                        != Character.toLowerCase(s.charAt(end)))
                    return false;
                start++;
                end--;
            }
        return true;
    }
}

class WhilePointer {
    public boolean isPalindrome(String s) {
        int start = 0;
        String filter = s.toLowerCase();
        int end = filter.length() - 1;
        while (start < end) {
            while (!Character.isLetterOrDigit(filter.charAt(start))) {
                if (start == end) return true;
                start++;
            }
            while (!Character.isLetterOrDigit(filter.charAt(end)))
                end--;
            if (filter.charAt(start) != filter.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}