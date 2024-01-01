public class C06_BinarySearch extends Print{
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        print(BinarySearch(arr,19));

    }

    static int BinarySearch(int[]arr, int findValue) {
        int start = 0;
        int middle;
        int end = arr.length-1;
        int find = 19;
        int answer = -1;

        while(start <= end) {

            middle = (start + end) / 2;
            if(arr[middle] == find){
                answer = middle; break;}
            else if (arr[middle] < find)
                start = middle + 1;
            else
                end = middle - 1;
        }
        return answer;
    }



}
