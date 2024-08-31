package BeakJoon.B_240831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String input1 = br.readLine();
        String input2 = br.readLine();

        int a = Integer.parseInt(input1);
        int b = Integer.parseInt(input2);

        String[] temp = input2.split("");

        for (int i = 2 ; i >= 0 ; i--) {
            int tmp = Integer.parseInt(temp[i]);
            System.out.println(a * tmp);
        }

        System.out.println(a * b);

    }
}