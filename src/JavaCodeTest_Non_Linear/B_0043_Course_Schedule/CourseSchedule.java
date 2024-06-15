package JavaCodeTest_Non_Linear.B_0043_Course_Schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};

        Reculsive reculsive = new Reculsive();
        boolean result = reculsive.canFinish(numCourses, prerequisites);
        System.out.println(result);

    }
}


// ❤️ Beautiful Solution ❤️


class Reculsive {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> finishToTakeMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            finishToTakeMap.putIfAbsent(pre[0], new ArrayList<>());
            finishToTakeMap.get(pre[0]).add(pre[1]);
        }

        List<Integer> takes = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();
        for (Integer finish : finishToTakeMap.keySet())
            if (isCirculate(finishToTakeMap, finish, takes, taken))
                return false;

        return true;
    }

    boolean isCirculate(Map<Integer, List<Integer>> finishToTakeMap,
                        Integer finish,
                        List<Integer> takes,
                        List<Integer> taken) {
        if (takes.contains(finish)) return true;
        if (taken.contains(finish)) return false;
        if (finishToTakeMap.containsKey(finish)) {
            takes.add(finish);
            for (Integer take : finishToTakeMap.get(finish))
                if (isCirculate(finishToTakeMap, take, takes, taken))
                    return true;
        }
        takes.remove(finish);
        taken.add(finish);
        return false;
    }
}