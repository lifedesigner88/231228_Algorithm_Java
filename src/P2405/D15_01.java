package P2405;

import java.util.Arrays;

public class D15_01 {
    public static void main(String[] args) {
        String[][] datas = {
                {"3141592", "271"},
                {"500220839878", "7"},
                {"10203", "15"},
        };
        System.out.println(Arrays.deepToString(datas));
        for (String[] data : datas) {
            System.out.println(new Solution().solution(data[0], data[1]));
            System.out.println(new Solution2().solution(data[0], data[1]));
        }
    }
}

// 내가 푼 코드.
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tlength = t.length();
        int plength = p.length();
        char pFirstNum = p.charAt(0);
        long numberP = Long.parseLong(p);

        for (int i = 0; i <= tlength - plength; i++) {
            char tFirstNum = t.charAt(i);
            if (tFirstNum < pFirstNum)
                answer++;
            else {
                String subStrT = t.substring(i, i + plength);
                long numberT = Long.parseLong(subStrT);
                if (numberT <= numberP)
                    answer++;
            }
        }
        return answer;
    }
}

// AI 의 리펙토링 코드
class Solution2 {

    public int solution(String t, String p) {

        int count = 0;
        int tLength = t.length();
        int pLength = p.length();
        char pFirstDigit = p.charAt(0);
        long numberP = Long.parseLong(p);

        for (int i = 0; i <= tLength - pLength; i++){
            count += checkSubstrings(t, i, pLength, pFirstDigit, numberP);
        }

        return count;
    }

    private int checkSubstrings(String t, int index, int length, char firstDigit, long number) {
        char tFirstDigit = t.charAt(index);

        if(tFirstDigit < firstDigit) return 1;

        String substring = t.substring(index, index + length);
        long numberT = Long.parseLong(substring);

        return numberT <= number ? 1 : 0;
    }
}
