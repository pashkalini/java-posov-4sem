package collections;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MapArrays {
    public static void main(String[] args) throws Exception {
        String str = "banana";
        System.out.println("---Task 1---");
        System.out.println(Task1(str));

        System.out.println("---Task 2---");
        System.out.println(Task2(str));

        System.out.println("---Task 3---");
        Map<String, Integer> wordsHashMap = new HashMap<>();
        Map<String, Integer> wordsTreeMap = new TreeMap<>();
        Map<String, Integer> wordsLinkedHashMap = new LinkedHashMap<>();

        Task3(Paths.get("sherlock.txt"), wordsHashMap);
        Task3(Paths.get("sherlock.txt"), wordsLinkedHashMap);
        Task3(Paths.get("sherlock.txt"), wordsTreeMap);


        System.out.println("wordsHashSet = " + wordsHashMap);
        System.out.println("wordsLinkedHashSet = " + wordsLinkedHashMap);
        System.out.println("wordsTreeSet = " + wordsTreeMap);
    }

    //1. Дана строка. Посчитать каждый символ, сколько раз он встретился.
    // Например, строка “banana” должна выдать массив Map<Character, Integer>:
    //     'b' -> 1     'a' -> 3       'n' -> 2
    private static Map<Character, Integer> Task1(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                cnt++;
                map.put(c, cnt);
            } else
                map.put(c, 1);
        }
        return map;
    }

    //2. Аналогично предыдущему, но выдать Map<Character, List<Integer>> со списком индексов,
    // где встретился символ:
    //    b -> [0]      a -> [1, 3, 5]      n -> [2, 4]
    private static Map<Character, List<Integer>> Task2(String str) {
        Map<Character, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            List<Integer> newL = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                if (c == str.charAt(j))
                    newL.add(j);
            }
            map.put(c, newL);
        }
        return map;
    }

    //3.

    private static void Task3(Path myPath, Map<String, Integer> map) throws Exception {
        try (Scanner text = new Scanner(myPath, StandardCharsets.UTF_8).useDelimiter("(!|,|\\.|\\?|\\s)+")) { //
            while (text.hasNext()) {
                String word = text.next().toLowerCase();

                // for (int i = 0; i < str.length() - 1; i++) {
                //     char c = str.charAt(i);
                if (map.containsKey(word)) {
                    int cnt = map.get(word);
                    cnt++;
                    map.put(word, cnt);
                } else
                    map.put(word, 1);
            }
        }
    }

}
