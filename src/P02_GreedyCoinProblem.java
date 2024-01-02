public class P02_GreedyCoinProblem extends Print{
    public static void main(String[] args) {
        print();

        int[] coins = {1, 5, 10, 25};
        int amount = 99;
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount <= 0)
                break;
            int temp = amount / coins[i];
            count += temp;
            amount -= temp*coins[i];
        }
        print(Math.sqrt(25));
        print(count);


    }
}
