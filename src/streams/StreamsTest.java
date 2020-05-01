package streams;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsTest {
    public static void main(String[] args) throws Exception {
        //integersStream(3).map(x -> 1 / x).forEach(System.out::println);
        System.out.println("--- TASK 1 ---");
        System.out.println(integersStream(3).sum()); // сумма чисел от 1 до n
        System.out.println(integersStream(3).map(x -> x * x).sum());
        System.out.println(integersStream(4).map(x -> x * x * x).sum());
        System.out.println(integersStream(3).mapToDouble(x -> 1.0 / x).sum());

        System.out.println("\n--- TASK 2 ---");
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(onlyOdd(intList));

        System.out.println("\n--- TASK 3 ---");
        System.out.println("Average length of words: " + averageLength(Path.of("sherlock.txt")));
        System.out.println("Max length of words: " + maxLength(Path.of("sherlock.txt")));
        System.out.println("Min length of words: " + minLength(Path.of("sherlock.txt")));
        System.out.println("Word with max length: " + maxWord(Path.of("sherlock.txt")));

        System.out.println("\n--- TASK 4 ---");
        long orel = orelReshka();
        System.out.println("Number of \"orel\": " + orel);
        ;
        System.out.println("Number of \"reshka\": " + (100 - orel));

        System.out.println("\n--- TASK 5 ---");
        System.out.println("Number of words: " + numberOfWords(Path.of("sherlock.txt")));

        System.out.println("\n--- TASK 6 ---");
        System.out.println("Number of words with first letter in UpperCase: "
                + numberOfUpperCase(Path.of("sherlock.txt")));


    }

    //1. Дано n. Посчитайте сумму
    private static IntStream integersStream(long n) {
        return IntStream.iterate(1, x -> x + 1).limit(n);
    }

    //2. Дан список чисел. Верните новый список, в котором удалены все четные числа.
    private static List<Integer> onlyOdd(List<Integer> intList) {
        return intList.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
    }

    //3. Дан файл. Посчитайте среднюю длину слов в этом файле.
    // А еще максимальные и минимальные длины слов. Используйте подходящий Collector.
    private static double averageLength(Path file) throws Exception {
        try (
                Scanner text = new Scanner(file, StandardCharsets.UTF_8)
        ) {
            //text.useDelimiter(" ");
            OptionalDouble average = text.tokens().mapToInt(String::length).average();
            return average.orElse(0);
        }
    }

    private static int maxLength(Path file) throws Exception {
        try (
                Scanner text = new Scanner(file, StandardCharsets.UTF_8)
        ) {
            OptionalInt max = text.tokens().mapToInt(String::length).max();
            return max.orElse(0);
        }
    }

    private static int minLength(Path file) throws Exception {
        try (
                Scanner text = new Scanner(file, StandardCharsets.UTF_8)
        ) {
            OptionalInt min = text.tokens().mapToInt(String::length).min();
            return min.orElse(0);
        }
    }

    private static String maxWord(Path file) throws Exception {
        try (
                Scanner text = new Scanner(file, StandardCharsets.UTF_8)
        ) {
            int max = maxLength(Path.of("sherlock.txt"));
            Optional maxW = text.tokens().filter(x -> x.length() == max).findFirst();
            //Collector.of(() -> "", )
            return (String) maxW.orElse("error");
        }
    }

    //5. Посчитайте количество слов в потоке.
    private static long numberOfWords(Path file) throws Exception {
        try (
                Scanner text = new Scanner(file, StandardCharsets.UTF_8)
        ) {
            return text.tokens().count();
        }
    }

    //6. Сколько в тексте слов, начинающихся с заглавной буквы?
    private static long numberOfUpperCase(Path file) throws Exception {
        try (
                Scanner text = new Scanner(file, StandardCharsets.UTF_8)
        ) {
            return text.tokens().filter(x -> Character.isUpperCase(x.charAt(0))).count();
        }
    }

    //4. Бросьте монетку 100 раз, сколько раз выпал орёл, а сколько решка?
    private static IntStream randomStream() {
        Random r = new Random();

        return IntStream.generate(() -> r.nextInt(2));
    }

    private static long orelReshka() {
        IntStream orel = randomStream();

        return orel.limit(100).filter(x -> x == 0).count();
    }

}






















