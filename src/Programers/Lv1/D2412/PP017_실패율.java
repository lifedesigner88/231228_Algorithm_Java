package Programers.Lv1.D2412;

import java.util.ArrayList;
import java.util.List;

public class PP017_실패율 {

    int[] counter;
    List<StageFailRate> list = new ArrayList<>();

    public int[] solution(int N, int[] stages) {
        this.counter = new int[N + 2];

        // 스테이지별 유저수
        for (int s : stages) counter[s]++;

        // 실패율 계산
        int passUser = counter[N + 1]; // 끝판깬 유저
        for (int i = N; i > 0; i--) {
            passUser += counter[i];
            list.add(new StageFailRate(i, (double) counter[i] / passUser));
        }

        // 정렬
        list.sort((o1, o2) -> {
            int vs = Double.compare(o2.d, o1.d);
            if (vs != 0) return vs;
            else return o1.i - o2.i;
        });

        int[] answer = new int[N];
        for (int j = 0; j < N; j++)
            answer[j] = list.get(j).i;
        return answer;
    }
}

class StageFailRate {
    int i;
    double d;

    public StageFailRate(int i, double d) {
        this.i = i;
        this.d = d;
    }
}


class SolutionP017 {
    public int[] solution(int N, int[] stages) {
        int[] counter = new int[N + 2];
        List<StageFailRate2> list = new ArrayList<>();

        // 스테이지별 유저수
        for (int s : stages) counter[s]++;

        // 실패율 계산
        int passUser = counter[N + 1];
        for (int i = N + 1; i >= 1; i--) {
            passUser += counter[i];
                double failRate = passUser == 0 ? 0 : (double) counter[i] / passUser;
                list.add(new StageFailRate2(i, failRate));
        }

        // 정렬
        list.sort((o1, o2) -> {
            int vs = Double.compare(o2.failRate, o1.failRate);
            return (vs != 0) ? vs : Integer.compare(o1.stage, o2.stage);
        });

        // 결과 배열 생성
        return list.stream().mapToInt(stage -> stage.stage).toArray();
    }
}

class StageFailRate2 {
    int stage;
    double failRate;

    public StageFailRate2(int stage, double failRate) {
        this.stage = stage;
        this.failRate = failRate;
    }
}




