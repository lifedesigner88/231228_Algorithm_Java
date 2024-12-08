package Programers.Lv1.D2412;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12921
public class P024_소수판별 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; j <= Math.sqrt(i); j++)
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            if (prime) answer++;
        }
        return answer;
    }

    public int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

    // 6k + 1
    public int optimizedIsPrime(int n) {
        if (n <= 1) return 0;
        if (n <= 3) return n - 1;
        int count = 2; // 2와 3은 소수

        for (int i = 5; i <= n; i += 6) {
            if (isPrime(i)) count++;
            if (isPrime(i + 2) && (i + 2) <= n) count++;
        }

        return count;
    }

    // 6k ± 1 최적화를 위한 보조 함수
    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
