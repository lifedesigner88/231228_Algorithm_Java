class Solution {
    String[] PRONOUNCES = {"aya", "ye", "woo", "ma" };

    public int solution(String[] babbling) {
        int answer = 0;

        for (String babb : babbling)
            if ( isPossible(babb) )answer ++;

        return answer;
    }



    boolean isPossible(String babbling){
        StringBuilder sb = new StringBuilder(babbling);
        for (String pronounce : PRONOUNCES){
            int startIndex = sb.indexOf(pronounce);
            if ( startIndex != -1 )         // 포함시 삭제
                sb.replace(startIndex, startIndex + pronounce.length(),"0");
        }
        try {
            Integer.parseInt(sb.toString());
            return true;            // 숫자 변환 가능하면 발음 가능
        }
        catch (Exception e){        // 문제 생기면 발음 불가능
            return false;
        }
    }
}