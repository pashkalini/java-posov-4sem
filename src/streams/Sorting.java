package streams;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        // начнем с с оритировки массива
        int[] a = {10, 20, 30, 40, 20, 15};
        // вспомогательный класс
        Arrays.sort(a); // просто сортировка, естественный порядок = по возрастанию
        System.out.println(Arrays.toString(a));
        // для массивов базовых типов (int и т.п.) указать порядок сортировки не получится

        String[] b = {"abc", "ooo", "xy", "s"};
        Arrays.sort(b); // етественный порядок = алфавитный
        System.out.println(Arrays.toString(b));
        Arrays.sort(b, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int l1 = s1.length();
                int l2 = s2.length();

                /*if (l1 < l2)
                    return -1;
                else if (l1 == l2)
                    return 0;
                else
                    return 1;
                */
                return l1 - l2;
            }
        }); // Comparator - сравнитель
        System.out.println(Arrays.toString(b));
        // Свойство соритровки в java. Оиднаоквые элементы при сортировке не меняются местами

        // Arrays.sort(b, (s1, s2) -> s1.length() - s2.length());
        Arrays.sort(b, Comparator.comparingInt(String::length));

        // Comparator.reverseOrder() - обратный к естественному порядок

        // Сортировка списков

        List<Integer> c = new ArrayList<>();
        c.add(10);
        c.add(20);
        c.add(30);
        c.add(20);
        c.add(15);
        Collections.sort(c); //Coollections - вспомогательные функции для коллекций
        Collections.sort(c, Comparator.naturalOrder());
        c.sort(Comparator.naturalOrder());
        System.out.println(c);

        //нестандартный компаратор пишется лямда выражением
        // кроме того, есть много встроенных компараторов: Comparator
    }
}
