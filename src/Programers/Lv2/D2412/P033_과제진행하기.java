package Programers.Lv2.D2412;



import java.util.*;


// https://school.programmers.co.kr/learn/courses/30/lessons/176962
public class P033_과제진행하기 {

    public String[] solution(String[][] plans) {
        Arrays.sort(plans, Comparator.comparingInt(i -> timeToInt(i[1])));

        List<String> result = new ArrayList<>();
        Deque<String[]> stack = new ArrayDeque<>();

        for (String[] p : plans) {
            if (stack.isEmpty())
                stack.push(p);
            else {
                String[] working = stack.peek(); // 이전 작업 불러오기
                int duration = timeToInt(p[1]) - timeToInt(working[1]); // 작업 경과시간 (정렬해서 항상 양수)
                int leftTime = Integer.parseInt(working[2]);
                while (duration >= leftTime) {
                    result.add(working[0]);         // 완료한 업무
                    stack.pop();                    // 완료업무 제거
                    duration -= leftTime;

                    if (stack.isEmpty()) break; // 이전 작업 없으면 종료
                    else
                        working = stack.peek();
                    leftTime = Integer.parseInt(working[2]);
                }
                if (duration < leftTime) {
                    leftTime -= duration;
                    working[2] = String.valueOf(leftTime);
                }
                stack.push(p);
            }
        }

        while (!stack.isEmpty()) // 남은 업무 순차적으로 추가.
            result.add(stack.pop()[0]);

        return result.toArray(String[]::new);
    }

    private int timeToInt(String time) {

        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]);
        int minute = Integer.parseInt(temp[1]);

        return hour * 60 + minute;
    }
}
