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

        FastSolution fastSolution = new FastSolution();
        String[] sortedLogs3 = fastSolution.reorderLogFiles(logs);
        boolean isCorrect3 = Arrays.equals(sortedLogs3, result);
        System.out.println(isCorrect3);

    }
}

// ❤️ Solution 1 ❤️

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


// Sring[] 을 생성하지 않아서 위 코드보다 빠름.
class IndexOfArray {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {

            int identA = o1.indexOf(" ") + 1;
            int identB = o2.indexOf(" ") + 1;

            String So1 = o1.substring(identA);
            String So2 = o2.substring(identB);

            boolean Do1 = Character.isDigit(o1.charAt(identA));
            boolean Do2 = Character.isDigit(o2.charAt(identB));

            if (Do1 && Do2) return 0;
            else if (Do1) return 1;
            else if (Do2) return -1;
            else {
                int compare = So1.compareTo(So2);
                if (compare != 0) return compare;
                return o1.compareTo(o2);
            }
        });
        return logs;
    }
}

class FastSolution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) return logs;
        List<String> letterLogs = new ArrayList<>(), digitLogs = new ArrayList<>();
        separateDigitsDigits(logs, letterLogs, digitLogs);
        sortDigitLogs(letterLogs);
        return generateOutput(letterLogs, digitLogs);
    }

    void separateDigitsDigits(String[] input,
                              List<String> letterLogs,
                              List<String> digitLogs) {
        for (String log : input)
            if (Character.isDigit(log.charAt(log.length() - 1)))
                digitLogs.add(log);
            else
                letterLogs.add(log);
    }

    void sortDigitLogs(List<String> letterLogs) {
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