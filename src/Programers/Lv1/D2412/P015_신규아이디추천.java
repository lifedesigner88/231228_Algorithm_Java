package Programers.Lv1.D2412;


// https://school.programmers.co.kr/learn/courses/30/lessons/72410
public class P015_신규아이디추천 {
    public String solution(String new_id) {

        // 1단계: 소문자 변환
        new_id = new_id.toLowerCase();

        // 2단계: 허용되지 않은 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3단계: 연속된 마침표 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");

        // 4단계: 처음과 끝 마침표 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");

        // 5단계: 빈 문자열 처리
        if (new_id.isEmpty()) new_id = "a";


        // 6단계: 길이 제한 및 마침표 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }

        // 7단계: 길이 보정
        while (new_id.length() <= 2)
            new_id += new_id.charAt(new_id.length() - 1);

        return new_id;
    }
}
