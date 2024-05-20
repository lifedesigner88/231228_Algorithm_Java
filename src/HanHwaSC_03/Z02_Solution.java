package HanHwaSC_03;

import java.util.*;


public class Z02_Solution {
    public static void main(String[] args) {
        String[] recode = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Solution test = new Solution();
        System.out.println(Arrays.toString(test.solution(recode)));
    }
}

class Solution {

    User findById(List<User> list ,String id) {
        for (User user : list)
            if (user.getId().equals(id)) return user;
        return null;
    }

    String[] getResult (List<History> history){
        String[] result = new String[history.size()];
        int count = 0;
        for (History a : history) {
            result[count++] = a.getUserNick() + "님이 " + a.getState();
        }
        return result;
    }


    public String[] solution(String[] record) {
        List<User> userList = new ArrayList<>();
        List<History> historyList = new ArrayList<>();

        for (String reco : record) {
            String[] temp = reco.split(" ");

            switch (temp[0]) {          // temp[0] 입력 , [1] id , [2] nick
                case "Enter" :

                    if (findById(userList,temp[1]) == null){
                        User user = new User(temp[1], temp[2]);
                        userList.add(user);
                        historyList.add(new History(user, "들어왔습니다."));
                    }
                    else {
                        User user = findById(userList, temp[1]);
                        user.changeNickName(temp[2]);
                        historyList.add(new History(user, "들어왔습니다."));
                    }
                    break;
                case "Leave" :
                    User user = findById(userList, temp[1]);
                    historyList.add(new History(user, "나갔습니다."));
                    break;

                case "Change" :
                    findById(userList, temp[1]).changeNickName(temp[2]);
                    break;
            }
        }
        return getResult(historyList);
    }
}

class History {
    private final User user;
    private final String state;

    History (User user, String state) {
        this.user = user;
        this.state = state;
    }

    String getUserNick() {return user.getNickName();}
    String getState() {return state;}
}


class User {
    private final String id;
    private String nickName;

    User(String id, String nickName){
        this.id = id;
        this.nickName = nickName;
    }

    void changeNickName(String nickName) {
        this.nickName = nickName;
    }

    String getId() {return id;}
    String getNickName() {return nickName;}
}

