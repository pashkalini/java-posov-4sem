package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {

    public static void main(String[] args) throws Exception {
        // Потоки (Streams)
        // способ работы с посл-тями объектов в функциональном стиле

        // Поток - посл-ть значений определенного типа.
        // Особенности потока:
        //      - может быть одноразовым, т.е. просматриваетсыя только один раз
        //      - может быть бесконечным
        // Создать поток можно разными способами
        //     из массива:
        Arrays.stream(new int[]{1, 2, 3}); // получаем IntStream
        Arrays.stream(new String[]{"abc", "xyz"}); // получаем Stream<String>

        // из коллекции:
        List.of(42, 230, 44, 11, 4).stream();

        // строки из текстового файла как поток:
        //Files.lines(Path.of("a.text"), StandardCharsets.UTF_8);

        // Stream iterate, Stream generate - для бесконечных птоков, ПОЗЖЕ

        // ДВа вида операций над потоком. Терминальные и конвейерные.
        //Терминальная - поток просматривается и возвращает значение. После этого потоком пользоваться нельзя.
        // Пример: сумма всех элементов, максимум и т.п.
        // Конвейерная - преобразовать
        // потока на 1. Реально конвейерные операции выполняются только в момент терминалной.

        // примеры терминальной
        System.out.println(Stream.of(1, 3, 4, 6).count()); // count - кол-во
        System.out.println(Stream.of(1, 3, 5, 6).min(Comparator.naturalOrder())); // min - элемент,
        // только возвращается тип Optional. Он содержит значение или говорит, что значения нет.

        // как собрать элементы в массив или какую-то коллекцию
        System.out.println(Stream.of(1, 3, 4, 6).toArray()); // получить массив
        System.out.println(Stream.of(1, 3, 4, 6).collect(
                Collectors.toList() // получить список; можно еще toSet()
        ));
        System.out.println("hallo" + Stream.of("abc", "xyz", "11", "o").collect(
                //Collectors.toMap(s -> s, s -> s.length());
                Collectors.toMap(s -> s, String::length)
        ));

        Stream.of(10, 20, 30, 50).forEach(x ->
                System.out.println("x = " + x)
        ); // сделать действие для каждого элемента, цикл

        // Конвейерные методы

        System.out.println("функция map");
        Stream.of(10, 20, 30, 40, 50).map(x -> x + 1).forEach(System.out::println);
        System.out.println("функция filter");
        Stream.of(10, 20, 30, 40, 50).filter(x -> x % 20 != 0).forEach(System.out::println);
        System.out.println();
        // skip  - пропусти первые несколько элементов
        // limit - ограничь поток указанным кол-вом эл-тов
        // sorted -  сортирует поток, указывается компаратор

        // flatMap
        System.out.println("flat map");
        Stream.of(10, 20, 30, 40, 50)
                .flatMap(x -> Stream.of(x, x)) // превращает один элемент в два
                .forEach(System.out::println);
    }
}
