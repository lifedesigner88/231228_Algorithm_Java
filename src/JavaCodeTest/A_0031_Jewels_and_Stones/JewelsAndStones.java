package JavaCodeTest.A_0031_Jewels_and_Stones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {

        String jewels = "aA";
        String stones = " aAAbbbb";

        UseHashMap useHashMap = new UseHashMap();
        System.out.println(useHashMap.numJewelsInStones(jewels, stones));

        UseHashSet useHashSet = new UseHashSet();
        System.out.println(useHashSet.numJewelsInStones(jewels, stones));

    }
}


// ❤️ Beautiful Solution ❤️

class UseHashMap {
    public int numJewelsInStones(String jewels, String stones) {

        Map<Character, Integer> map = new HashMap<>();

        for (char s : stones.toCharArray())
            map.put(s, map.getOrDefault(s, 0) + 1);

        int count = 0;
        for (char j : jewels.toCharArray())
            if (map.containsKey(j))
                count += map.get(j);

        return count;
    }
}

class UseHashSet {
    public int numJewelsInStones(String jewels, String stones) {

        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char j : jewels.toCharArray()) set.add(j);
        for (char s : stones.toCharArray())
            if (set.contains(s)) count++;
        return count;

    }
}