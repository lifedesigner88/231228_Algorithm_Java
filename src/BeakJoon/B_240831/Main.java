package BeakJoon.B_240831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String input = br.readLine();

        String[] numbers = input.split(" ");

        long sum = 0L;
        for (String number : numbers)
            sum += Long.parseLong(number);

        System.out.println(sum);

    }
}