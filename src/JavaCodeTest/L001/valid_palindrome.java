package JavaCodeTest.L001;

public class valid_palindrome {
    public static void main(String[] args) {
        String[] s = {
                "race a car",
                "A man, a plan, a canal: Panama",
                "0P",
                "",
                ",."
        };

        long startTime, endTime, duration;
        for (String a : s) {

            // solution 1
            startTime = System.nanoTime();
            System.out.println(
                    new Solution1().isPalindrome(a));
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("1번: " + String.format("%10d", duration) + " ns");

            // solution 2
            startTime = System.nanoTime();
            System.out.println(
                    new Solution2().isPalindrome(a));
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("2번: " + String.format("%10d", duration) + " ns");

            // solution 3
            startTime = System.nanoTime();
            System.out.println(
                    new Solution3().isPalindrome(a));
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("3번: " + String.format("%10d", duration) + " ns");

            // solution 4 (교재)
            startTime = System.nanoTime();
            System.out.println(
                    new Solution4().isPalindrome(a));
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("4번: " + String.format("%10d", duration) + " ns (교재)");

            // solution 5 (교재)
            startTime = System.nanoTime();
            System.out.println(
                    new Solution5().isPalindrome(a));
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("5번: " + String.format("%10d", duration) + " ns (교재)");

            System.out.println();
        }

    }
}


class Solution1 {
    public boolean isPalindrome(String s) {
        String r = s.replaceAll("[^a-zA-Z0-9]", "");
        int rLength = r.length();
        if (rLength <= 1) return true;

        for (int i = 0; i < rLength / 2; i++) {
            char leftChar = Character.toLowerCase(r.charAt(i));
            char rightChar = Character.toLowerCase(r.charAt(rLength - i - 1));
            if (leftChar != rightChar) return false;
        }
        return true;
    }
}

class Solution2 {
    public boolean isPalindrome(String s) {
        String r = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int rLength = r.length();
        if (rLength <= 1) return true;
        for (int i = 0; i < rLength / 2; i++)
            if (r.charAt(i) != r.charAt(rLength - i - 1)) return false;
        return true;
    }
}

class Solution3 {
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (leftPointer < rightPointer) {
            while (!Character.isLetterOrDigit(s.charAt(leftPointer))) {
                if (leftPointer == rightPointer) return true;
                leftPointer++;
            }
            while (!Character.isLetterOrDigit(s.charAt(rightPointer)))
                rightPointer--;
            if (Character.toLowerCase(s.charAt(leftPointer))
                    != Character.toLowerCase(s.charAt(rightPointer)))
                return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}

class Solution4 {
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (leftPointer < rightPointer)
            if (!Character.isLetterOrDigit(s.charAt(leftPointer)))
                leftPointer++;
            else if (!Character.isLetterOrDigit(s.charAt(rightPointer)))
                rightPointer--;
            else {
                if (Character.toLowerCase(s.charAt(leftPointer))
                        != Character.toLowerCase(s.charAt(rightPointer)))
                    return false;
                leftPointer++;
                rightPointer--;
            }
        return true;
    }
}

class Solution5 {
    public boolean isPalindrome(String s) {
        String s_filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String s_reversed = new StringBuffer(s_filtered).reverse().toString();
        return s_filtered.equals(s_reversed);
    }
}










