package JavaCodeTest_Non_Linear.B_0037_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> permutations = solution.permute(nums);
        System.out.println(permutations);

    }
}


// ❤️ Beautiful Solution ❤️

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> lst = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        DFS(results, new ArrayList<>(), lst);
        return results;

    }

    void DFS(List<List<Integer>> results,
             List<Integer> prevElements, List<Integer> elements) {

        if (elements.isEmpty())
            results.add(new ArrayList<>(prevElements));

        for (Integer e : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);
            prevElements.add(e);

            DFS(results, prevElements, nextElements);
            prevElements.remove(e);
        }

    }
}