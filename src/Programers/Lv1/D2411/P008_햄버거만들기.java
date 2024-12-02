package Programers.Lv1.D2411;

import java.util.ArrayList;
import java.util.List;


// 세종 풀이법 - 시간초과
public class P008_햄버거만들기 {

    private final int[] bugger = {1, 2, 3, 1};
    private final List<Integer> ingre = new ArrayList<>();

    public int solution(int[] ingredient) {

        int answer = 0;
        for (int i : ingredient) ingre.add(i);

        // 최대 가능 버거 수 만큼 체크
        for (int k = 0; k < ingredient.length / 4; k++)
            for (int i = 0; i <= ingre.size() - 4; i++)
                if (CanMakeBugger(i)) {
                    // 버거 제작
                    for (int j = i; j < i + 4; j++)
                        ingre.remove(i);
                    answer++;
                    break;
                }

        return answer;
    }

    // 첫 인덱스에서 버거 제작이 가능한지 체크.
    private boolean CanMakeBugger(int index) {
        int count = 0;
        for (int i = index; i < index + 4; i++) {
            if (ingre.get(i) != bugger[count++])
                return false;
        }
        return true;
    }
}


// 1 빵
// 2 야채
// 3 고기
// 1 빵
