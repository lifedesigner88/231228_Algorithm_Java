package Programers.Lv1.D2411;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/258712




public class P001_가장_많이_받은_선물 {
    
    static Map<String, Map<String, Integer>> sent = new HashMap<>();
    static Map<String, Integer> giftIndex = new HashMap<>();
    static Map<String, Integer> predic = new HashMap<>();
    
    public static void main(String[] args) {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy",
                "alessandro conan", "david alessandro", "alessandro david"};

        System.out.println(solution1(friends, gifts));
        System.out.println(solution2(friends, gifts));
    }

    public static int solution1(String[] friends, String[] gifts) {

        // 데이터 전처리.
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            // 파싱데이터 입력
            sent.putIfAbsent(giver, new HashMap<>());
            Map<String, Integer> giversMap = sent.get(giver);
            giversMap.put(receiver, giversMap.getOrDefault(receiver, 0) + 1);

            // 선물지수 입력
            giftIndex.put(giver, giftIndex.getOrDefault(giver, 0) + 1);
            giftIndex.put(receiver, giftIndex.getOrDefault(receiver, 0) - 1);
        }

        // 다음달 선물 받을 사람 예측
        predicResult(friends);

        return predic.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
    
   
    /*
    *
    * Map<String, Map<String, Integer>> 구조에서
    * 선물지수를 구하기위해 특정 회원의 받은 선물수를 따로 구하는 코드.
    *
    * */


    public static int solution2(String[] friends, String[] gifts) {

        // 데이터 전처리.
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            // 파싱데이터 입력
            sent.putIfAbsent(giver, new HashMap<>());
            Map<String, Integer> giversMap = sent.get(giver);
            giversMap.put(receiver, giversMap.getOrDefault(receiver, 0) + 1);

        }

        //
        for (String friend : friends) {
            int giveNum = sent.getOrDefault(friend, new HashMap<>())
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            int receiveNum = sent.values()
                    .stream()
                    .mapToInt(hash -> hash.getOrDefault(friend, 0))
                    .sum();
            giftIndex.put(friend, giveNum - receiveNum);
        }
        
        predicResult(friends);

        return predic.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
    
    public static void predicResult(String[] friends) {
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1 ; j < friends.length; j++) {
                
                String A = friends[i];
                String B = friends[j];
                
                int AtoB = sent.getOrDefault(A, new HashMap<>())
                        .getOrDefault(B, 0);
                
                int BtoA = sent.getOrDefault(B, new HashMap<>())
                        .getOrDefault(A, 0);
                
                // 선물 받게될 사람을 선정
                String bigVal = null;
                
                if (AtoB == BtoA) {
                    int indexA = giftIndex.getOrDefault(A, 0);
                    int indexB = giftIndex.getOrDefault(B, 0);
                    if(indexA != indexB)
                        bigVal = indexA > indexB ? A : B;
                } else
                    bigVal = AtoB > BtoA ? A : B;
                
                if (bigVal != null)
                    predic.put(bigVal, predic.getOrDefault(bigVal, 0) + 1);
            }
        }
    }

}
