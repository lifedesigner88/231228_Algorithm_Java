package Programers.Lv1.D2412;

//https://school.programmers.co.kr/learn/courses/30/lessons/17681
public class P021_1차비밀지도 {
    public String[] solution1(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String raw1 = Integer.toBinaryString(arr1[i]);
            String first = String.format("%" + n + "s", raw1)
                    .replace(" ", "0");

            String raw2 = Integer.toBinaryString(arr2[i]);
            String second = String.format("%" + n + "s", raw2)
                    .replace(" ", "0");

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++)
                if (first.charAt(j) == '0' && second.charAt(j) == '0')
                    sb.append(" ");
                else
                    sb.append("#");

            answer[i] = sb.toString();
        }
        return answer;
    }

    // 오호..
    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // arr1[i]와 arr2[i]를 OR 연산하여 새로운 지도를 생성
            int combined = arr1[i] | arr2[i];

            // StringBuilder로 n비트 만큼 문자열 생성
            StringBuilder sb = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                // j번째 비트를 확인하여 # 또는 공백 추가
                if ((combined & (1 << j)) != 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }

            answer[i] = sb.toString();
        }
        return answer;
    }
}
