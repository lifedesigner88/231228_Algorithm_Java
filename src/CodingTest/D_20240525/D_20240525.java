package CodingTest.D_20240525;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class D_20240525 {


}

class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] split = input.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int counter = M;

        List<String> inputList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        while(counter-- >= 0) inputList.add(br.readLine());

        String verse = "LOSE";

        for (int i = 1; i <= M; i++) {
            int S = 0;
            int B = 0;
            for (int j = 0; j < N; j++) {
                int swing = inputList.get(0).indexOf(inputList.get(i).charAt(j));
                if ( swing == j ) S++;
                else if ( swing != -1 ) B++;
                if (S == N) verse = "WIN";
            }
            result.add(S + "S " + B + "B");
        }

        result.add(verse);
        for (String s : result) System.out.println(s);

    }
}

class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while (N-- > 0) {
            String realNumber = br.readLine();
            String[] split = realNumber.split("\\.");
            if (Integer.parseInt(split[1]) == 0) result++;
        }

        System.out.println(result);
    }
}



class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> even = new ArrayDeque<>();
        Deque<Integer> odd = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        String[] intArray = br.readLine().split(" ");

        for (String a : intArray){
            int num = Integer.parseInt(a);
            if (num % 2 == 0)
                even.addLast(num);
            else
                odd.addFirst(num);
        }

        even.addAll(odd);

        for (int result : even)
            System.out.print(result + " ");
    }
}

class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pagesSum = Integer.parseInt(br.readLine());

        int lastPage = 2;
        int missingOddPage = 0;

        for (int i = 2; i <= 10; i = i + 2){
            int correctSum = i * (i + 1) / 2;
            if (correctSum > pagesSum) {
                missingOddPage = (correctSum - pagesSum) / 2;
                System.out.println(missingOddPage);
                break;
            }
        }
    }
}
