package JavaCodeTest.A_0003_Reorder_DataInLogFiles;

// https://leetcode.com/problems/reorder-data-in-log-files
// https://blog.naver.com/lifedesigner88/223457482418

import java.util.*;

public class Reorder_DataLogFile {
    public static void main(String[] args) {

        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] result = {"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"};

        ListSort listSort = new ListSort();
        String[] sortedLogs = listSort.reorderLogFiles(logs);
        boolean isCorrect = Arrays.equals(sortedLogs, result);
        System.out.println(isCorrect);

        IndexOfArray indexOfArray = new IndexOfArray();
        String[] sortedLogs2 = indexOfArray.reorderLogFiles(logs);
        boolean isCorrect2 = Arrays.equals(sortedLogs2, result);
        System.out.println(isCorrect2);

    }
}

// ❤️ Beautiful Solution ❤️

class ListSort {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();

        for (String log : logs)
            if (Character.isDigit(log.split(" ", 2)[1].charAt(0)))
                letter.add(log);
            else
                digit.add(log);

        letter.sort((o1, o2) -> {
            String[] So1 = o1.split(" ", 2);
            String[] So2 = o2.split(" ", 2);
            int compare = So1[1].compareTo(So2[1]);
            if (compare != 0) return compare;
            return So1[0].compareTo(So2[0]);
        });

        letter.addAll(digit);
        return letter.toArray(new String[0]);
    }
}


class IndexOfArray {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {

            String So1 = o1.substring(o1.indexOf(" ") + 1);
            String So2 = o2.substring(o2.indexOf(" ") + 1);

            boolean Do1 = Character.isDigit(So1.charAt(0));
            boolean Do2 = Character.isDigit(So2.charAt(0));

            if (Do1 && Do2) return 0;
            if (Do1) return 1;
            if (Do2) return -1;

            int compare = So1.compareTo(So2);
            return compare != 0 ? compare : o1.compareTo(o2);

        });
        return logs;
    }
}
