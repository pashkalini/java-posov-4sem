package collections;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class CollectionsTasks {
    public static void main(String[] args) throws Exception {
        System.out.println("* - pure function");
        System.out.println("---Task 1---");
        System.out.println(firstTask());

        System.out.println("---Task 2---");
        System.out.println(listReverse(firstTask()));

        System.out.println("---Task 2*---");
        System.out.println(listReversePure(firstTask()));

        System.out.println("---Task 3.1*---");
        System.out.println(evenIndDeletePure(firstTask()));

        System.out.println("---Task 3.1---");
        System.out.println(evenIndDelete(firstTask()));

        List<String> strList = new ArrayList<>(List.of("4", "4", "3", "3", "2", "2", "7", "6"));
        System.out.println("\nList: " + strList);
        System.out.println("---Task 3.2*---");
        System.out.println(evenElDeletePure(strList));

        System.out.println("---Task 3.2---");
        System.out.println(EvenElDelete(strList));

        List<Integer> intList = new ArrayList<>(List.of(4, 4, 3, 3, 2, 2, 7, 6));

        System.out.println("---Task 3.3*---");
        System.out.println(evenDigDeletePure(intList));

        System.out.println("---Task 3.3---");
        System.out.println(evenDigDelete(intList));

        System.out.println("---Task 4---");
        List<String> wordsList = new ArrayList<>();
        Set<String> wordsHashSet = new HashSet<>();
        Set<String> wordsLinkedHashSet = new LinkedHashSet<>();
        Set<String> wordsTreeSet = new TreeSet<>();

        readWordsFromFile(Paths.get("sherlock.txt"), wordsList);
        readWordsFromFile(Paths.get("sherlock.txt"), wordsHashSet);
        readWordsFromFile(Paths.get("sherlock.txt"), wordsLinkedHashSet);
        readWordsFromFile(Paths.get("sherlock.txt"), wordsTreeSet);

        System.out.println("wordsList = " + wordsList);
        System.out.println("wordsHashSet = " + wordsHashSet);
        System.out.println("wordsLinkedHashSet = " + wordsLinkedHashSet);
        System.out.println("wordsTreeSet = " + wordsTreeSet);
    }

    //1. Создать список List<String> из чисел от 1 до 100.
    // Здесь и везде реализуйте функцию, которая решает задачу.
    private static List<String> firstTask() {
        List<String> l = new ArrayList<>();

        for (int i = 1; i <= 100; i++)
            l.add(String.valueOf(i));

        return l;
    }


    //2. Дан список, верните новый список, в котором все элементы идут в обратном порядке.
    private static List<String> listReverse(List<String> l) {
        Collections.reverse(l); //TODO сделайте сами
        return l;
    }

    private static List<String> listReversePure(List<String> l) {
        List<String> newL = new ArrayList<>();

        //iter
        for (String s : l)
            newL.add(0, s);

//        for (int i = l.size() - 1; i >= 0; i--)
//            newL.add(l.get(i));

        return newL;
    }

    //3.1 Дан List<String>, удалите в нем все элементы с четным индексом.
    private static List<String> evenIndDeletePure(List<String> l) {
        List<String> newL = new ArrayList<>();
        for (int i = 0; i < l.size() / 2; i++) {
            int k = 2 * i + 1;

            newL.add(l.get(k));
        }
        return newL;
    }

    private static List<String> evenIndDelete(List<String> l) {
        for (int i = 0; i < l.size(); i++) {
//            int k = 2 * i;
//            l.remove(k - i);
            //noinspection SuspiciousListRemoveInLoop
            l.remove(i);
        }
        return l;
    }

    //3.2 Дан List<String>, удалить в нем все элементы, которые являются четными числами
    private static List<String> evenElDeletePure(List<String> l) {
        List<String> newL = new ArrayList<>();
        for (String s : l) {
            if (Integer.parseInt(s) % 2 != 0)
                newL.add(s);
        }
        return newL;
    }

    private static List<String> EvenElDelete(List<String> l) {
//        for (int i = 0; i < l.size(); i++) {
//            if (Integer.parseInt(l.get(i)) % 2 == 0)
//                l.remove(2);
//            }
        int i = 0;
        while (i < l.size()) {
            if (Integer.parseInt(l.get(i)) % 2 == 0) {
                l.remove(i);
                continue;
            }
            i++;
        }
        return l;
    }

    //3.3 Дан List<Integer>, удалить в нем все элементы, которые являются четными числами
    private static List<Integer> evenDigDeletePure(List<Integer> l) {
        List<Integer> newL = new ArrayList<>();
        for (Integer s : l) {
            if (s % 2 != 0)
                newL.add(s);
        }
        return newL;
    }

    private static List<Integer> evenDigDelete(List<Integer> l) {
        int i = 0;
        while (i < l.size()) {
            if (l.get(i) % 2 == 0) {
                l.remove(i);
                continue;
            }
            i++;
        }
        return l;
    }


    //4. Взять текстовый файл, желательно большой на русском. Прочитать из него все слова,
    //каждое слово привести к нижнему регистру и сохранить в множестве HashSet. Вывести все слова.
    private static void readWordsFromFile(Path myPath, Collection<String> c) throws Exception {
        try (Scanner text = new Scanner(myPath, StandardCharsets.UTF_8)) {
            while (text.hasNext()) {
                String word = text.next().toLowerCase();
                c.add(word);
            }
        }
    }

}
