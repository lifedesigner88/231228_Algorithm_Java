package BeakJoon.B_240831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String firstLine = br.readLine();
        String[] dice = firstLine.split(" ");

        int first = Integer.parseInt(dice[0]);
        int second = Integer.parseInt(dice[1]);
        int third = Integer.parseInt(dice[2]);

        int result;

        if (first == second && second == third)
            result = first * 1000 + 10000;
        else if (first == second) result = first * 100 + 1000;
        else if (first == third) result = first * 100 + 1000;
        else if (second == third) result = second * 100 + 1000;
        else result = Math.max(first, Math.max(second, third)) * 100;

        System.out.println(result);
    }
}