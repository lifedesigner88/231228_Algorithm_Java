public class C06_BinarySearch extends Print{
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};


        int start = 0;
        int middle = 0;
        int end = arr.length;
        int find = 7;
        int answer = 0;

        while(start < end) {

            middle = (start + end) / 2;

            if(arr[middle] == find){
                answer = middle; break;}
            else if (arr[middle] < find)
                start = middle + 1;
            else
                end = middle - 1;

        }






    }
}
