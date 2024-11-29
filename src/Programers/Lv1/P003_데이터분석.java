package Programers.Lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/250121
public class P003_데이터분석 {

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<String> column = List.of("code", "date", "maximum", "remain");

        int extIndex = column.indexOf(ext);
        int sortIndex = column.indexOf(sort_by);

        return Arrays.stream(data)
                .filter(f -> f[extIndex] < val_ext)
                .sorted(Comparator.comparingInt(s -> s[sortIndex]))
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 20300104, 100, 80},
                {2, 20300804, 847, 37},
                {3, 20300401, 10, 8}
        };
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        int[][] result = solution(data, ext, val_ext, sort_by);
        System.out.println(Arrays.deepToString(result));
    }
}
