package Programers.Lv1.D2412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/67256

public class P016_키패드누르기 {
    List<String> list = new ArrayList<>();
    int[] left = {1, 4};  // *
    int[] right = {3, 4};  // #

    public String solution1(int[] numbers, String hand) {
        Map<Integer, int[]> map = new HashMap<>() {{ // 배열로 해도 됨.
            put(0, new int[]{2,4});

            put(1, new int[]{1,1}); // 1번줄
            put(2, new int[]{2,1});
            put(3, new int[]{3,1});

            put(4, new int[]{1,2}); // 2번줄
            put(5, new int[]{2,2});
            put(6, new int[]{3,2});

            put(7, new int[]{1,3}); // 3번줄
            put(8, new int[]{2,3});
            put(9, new int[]{3,3});
        }};

        for (int n : numbers) {
            int[] button = map.get(n);

            if (button[0] == 1)
                move("L", button);

            else if (button[0] == 3)
                move("R", button);

            else {
                int leftDist = distance(left, button);
                int rightDist = distance(right, button);

                if (leftDist < rightDist)
                    move("L", button);
                else if (leftDist > rightDist)
                    move("R", button);
                else if (hand.equals("right"))  // ? : 삼항연산자 사용가능.
                    move("R", button);
                else
                    move("L", button);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s);

        return sb.toString(); // String.join("",list); 참고.
    }

    private void move(String hand, int[] button) {
        if (hand.equals("L"))
            left = button;
        else
            right = button;
        list.add(hand);
    }

    private int distance(int[] a, int[] b) {
        return (Math.abs(a[0] - b[0]) + Math.abs(a[1]- b[1]));
    }
}
