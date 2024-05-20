package HanHwaSC_03;

import java.util.*;
import java.awt.Point;


public class Z01_Solution {

    static int sumArrayByTwoIndex(int[] sequence, int startIndex, int endIndex) {
        int sum = 0;                                    // 2개 인덱스로 배열의 합
        for (int i = startIndex; i <= endIndex; i++)
            sum += sequence[i];
        return sum;
    }

    public int[] solution(int[] sequence, int k) {
        Queue<int[]> priorityQue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]-o1[0] == o2[1]-o2[0])         // 두개의 길이가 같으면
                    return o1[0] - o2[0];               // 앞쪽 인덱스가 짧은게 우선
                return (o1[1]-o1[0]) - (o2[1]-o2[0]);   // 두개 길이가 다르면 짧은게 우선
            }
        });

        int length = sequence.length;
        for (int i = 0; i < length; i++)
            for (int j = i; j < length; j++)               // 2개 뽑는 조합
                if (sumArrayByTwoIndex(sequence, i, j) == k)
                    priorityQue.add(new int[]{i, j});  // 같은 값만 큐에 넣음.
        return priorityQue.poll();
    }
}



class Solution1 {               // 준혁님조
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        List<Point> list = new ArrayList<>();
        Point p = new Point(0,0);
        int sum = sequence[0];

        while (true) {
            if (sum == k) {
                list.add(new Point(p.x, p.y));
                sum -= sequence[p.x];
                p.x++;
            } else if (sum > k) {
                sum -= sequence[p.x];
                p.x++;
            } else {
                p.y++;
                if(p.y == sequence.length) break;
                sum += sequence[p.y];
            }
        }
        int min = Integer.MAX_VALUE;
        for (Point point : list) {
            int diff = point.y - point.x;
            if (min > diff) {
                answer[0] = point.x;
                answer[1] = point.y;
                min = diff;
            }
        }
        return answer;
    }
}

class Solution2 {          // 창선님조
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        for (int end = 0; end < sequence.length; end++) {
            sum += sequence[end];

            if (sum == k) {
                if (length > end - start) {
                    length = end - start;
                    answer[0] = start;
                    answer[1] = end;}
            }
            else if (sum > k) {
                for (int j = start; j <= end; j++) {
                    sum -= sequence[j];
                    if (sum <= k) {
                        start = j + 1;
                        break;}}
                if (sum == k)
                    if (length > end - start) {
                        length = end - start;
                        answer[0] = start;
                        answer[1] = end;}
            }
        }
        return answer;
    }
}


class Solution3 {       // 혜선님조
    private static class Union implements Comparable<Union>{
        int start;
        int end;
        int size;
        Union(int start,int end){
            this.start = start;
            this.end = end;
            this.size = start - end;
        }
        @Override
        public int compareTo(Union o){
            if(this.size == o.size){
                return this.start - o.start;
            }
            return this.size -o.size;
        }
        public int[] toarr(){
            return new int[]{start,end};
        }
    }
    public int[] solution(int[] sequence, int k) {
        int sum =0;
        int lt = 0;
        PriorityQueue<Union> pq = new PriorityQueue<>();
        for(int i=0;i<sequence.length;i++){
            sum +=  sequence[i];
            while(sum>k){
                sum -= sequence[lt];
                lt++;
            }
            if(sum==k){
                pq.add(new Union(lt, i));
            }
        }
        return pq.poll().toarr();
    }
}



class Solution4 {        // 보석님조

    static int sum, end;

    static class Node {
        int start;
        int end;
        int count;

        public Node(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
        public int getCount() {return count;}
    }

    public int[] solution(int[] sequence, int k) {
        List<Node> list = new ArrayList<>();


        for (int i = 0; i < sequence.length; i++) {
            while (sum < k && end < sequence.length) {
                sum += sequence[end];
                end += 1;}

            if (sum == k)
                list.add(new Node(i, end - 1, end - i - 1));
            sum -= sequence[i];
        }
        list.sort((o1, o2) -> o1.count - o2.count);
        return new int[]{list.get(0).start, list.get(0).end};
    }
}



class Solution5 {           // 지용님조
    static int min_len = Integer.MAX_VALUE;

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int end = 0;
        int start = 0;
        int sum = sequence[0];

        while (true) {
            if (sum == k) {
                if (min_len > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                    min_len = end - start;
                }
                sum -= sequence[start++];
            }
            if (sum > k)
                sum -= sequence[start++];
            if (sum < k) {
                if (end == sequence.length - 1)
                    break;
                if (end < sequence.length - 1)
                    sum += sequence[++end];
            }
        }
        return answer;
    }
}


class Solution6 {           // 세한님 조
    static class Sequence {
        int start;
        int end;

        public Sequence(int start, int end) {
            this.start = start;
            this.end = end;}
    }

    public int[] solution(int[] sequence, int k) {
        List<Sequence> answers = new ArrayList<>();
        int[] answer = new int[2];

        int sum=0;
        int lt=0;
        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];
            if(sum==k)
                answers.add(new Sequence(lt, rt));

            while(sum>=k){
                sum -= sequence[lt];
                lt++;
                if(sum==k)
                    answers.add(new Sequence(lt, rt));}
        }

        int minLength = Integer.MAX_VALUE;
        int minIndex=0;

        int answers_len = answers.size();
        for (int i = 0; i < answers_len; i++) {
            int sequence_len = answers.get(i).end - answers.get(i).start;
            if(sequence_len < minLength) {
                minLength = sequence_len;
                minIndex = i;}
        }
        answer[0] = answers.get(minIndex).start;
        answer[1] = answers.get(minIndex).end;
        return answer;
    }
}


class enhancedSolution {        // 퓨전코드
    public int[] solution(int[] sequence, int k) {

        int[] answer = new int[2];
        int end = 0, start = 0, sum = sequence[0];
        int length = sequence.length;
        int min_len = length;

        while (true)
            if (sum == k){
                if (min_len > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                    min_len = end - start;}
                sum -= sequence[start++];
            }
            else if (sum > k)
                sum -= sequence[start++];
            else {
                if (end == length - 1) break;
                sum += sequence[++end];
            }
        return answer;
    }
}




