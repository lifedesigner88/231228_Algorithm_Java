package Programers.Lv1.D2411;


// https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class P006_바탕화면정리 {

        private String[] wallpaper;
        private int width, height;
        private final int[] answer = new int[4]; // [lux, luy, rdx, rdy]

        public int[] solution(String[] wallpaper) {

            this.wallpaper = wallpaper;
            height = wallpaper.length;
            width = wallpaper[0].length();

            findLuxLuy();
            findRdxRdy();

            return answer;
        }


        private String getValue(int x, int y) {
            char c = wallpaper[x].charAt(y);
            return Character.toString(c);
        }

        private void findLuxLuy() {

            findLux:
            for(int x = 0; x < height; x++)
                for (int y = 0; y < width; y++)
                    if (getValue(x, y).equals("#")) {
                        answer[0] = x;
                        break findLux;
                    }

            findLuy:
            for(int y = 0; y < width; y++)
                for (int x = 0; x < height; x++)
                    if (getValue(x, y).equals("#")) {
                        answer[1] = y;
                        break findLuy;
                    }

        }

        private void findRdxRdy() {

            findRdx:
            for(int x = height - 1; x >= 0; x--)
                for (int y = width - 1; y >=0; y--)
                    if (getValue(x, y).equals("#")) {
                        answer[2] = x + 1;
                        break findRdx;
                    }

            findRdy:
            for(int y = width - 1; y >=0; y--)
                for (int x = height - 1; x >= 0; x--)
                    if (getValue(x, y).equals("#")) {
                        answer[3] = y + 1;
                        break findRdy;
                    }

        }

}



class Solution1 {

    private String[] wallpaper;
    private int width, height;
    private final int[] answer = {
            Integer.MAX_VALUE, // lux
            Integer.MAX_VALUE, // luy
            Integer.MIN_VALUE, // rdx
            Integer.MIN_VALUE  // rdy
    }; // [lux, luy, rdx, rdy]

    public int[] solution(String[] wallpaper) {

        this.wallpaper = wallpaper;
        height = wallpaper.length;
        width = wallpaper[0].length();

        findBounds();

        return answer;
    }

    // 주어진 위치의 값을 반환
    private boolean isWall(int x, int y) {
        return wallpaper[x].charAt(y) == '#';
    }

    private void findBounds() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (isWall(x, y)) {
                    answer[0] = Math.min(answer[0], x);     // lux
                    answer[1] = Math.min(answer[1], y);     // luy
                    answer[2] = Math.max(answer[2], x + 1); // rdx
                    answer[3] = Math.max(answer[3], y + 1); // rdy
                }
            }
        }
    }
}
