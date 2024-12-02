package Programers.Lv1.D2411;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


// https://school.programmers.co.kr/learn/courses/30/lessons/133502
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
                    ingre.subList(i, i + 4).clear(); // 4개이 서브리스트 제거.
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

// 나의 풀이
class Solution008 {
    public int solution(int[] ingredient) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        for (int i : ingredient) {
            if (stack.size() >= 3 && i == 1) {
                int second = stack.pollLast();
                int third = stack.pollLast();
                int forth = stack.pollLast();
                if (second != 3 || third != 2 || forth != 1) {
                    stack.addLast(forth);
                    stack.addLast(third);
                    stack.addLast(second);
                    stack.addLast(i);
                } else answer++;

            } else stack.addLast(i);
        }
        return answer;
    }
}


// 인공지능 풀이
class HamburgerPacking {

    public static int solution(int[] ingredient) {
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;

        for (int i : ingredient) {
            deque.addLast(i);

            // Check if the last 4 elements form a complete hamburger
            if (deque.size() >= 4) {
                // Get the last four elements
                Integer[] lastFour = new Integer[4];
                Object[] dequeArray = deque.toArray();

                for (int j = 0; j < 4; j++) {
                    lastFour[j] = (Integer) dequeArray[dequeArray.length - 4 + j];
                }

                if (lastFour[0] == 1 && lastFour[1] == 2 &&
                        lastFour[2] == 3 && lastFour[3] == 1) {

                    // Remove 4 items representing a complete hamburger
                    deque.pollLast();
                    deque.pollLast();
                    deque.pollLast();
                    deque.pollLast();
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));  // Output: 2
    }
}