package JavaCodeTest.A_0012_Best_Time_to_Buy_and_Sell_Stock;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = 5;


        MinPrice minPrice = new MinPrice();
        System.out.println(minPrice.maxProfit(prices));

        BruteForce bf = new BruteForce();
        System.out.println(bf.maxProfit(prices));


    }
}


// ❤️ Beautiful Solution ❤️


class MinPrice {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}


// 시간초과
class BruteForce {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i];
                if (maxProfit < profit) maxProfit = profit;
            }

        return maxProfit;
    }
}
