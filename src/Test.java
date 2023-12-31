import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test extends Print{
    public static void main(String[] args) {
        print();

        int[] times = {3, 4, 5, 2, 6, 7, 8, 9, 2};
        int n = 11;
        int count = 0;
        long answer;

        Queue<long[]> Que = new PriorityQueue<>((Que1, Que2) -> (int) (Que1[2] - Que2[2]));
        for (int time : times) Que.add(new long[]{time, 0, time});

        do{
            long[] temp = Que.poll();
            answer = temp[2];                       // temp[0] = Value
            temp[1]++;                              // temp[1] = Count
            temp[2] = temp[0] * (temp[1] + 1);      // temp[2] = Queue
            Que.add(temp);
        }while(++count < n);



        print("정답 : " + answer);

        count = 0;
        P("Index :\t");
        for(long[] a : Que) P(" " + count++ + " "); print();

        P("Value :\t");
        for (long[] a : Que) P(" " + a[0] + " "); print();

        P("Count :\t");
        for (long[] a : Que) P(" " + a[1] + " "); print();

        P("Queue :\t");
        for (long[] a : Que) P(" " + a[2] + " ");
        print();

    }
}



