package JavaCodeTest.A_0001_Valid_Palindrome;

// https://leetcode.com/problems/valid-palindrome
// https://blog.naver.com/lifedesigner88/223455204369

public class Valid_Palindrome {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        boolean result = true;

        ElseIfPointer elif = new ElseIfPointer();
        System.out.println(elif.isPalindrome(s));

        SingleArray sa = new SingleArray();
        System.out.println(sa.isPalindrome(s));

        BufferReverse br = new BufferReverse();
        System.out.println(br.isPalindrome(s));

    }
}

class BufferReverse {
    public boolean isPalindrome(String s) {
        String filter = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverse = new StringBuffer(filter).reverse().toString();
        return filter.equals(reverse);
    }
}

class SingleArray {
    public boolean isPalindrome(String s) {
        String filter = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = filter.length();
        for (int i = 0; i < n / 2; i++)
            if (filter.charAt(i) != filter.charAt(n - i - 1))
                return false;
        return true;
    }
}

class ElseIfPointer {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            if (!Character.isLetterOrDigit(startChar)) start++;
            else if (!Character.isLetterOrDigit(endChar)) end--;
            else {
                if (Character.toLowerCase(startChar)
                        != Character.toLowerCase(endChar))
                    return false;
                start++;
                end--;
            }
        }
        return true;
    }
}

