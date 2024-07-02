package JavaCodeTest_Non_Linear.B_0061_Dual_Priority_Queue;

import java.util.*;

public class DualPriorityQueue {
    public static void main(String[] args) {

        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        UseTreeMap useTreeMap = new UseTreeMap();
        int[] result = useTreeMap.solution(operations);
        System.out.println(Arrays.toString(result));

        UseDoublePQ useDoublePQ = new UseDoublePQ();
        int[] result2 = useDoublePQ.solution(operations);
        System.out.println(Arrays.toString(result2));

    }
}

// ❤️ Beautiful Solution ❤️

class UseTreeMap {

    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (String operation : operations) {

            String[] split = operation.split(" ");
            Integer intKey = Integer.parseInt(split[1]);

            if (split[0].equals("I"))
                treeMap.put(intKey, treeMap.getOrDefault(intKey, 0) + 1);

            else if (!treeMap.isEmpty())

                if (intKey == 1) {

                    Integer key = treeMap.lastKey();
                    Integer count = treeMap.get(key);
                    if (count == 1) treeMap.pollLastEntry();
                    else treeMap.put(key, treeMap.get(key) - 1);

                } else {

                    Integer key = treeMap.firstKey();
                    Integer count = treeMap.get(key);
                    if (count == 1) treeMap.pollFirstEntry();
                    else treeMap.put(key, treeMap.get(key) - 1);
                }
        }
        if (treeMap.isEmpty()) return new int[]{0, 0};
        return new int[]{treeMap.lastKey(), treeMap.firstKey()};
    }
}


class UseDoublePQ {

    public int[] solution(String[] operations) {

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] op = operation.split(" ");

            if ("I".equals(op[0])) {

                minHeap.add(Integer.valueOf(op[1]));
                maxHeap.add(Integer.valueOf(op[1]));

            } else if ("D".equals(op[0])) {

                if ("1".equals(op[1]))
                    minHeap.remove(maxHeap.poll());

                else if ("-1".equals(op[1]))
                    maxHeap.remove(minHeap.poll());
            }
        }
        Integer maxValue = maxHeap.poll();
        Integer minValue = minHeap.poll();
        return new int[]{
                (maxValue == null) ? 0 : maxValue,
                (minValue == null) ? 0 : minValue
        };
    }
}
