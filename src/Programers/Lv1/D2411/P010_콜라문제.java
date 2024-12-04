package Programers.Lv1.D2411;


// https://school.programmers.co.kr/learn/courses/30/lessons/132267#


public class P010_콜라문제 {
    public static int solution1(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int newBottle = (n / a) * b;
            int remainder = n % a;
            n = newBottle + remainder;
            answer += newBottle;
        }
        return answer;
    }

    public static int solution2(int a, int b, int n) {
        return (n > b ? n - b : 0) / (a - b) * b;
    }

    public static void main(String[] args) {
        for (int a = 3; a < 15; a++) {
            for (int b = 1; b < a; b++) {
                for (int n = a + 1; n < 30; n++) {

                    // b < a < n을 강제로 만족
                    if (a >= n) {
                        continue;
                    }
                    int answer1 = solution1(a, b, n);
                    int answer2 = solution2(a, b, n);

                    if (answer1 != answer2) {
                        System.out.println("Test Case");
                        System.out.println("Input: a=" + a + ", b=" + b + ", n=" + n);
                        System.out.println("solution1: " + answer1);
                        System.out.println("solution2: " + answer2);
                        System.out.println("-----");
                        return; // 첫 번째 반례를 발견하면 종료합니다
                    }
                }
            }
        }
        System.out.println("No difference found in the tested range.");
    }
}
