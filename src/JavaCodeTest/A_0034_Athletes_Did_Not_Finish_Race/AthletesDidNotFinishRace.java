package JavaCodeTest.A_0034_Athletes_Did_Not_Finish_Race;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AthletesDidNotFinishRace {
    public static void main(String[] args) {

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        UseMap useMap = new UseMap();
        String answer = useMap.solution(participant, completion);
        System.out.println(answer);

        UseArraySort useArraySort = new UseArraySort();
        String answer2 = useArraySort.solution(participant, completion);
        System.out.println(answer2);

    }
}

// ❤️ Beautiful Solution ❤️


// import java.util.*;

class UseMap {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> members = new HashMap<>();

        for (String p : participant)
            members.put(p, members.getOrDefault(p, 0) + 1);

        for (String c : completion)
            if (members.get(c) == 1) members.remove(c);
            else members.put(c, members.get(c) - 1);

        return members.entrySet().iterator().next().getKey();
    }
}


// import java.util.*;

class UseArraySort {
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        int count = 0;
        for (String a : completion)
            if (!a.equals(participant[count++]))
                return participant[--count];

        return participant[participant.length - 1];
    }
}