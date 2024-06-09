package JavaCodeTest.A_0033_Top_K_Frequent_Elements;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 2, 3, 4, 1, 1, 2};
        int k = 3;

        UseBucket ub = new UseBucket();
        int[] result = ub.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));


        UsePQueue up = new UsePQueue();
        int[] result2 = up.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result2));


    }
}


// ❤️ Beautiful Solution ❤️

class UseBucket {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        Map<Integer, List<Integer>> bucketMap = new HashMap<>();
        for (Integer elem : countMap.keySet()) {
            int count = countMap.get(elem);
            if (bucketMap.containsKey(count))
                bucketMap.get(count).add(elem);
            else
                bucketMap.put(count, new ArrayList<>(
                        Collections.singletonList(elem)
                ));
        }

        int index = 0;
        int n = nums.length;
        int[] result = new int[k];

        for (int freq = n; freq >= 0 && index < k; freq--)
            if (bucketMap.get(freq) != null)
                for (int elem : bucketMap.get(freq))
                    result[index++] = elem;

        return result;
    }
}


class UsePQueue {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        Queue<int[]> pQue = new PriorityQueue<>(
                (o1, o2) -> o2[1] - o1[1]);
        for (int elem : countMap.keySet())
            pQue.add(new int[]{elem, countMap.get(elem)});

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = Objects.requireNonNull(pQue.poll())[0];

        return result;
    }
}
