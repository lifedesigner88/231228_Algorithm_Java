package Programers.Lv1.D2411;

// https://school.programmers.co.kr/learn/courses/30/lessons/172928
public class P005_공원산책 {

        private final int[] H_W = new int[2];
        private int width, height;
        private String[] park;

        public int[] solution(String[] park, String[] routes) {
            this.park = park;
            height = park.length;
            width = park[0].length();

            initializeStartPosition();

            for (String route : routes) {
                char direction = route.charAt(0);
                int repeatNum = Character.getNumericValue(route.charAt(2));

                if (canCompleteMove(direction, repeatNum)) {
                    performMove(direction, repeatNum);
                }
            }

            return H_W;
        }

        // 시작 좌표 초기화
        private void initializeStartPosition() {
            outer:
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (getState(h, w).equals("S")) {
                        H_W[0] = h;
                        H_W[1] = w;
                        break outer;
                    }
                }
            }
        }

        // 좌표의 속성 반환
        private String getState(int h, int w) {
            return Character.toString(park[h].charAt(w));
        }

        // 해당 위치가 존재하고 이동 가능한지 확인
        private boolean canMoveTo(int h, int w) {
            return h >= 0 && w >= 0 && h < height && w < width && !getState(h, w).equals("X");
        }

        // 방향과 반복 수를 받아 이동이 가능한지 확인
        private boolean canCompleteMove(char direction, int repeatNum) {
            int[] tempH_W = H_W.clone();
            for (int i = 0; i < repeatNum; i++) {
                if (!moveStep(direction, tempH_W)) {
                    return false;
                }
            }
            return true;
        }

        // 방향과 반복 수를 받아 실제 이동 수행
        private void performMove(char direction, int repeatNum) {
            for (int i = 0; i < repeatNum; i++) {
                moveStep(direction, H_W);
            }
        }

        // 한 단계 이동 수행
        private boolean moveStep(char direction, int[] position) {
            int h = position[0];
            int w = position[1];

            switch (direction) {
                case 'N': h--; break;
                case 'S': h++; break;
                case 'W': w--; break;
                case 'E': w++; break;
            }

            if (canMoveTo(h, w)) {
                position[0] = h;
                position[1] = w;
                return true;
            }
            return false;
        }

    public static void main(String[] args) {

    }
}

// 나의 풀이.
class Solution {

    private final int[] H_W = new int[2];
    private int with, hight;
    private String[] park;

    public int[] solution(String[] park, String[] routes) {

        this.park = park;
        hight = park.length;
        with = park[0].length();

        loop: // 시작 좌표 입력.
        for (int h = 0; h < hight; h++)
            for (int w = 0; w < with; w++)
                if(getState(h, w).equals("S")) {
                    H_W[0] = h;
                    H_W[1] = w;
                    break loop;
                }

        for (String r : routes) {
            char direction = r.charAt(0);
            int repeatNum = Character.getNumericValue(r.charAt(2));
            int[] tempH_W = H_W.clone();
            for (int i = 0; i < repeatNum; i++) // 이동가능 여부 체크
                if (isCanMove(direction, tempH_W) && repeatNum -1 == i)
                    for (int j = 0; j < repeatNum; j++)
                        isCanMove(direction, H_W); // 이동시킴
        }


        return H_W;
    }

    // 좌표의 속성 반환
    private String getState (int h , int w) {
        return Character.toString(park[h].charAt(w));
    }

    // 존재하는 좌표인지 체크
    private boolean isExistAndMove(int h, int w) {
        boolean exist = h >= 0 && w >=0 && h < hight && w < with;
        boolean canMove = false;
        if (exist)
            canMove = !getState(h, w).equals("X");
        return canMove;
    }

    // E,S,W,N 입력받고 H-W 이동시킴
    private boolean isCanMove(char direction, int[] tempHW) {
        switch (direction) {
            case 'N' :
                if (isExistAndMove(tempHW[0] - 1, tempHW[1])) {
                    tempHW[0]--;
                    break;
                } else return false;

            case 'S' :
                if (isExistAndMove(tempHW[0] + 1, tempHW[1])) {
                    tempHW[0]++;
                    break;
                } else return false;
            case 'W' :
                if (isExistAndMove(tempHW[0], tempHW[1] - 1)) {
                    tempHW[1]--;
                    break;
                } else return false;
            case 'E' :
                if (isExistAndMove(tempHW[0], tempHW[1] + 1)) {
                    tempHW[1]++;
                    break;
                } else return false;
        }
        return true;
    }

}



// 최적화
class Solution2 {

    private final int[] currentPosition = new int[2];
    private int width, height;
    private String[] park;

    public int[] solution(String[] park, String[] routes) {
        this.park = park;
        this.height = park.length;
        this.width = park[0].length();

        // 시작 좌표 초기화
        initializeStartPosition();

        // 명령 수행
        for (String route : routes) {
            // 방향과 거리를 구분
            String[] command = route.split(" ");
            char direction = command[0].charAt(0);
            int repeatNum = Integer.parseInt(command[1]);

            // 명령이 수행 가능한지 체크하고 수행
            if (canCompleteMove(direction, repeatNum)) {
                performMove(direction, repeatNum);
            }
        }

        return currentPosition;
    }

    // 시작 좌표 초기화
    private void initializeStartPosition() {
        outer:
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (getState(h, w).equals("S")) {
                    currentPosition[0] = h;
                    currentPosition[1] = w;
                    break outer;
                }
            }
        }
    }

    // 좌표의 상태 확인
    private String getState(int h, int w) {
        return Character.toString(park[h].charAt(w));
    }

    // 해당 위치로 이동 가능한지 확인
    private boolean canMoveTo(int h, int w) {
        return h >= 0 && w >= 0 && h < height && w < width && !getState(h, w).equals("X");
    }

    // 이동을 완료할 수 있는지 확인
    private boolean canCompleteMove(char direction, int repeatNum) {
        int[] tempPosition = currentPosition.clone();
        for (int i = 0; i < repeatNum; i++) {
            if (!moveStep(direction, tempPosition)) {
                return false;
            }
        }
        return true;
    }

    // 실제 이동을 수행
    private void performMove(char direction, int repeatNum) {
        for (int i = 0; i < repeatNum; i++) {
            moveStep(direction, currentPosition);
        }
    }

    // 한걸음 이동
    private boolean moveStep(char direction, int[] position) {
        int h = position[0];
        int w = position[1];

        switch (direction) {
            case 'N': h--; break;
            case 'S': h++; break;
            case 'W': w--; break;
            case 'E': w++; break;
        }

        if (canMoveTo(h, w)) {
            position[0] = h;
            position[1] = w;
            return true;
        }
        return false;
    }
}

