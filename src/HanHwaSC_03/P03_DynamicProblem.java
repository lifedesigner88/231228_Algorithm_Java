package HanHwaSC_03;

import java.util.Arrays;

public class P03_DynamicProblem extends Print {
    public static void main(String[] args) {
        int[] coins = {1, 4, 5};
        int n = 13;
        int a,b,c;
        int[] neededMinCoins = new int[14];

        neededMinCoins[1]++;
        for(int i = 1; i <= 13; i++){
            b = 100;
            c = 100;
            a = neededMinCoins[i - 1];
            if (i-4 >= 0) b = neededMinCoins[i - 4];
            if (i-5 >= 0) c = neededMinCoins[i - 5];
            neededMinCoins[i] = Math.min(Math.min(a, b), c) + 1;
        }

        int[] arr = new int[14];
        int amount = 13;
        for (int i = 1; i <= amount; i++) {
            int min = amount;
            for (int coin : coins) {
                if (i - coin < 0) continue;
                if (min > arr[i - coin])
                    min = arr[i - coin];
                arr[i] = min + 1;
            }
        }

        print(Arrays.toString(neededMinCoins));
        print(Arrays.toString(arr));
        print("최소 코인 배열은: " + neededMinCoins[n] + "개");



    }
}
