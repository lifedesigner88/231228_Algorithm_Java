package JavaCodeTest_Non_Linear.B_0060_Kth_Largest_Element_in_an_Array;


// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import java.util.ArrayList;
import java.util.List;

public class KthLargestElementinanArray {
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        Solution solution = new Solution();
        int result = solution.findKthLargest(nums, k);
        System.out.println(result);

    }
}


class Solution {

    public int findKthLargest(int[] nums, int k) {
        BinaryHeap heap = new BinaryHeap();
        for (int n : nums) heap.insert(n);
        for (int i = 0; i < k - 1; i++)
            heap.extract();
        return heap.extract();
    }

    static class BinaryHeap {

        public List<Integer> elems;

        public BinaryHeap() {
            elems = new ArrayList<>();
            elems.add(null);
        }

        public void insert(int k) {
            elems.add(k);
            percolateUp();
        }

        public int extract() {
            int extracted = elems.get(1);
            elems.set(1, elems.getLast());
            elems.removeLast();
            maxHeapify(1);
            return extracted;
        }

        public void maxHeapify(int i) {

            int left = i * 2;
            int right = i * 2 + 1;
            int largest = i;

            if (left <= elems.size() - 1
                    && elems.get(left) > elems.get(largest))
                largest = left;

            if (right <= elems.size() - 1
                    && elems.get(right) > elems.get(largest))
                largest = right;

            if (largest != i) {
                swap(largest, i);
                maxHeapify(largest);
            }

        }

        public void swap(int i, int j) {
            int temp = elems.get(i);
            elems.set(i, elems.get(j));
            elems.set(j, temp);
        }

        public void percolateUp() {
            int idx = elems.size() - 1;
            int parentIdx = idx / 2;
            while (parentIdx > 0) {
                if (elems.get(idx) > elems.get(parentIdx))
                    swap(idx, parentIdx);
                idx = parentIdx;
                parentIdx = idx / 2;
            }
        }
    }
}