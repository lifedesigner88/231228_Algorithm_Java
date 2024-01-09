import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class cote extends Print {
    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;

        Queue<int[]> priorityQue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2])         // 두개의 길이가 같으면
                    return o1[0] - o2[0];               // 앞쪽 인덱스가 짧은게 우선
                return (o1[2] - o2[2]);   // 두개 길이가 다르면 짧은게 우선
            }
        });


//        int length = sequence.length;
//
//
//        int start = 0, end = 0;
//
//        do {
//                int arrSum = sumArrayByTwoIndex(sequence, start, end);
//                if (arrSum == k) {
//                    priorityQue.add(new int[]{start, end});   // 배열에 담아서 큐에 에드.
//                    start++;
//                } else if (arrSum < k) end++;
//                else start++;
//            }
//        } while (end != length);
//


        int sum=0;
        int lt=0;
        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];
            if(sum==k) priorityQue.add(new int[]{lt, rt, rt-lt}); //7과 1 7의 경우
            if(sum>k){
                while(sum>k){
                    sum -= sequence[lt];
                    lt++;
                    if(sum==k) priorityQue.add(new int[]{lt, rt, rt-lt}); // 1 2 3 4의 경우
                }
            }
        }


//
//        int length = sequence.length;
//        int minLength = length;
//        for (int i = 0; i < length; i++)
//            for (int j = i; j < length; j++) {
//                if (!priorityQue.isEmpty())                 // 비어있지 않으면
//                    minLength = (priorityQue.peek()[1] - priorityQue.peek()[0] + 1 );
//                if (j - i + 1 <= minLength)
//                    if (sumArrayByTwoIndex(sequence, i, j) == k)
//                        priorityQue.add(new int[]{i, j});   // 배열에 담아서 큐에 에드.
//            }
//
//

        print(Arrays.toString(priorityQue.poll()));


        for (int[] a : priorityQue)
            printStartEnd(sequence, a[0], a[1]);

        print(sumArrayByTwoIndex(sequence, 0,2));


    }

    static int sumArrayByTwoIndex(int[] sequence, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++)
            sum += sequence[i];
        return sum;
    }



    static void printStartEnd(int[] arr, int startIndex, int endIndex) {
        System.out.print("스타트, 엔드 인덱스: ");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
