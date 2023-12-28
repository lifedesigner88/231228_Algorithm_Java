import java.util.Arrays;
import java.util.List;

public class C01_HeapSort extends Print {
    public static void main(String[] args) {


        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 7, 0, 1, 2, 8, -1, -2};

        print("\n배열 \t\t: " + Arrays.toString(arr));

        int end = arr.length;

        for (int i = end / 2 - 1; i >= 0; i--) {
            heapify(arr, end, i);
        }

        print("히피파이 \t\t: " + Arrays.toString(arr));

        for (int i = end - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }

        print("힙정렬 \t\t: " + Arrays.toString(arr));

    }


    static void heapify(int[] arr, int end, int root) {
//        xx조건의 경우에 change로직 : left와 right비교해서 자리 change
        int max_index = root;
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        if (left < end && arr[max_index] < arr[left])
            max_index = left;

        if (right < end && arr[max_index] < arr[right])
            max_index = right;

        if (max_index != root) {
            swap(arr, root, max_index);
            heapify(arr, end, max_index);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


//
//        print(Arrays.toString(arr));
//
//        swap(arr, 1, 2);
//
//        print(MaxValue3(arr, 1, 2, 0));


//
//    static void heapify(int[] arr, int root){
////        xx 조건 change 로직
//
//
//        if(change가 발생하면){
//            heapify(arr, root);
//        }
//    }
//


//
//    static int MaxValue3(int[] arr, int a, int b, int c) {
//
//        return Math.max(Math.max(arr[a], arr[b]), arr[c]);
//
//    }
//
////    static int MaxIndexOf(int[] arr, int a, int b) {
////
////    }
//
//    static double log2(double x) {
//        return Math.log10(x) / Math.log10(2);
//    }
//


}
