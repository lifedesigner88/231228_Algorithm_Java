package Programers.Lv1.D2412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class P019_모의고사 {

    // 빠른풀이.
    public int[] solution1(int[] answers) {
        int[][] student = {
                {1, 2, 3, 4, 5},                // 0번째 학생
                {2, 1, 2, 3, 2, 4, 2, 5},       // 1번
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}  // 2번
        };

        int[][] count = {
                {1, 0}, // 0번
                {2, 0}, // 1번
                {3, 0}  // 2번
        };

        for (int i = 0; i < answers.length; i++)     // i = 1 ~ 10,000;
            for (int j = 0; j < count.length; j++) { // j = 0 ~ 2;
                int length = student[j].length;
                if (student[j][i % length] == answers[i]) count[j][1]++;
            }

        // 카운트 값으로 정렬.
        Arrays.sort(count, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        if (count[0][1] == count[1][1] &&  // 3개 같으면
                count[1][1] == count[2][1])
            return new int[]{
                    count[0][0],
                    count[1][0],
                    count[2][0]
            };
        else if (count[0][1] == count[1][1]) // 2개 같으면
            return new int[]{
                    count[0][0],
                    count[1][0]
            };
        else
            return new int[]{count[0][0]};
    }

    public int[] solution2(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[patterns.length];

        // 정답 비교와 점수 계산
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (patterns[j][i % patterns[j].length] == answers[i]) {
                    scores[j]++;
                }
            }
        }

        // 최댓값 찾기
        int maxScore = Arrays.stream(scores).max().getAsInt();

        // 최고 점수를 받은 학생 찾기
        List<Integer> topScorers = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                topScorers.add(i + 1); // 학생 번호는 1부터 시작
            }
        }

        return topScorers.stream().mapToInt(i -> i).toArray();
    }

}



