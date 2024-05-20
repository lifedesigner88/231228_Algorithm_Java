package HanHwaSC_03.P04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Z04_Solution {
    public static void main(String[] args) {

        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(new Solution().solution(operations)));

    }
}


class Solution {


    public int[] solution(String[] operations) {
        Queue<Integer> minQue = new PriorityQueue<>(Comparator.naturalOrder());
        Queue<Integer> maxQue = new PriorityQueue<>(Comparator.reverseOrder());

        return new int[0];
    }



}