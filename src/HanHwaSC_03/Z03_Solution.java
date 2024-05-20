package HanHwaSC_03.P03;

import java.util.*;

public class Z03_Solution {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(new Solution().solution(operations)));
    }
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (String operation : operations) {
            String[] split = operation.split(" ");
            Integer intKey = Integer.parseInt(split[1]);

            if ( split[0].equals("I"))              // 값 삽입 & count
                treeMap.put(intKey, treeMap.getOrDefault(intKey, 0) + 1 );

            else if (!treeMap.isEmpty())             // 비어있으면 무시 I 아니면 D 이므로 검사 안해도 됨

                if (intKey == 1) {          // 최대값 제거

                    Integer key = treeMap.lastKey();
                    Integer count = treeMap.get(key);
                    if (count == 1)         // 1개면
                        treeMap.pollLastEntry();
                    else                    // 1개 이상
                        treeMap.put(key, treeMap.get(key) - 1 );
                }

                else {                      // 최소값 제거

                    Integer key = treeMap.firstKey();
                    Integer count = treeMap.get(key);
                    if (count == 1)
                        treeMap.pollFirstEntry();
                    else
                        treeMap.put(key, treeMap.get(key) - 1 );
                }

        }
        if (treeMap.isEmpty()) return new int[]{0,0};

        return new int[]{
                treeMap.lastKey(),
                treeMap.firstKey()
        };
    }
}


//                    if (treeMap.get(treeMap.firstKey()) > 1)

