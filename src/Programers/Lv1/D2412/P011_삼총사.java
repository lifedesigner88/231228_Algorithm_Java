package Programers.Lv1.D2412;


// https://school.programmers.co.kr/learn/courses/30/lessons/131705
public class P011_삼총사 {
    public static void main(String[] args) {

        int p1 = new P011_삼총사().solution1(new int[]{-1, 0, 1, 2, -1, -4});
        int p2 = new P011_삼총사().solution2(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println(p1);
        System.out.println(p2);

    }

    public int solution1(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++)
            for (int j = i + 1; j < number.length - 1; j++)
                for (int k = j + 1; k < number.length; k++)
                    if (number[i] + number[j] + number[k] == 0) answer++;
        return answer;
    }

    // DFS 조건
    public int solution2(int[] number) {
        return dfs(number, 0, 0, 0);
    }

    private int dfs(int[] number, int index, int depth, int sum) {
        if (depth == 3) {
            return sum == 0 ? 1 : 0;
        }

        if (index >= number.length) {
            return 0;
        }

        // 두 개의 분기에서 반환 값을 누적
        return dfs(number, index + 1, depth + 1, sum + number[index])
                + dfs(number, index + 1, depth, sum);
    }
}
