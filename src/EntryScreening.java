import java.util.*;

public class EntryScreening extends Print{
    public static void main(String[] args) {
        print();
//        int[] times = {3, 4, 5, 2, 6, 7, 8, 9, 2};


        int n = 8901238;
//        int n = 11;
        int count = 0;
        long answer, before, after,diff;



//        Priority Queue
        int[] times = {
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,1
        };
        before = System.nanoTime();                         // 시간측정

        Queue<long[]> Que = new PriorityQueue<>((Que1, Que2) -> (int) (Que1[2] - Que2[2]));
        for (int time : times) Que.add(new long[]{time, 0, time});

        while (true){
            long[] temp = Que.poll();
            if (++count == n) {
                answer = temp[2]; break;}           // temp[0] = Value
            temp[1]++;                              // temp[1] = Count
            temp[2] = temp[0] * (temp[1] + 1);      // temp[2] = Queue
            Que.add(temp);
        }


        after = System.nanoTime();                          // 시간측정

        diff = after-before;
        print("*Priority: \t" + answer + "분, 속도:(" + (diff/1000)+"us)");





//        LinkedList + BinarySearch
        int[] times2 = {
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,1
        };
        count = 0;

        before = System.nanoTime();                                         // 시간측정


        Arrays.sort(times2);
        LinkedList<long[]> linked = new LinkedList<>();
        for (int time : times2) linked.addLast(new long[]{time, 0, time});
//        linked.sort((o1, o2) -> (int) (o1[2] - o2[2]));     // 최초 정렬은 삽입전에 하는게 조금 빠름

        while (true){
            long[] temp = linked.pollFirst();
            if (++count == n) {
                answer = temp[2]; break;}           // temp[0] = Value
            temp[1]++;                              // temp[1] = Count
            temp[2] = temp[0] * (temp[1] + 1);      // temp[2] = Times

            linked.add(BinarySearch(linked, temp[2]), temp);        // BS 로 인덱스 호출
        }

        after = System.nanoTime();                                          // 시간측정


        diff = after-before;
        print("*LinkedBS: \t" + answer + "분, 속도:(" + (diff/1000)+"us)");




//        ArraysList + BinarySearch
        int[] times3 = {
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,1
        };
        count = 0;

        before = System.nanoTime();                                         // 시간측정
        Arrays.sort(times3);
        ArrayList<long[]> array = new ArrayList<>();
        for (int time : times3) array.add(new long[]{time, 0, time});

        while (true){
            long[] temp = array.get(0);
            array.remove(0);
            if (++count == n) {
                answer = temp[2]; break;}           // temp[0] = Value
            temp[1]++;                              // temp[1] = Count
            temp[2] = temp[0] * (temp[1] + 1);      // temp[2] = Times

            array.add(BinarySearch(array, temp[2]), temp);
        }
        after = System.nanoTime();                                          // 시간측정


        diff = after-before;
        print("*ArrayBS: \t" + answer + "분, 속도:(" + (diff/1000)+"us)");




    //        ArraysList(no Remove) + BinarySearch
        int[] times4 = {
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,1
        };
        count = 0;

        before = System.nanoTime();                                         // 시간측정
        Arrays.sort(times4);
        ArrayList<long[]> arrayNoRemove = new ArrayList<>();
        for (int time : times4) arrayNoRemove.add(new long[]{time, 0, time});

        while (true){
            long[] temp = arrayNoRemove.get(count);
//            arrayNoRemove.remove(0);
            if (++count == n) {
                answer = temp[2]; break;}           // temp[0] = Value
            temp[1]++;                              // temp[1] = Count
            temp[2] = temp[0] * (temp[1] + 1);      // temp[2] = Times

            arrayNoRemove.add(BinarySearch(arrayNoRemove, count, temp[2]), temp);
        }
        after = System.nanoTime();                                          // 시간측정


        diff = after-before;
        print("*noRemove: \t" + answer + "분, 속도:(" + (diff/1000)+"us)");




        //  Quick Array
        int[] times5 = {
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,1
        };
        count = 0;
        int length = times5.length;

        before = System.nanoTime();                                         // 시간측정
        Arrays.sort(times5);

        long[][] quickArray = new long[length][3];

        for (int i = 0; i < length; i++){
            quickArray[i][0] = times5[i];
            quickArray[i][2] = times5[i];
        }

        while (true){
            if (++count == n) {
                answer = quickArray[0][2]; break;}           // [0][0] = Value
            quickArray[0][1]++;                              // [0][1] = Count
            quickArray[0][2] = quickArray[0][0] * (quickArray[0][1] + 1);      // [0][2] = Times
            Arrays.sort(quickArray, ((o1, o2) -> (int) (o1[2] - o2[2])));
        }
        after = System.nanoTime();                                          // 시간측정


        diff = after-before;
        print("*QuickArr: \t" + answer + "분, 속도:(" + (diff/1000)+"us)");







        //        Class + Priority Queue

        int[] times6 = {
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,1
        };
        answer = 0;
        count = 0;
        int index;


        before = System.nanoTime();                         // 시간측정

        int[] Counter = new int[times6.length];
        long[] Time = new long[times6.length];

        Queue<CheckDesk> LongQue = new PriorityQueue<>((o1, o2) -> (int) (o1.getTime() - o2.getTime()));
        for (int time : times6) {
            Time[count] = time;
            LongQue.add(new CheckDesk(count, Time[count++]));
        }


        count = 0;
        while (true){
            CheckDesk findValue = LongQue.poll();
            index = findValue.getIndex();
            if (++count == n) {
                answer = findValue.getTime(); break;}
            Counter[index]++;
            Time[index] = (long) times6[index] * (Counter[index] + 1);
            LongQue.add(findValue.setTime(Time[index]));
        }


        after = System.nanoTime();                          // 시간측정

        diff = after-before;
        print("*Class+PQ: \t" + answer + "분, 속도:(" + (diff/1000)+"us)");





        //        완전히 다른 접근!!

        int[] times7 = {
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,
                3, 4, 5, 2, 6, 7, 8, 9, 2,1
        };


        before = System.nanoTime();                         // 시간측정

        Arrays.sort(times7);
        long minTime = times7.length;
        long maxTime = (long) times7[0] * n;
        long MidTime = 0;

        while (minTime <= maxTime) {

             MidTime = (minTime + maxTime) / 2;
            if (isPossible(times7, n, MidTime))
                maxTime = MidTime - 1;
            else
                minTime = MidTime + 1;
        }
        answer = minTime;

        after = System.nanoTime();                          // 시간측정

        diff = after-before;
        print("*완전다른: \t" + answer + "분, 속도:(" + (diff/1000)+"us)");


    }


    static boolean isPossible (int[]times, int n, long MidTime ){

        int MaxNum = 0;      // ( 직원들이, 100명을, 30분) 에 처리 가능한가?
        for(int a : times) {
            MaxNum += (int) (MidTime / a);
            if (MaxNum >= n) return true;
        }
        return false;
    }


    static int BinarySearch(LinkedList<long[]> linked, long findValue) {
        int start = 0;
        int middle;
        int end = linked.size()-1;
        long temp;

        while(true) {

            middle = (start + end) / 2;
            temp = linked.get(middle)[2];

            if (temp == findValue)
                return middle;
            else if (temp < findValue)
                start = middle + 1;
            else
                end = middle - 1;
            if (start > end)
                return start;
        }
    }


    static int BinarySearch(ArrayList<long[]> array, long findValue) {
        int start = 0;
        int middle;
        int end = array.size()-1;
        long temp;

        while(true) {

            middle = (start + end) / 2;
            temp = array.get(middle)[2];

            if (temp == findValue)
                return middle;
            else if (temp < findValue)
                start = middle + 1;
            else
                end = middle - 1;
            if (start > end)
                return start;
        }
    }


    static int BinarySearch(ArrayList<long[]> array, int count, long findValue) {
        int start = count;
        int middle;
        int end = array.size()-1;
        long temp;

        while(true) {

            middle = (start + end) / 2;
            temp = array.get(middle)[2];

            if (temp == findValue)
                return middle;
            else if (temp < findValue)
                start = middle + 1;
            else
                end = middle - 1;
            if (start > end)
                return start;
        }
    }
    static int BinarySearch(long[] Time, long findValue) {
        int start = 0;
        int middle;
        int end = Time.length-1;

        while(true) {

            middle = (start + end) / 2;

            if (Time[middle] == findValue)
                return middle;
            else if (Time[middle] < findValue)
                start = middle + 1;
            else
                end = middle - 1;
            if (start > end)
                return start;
        }
    }


}

class CheckDesk {
    final int index;
    long Time;

    CheckDesk(int index,long Time) {
        this.index = index;
        this.Time = Time;
    }

    public CheckDesk setTime(long Time) {
        this.Time = Time;
        return this;
    }

    public int getIndex() {return index;}
    public long getTime() {return Time;}

}



