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

    }
}

class ListSort {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();

        for (String log : logs)
            if (Character.isDigit(log.split(" ")[1].charAt(0)))
                digit.add(log);
            else
                letter.add(log);

        letter.sort((o1, o2) -> {
            String[] So1 = o1.split(" ", 2);
            String[] So2 = o2.split(" ", 2);
            int compare = So1[1].compareTo(So2[1]);
            if (compare == 0) return So1[0].compareTo(So2[0]);
            else return compare;
        });

        letter.addAll(digit);
        return letter.toArray(new String[0]);
    }
}

class ArraySort {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (a, b) -> {
            int identA = a.indexOf(" ") + 1;
            int identB = b.indexOf(" ") + 1;

            boolean isLetterA = Character.isLetter(a.charAt(identA));
            boolean isLetterB = Character.isLetter(b.charAt(identB));

            if (isLetterA && isLetterB) {
                int cmp = a.substring(identA).compareTo(b.substring(identB));
                if (cmp != 0) return cmp;
                return a.compareTo(b);
            } else if (isLetterA)
                return -1;
            else if (isLetterB)
                return 1;
            else return 0;
        });
        return logs;
    }
}

class FastSolution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) return logs;
        List<String> letterLogs = new ArrayList<>(), digitLogs = new ArrayList<>();
        separateLettersDigits(logs, letterLogs, digitLogs);
        sortLetterLogs(letterLogs);
        return generateOutput(letterLogs, digitLogs);
    }

    void separateLettersDigits(String[] input,
                               List<String> letterLogs,
                               List<String> digitLogs) {
        for (String log : input)
            if (Character.isDigit(log.charAt(log.length() - 1)))
                digitLogs.add(log);
            else
                letterLogs.add(log);
    }

    void sortLetterLogs(List<String> letterLogs) {
        letterLogs.sort((o1, o2) -> {
            String s1 = o1.substring(o1.indexOf(" ") + 1);
            String s2 = o2.substring(o2.indexOf(" ") + 1);
            return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
        });
    }

    String[] generateOutput(List<String> letterLogs, List<String> digitLogs) {
        String[] output = new String[letterLogs.size() + digitLogs.size()];
        for (int i = 0; i < letterLogs.size(); i++)
            output[i] = letterLogs.get(i);
        for (int i = letterLogs.size(); i < output.length; i++)
            output[i] = digitLogs.get(i - letterLogs.size());
        return output;
    }
}