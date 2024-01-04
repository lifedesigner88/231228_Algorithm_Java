import java.util.Arrays;

public class Programmers extends Print{
    public static void main(String[] args) {

        String[] quiz = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};

        Solution a = new Solution();
        print(Arrays.toString(a.solution(quiz)));


    }

}
class Solution {
    public String[] solution(String[] quiz) {
        int length = quiz.length;
        String[] answer = new String[length];

        for (int i = 0; i < length; i++){
            String[] temp = quiz[i].split(" ");
            int[] num = new int[3];
            for (int j = 0; j < 3; j++)
                num[j] = Integer.parseInt(temp[j]) ;
            if (temp[1].equals("+") && num[0] + num[1] == num[2])
                answer[i] = "O";
            else if (temp[1].equals("-") && num[0] - num[1] == num[2])
                answer[i] = "O";
            else
                answer[i] = "X";
        }

        return answer;
    }
}