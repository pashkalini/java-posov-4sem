package classes.inheritance;

public class AnimalTest {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.name = "Barsik";
        a1.sayHello();

        Cat c1 = new Cat();
        c1.name = "Murzik";
        c1.sayHello();

        Dog d1 = new Dog();
        d1.name = "Sharik";
        d1.sayHello();

        //Если класс A наследует класс B (A extends B),
        //то A - подтип типа B. (как подмножество в теории
        //множеств)
        Animal a2 = new Cat();
        //т.е. переменная a2 может хранить любых животных,
        //т.к. у нее тип Animal. В частности, она может хранить
        //кота. (List<Integer> l = new ArrayList<>()  )
        a2.name = "Korzhik";
        a2.sayHello();
        //В Java всегда вызывается метод из фактического класса.
        //т.к. a2 это на самом деле Cat, то и будет вызван метод
        //для кота.
        //Это называется "виртуальный метод", в Java все
        //методы виртуальные.

        // переменная c1  - это Cat, можно вызвать catchMouse
        c1.catchMouse();
        //a2.catchMouse() - НЕЛЬЗЯ! Не работает

        // instanceof - оператор проверки типа содержимого
        System.out.println(a2 instanceof Animal); //true (!)
        System.out.println(a2 instanceof Cat); //true
        System.out.println(a2 instanceof Dog); // false

        // приведение типа. Опаратор (тип)
        //(double)n  - приведение типов между базовыми типами, типами обертки.
        // либо просим рассматривать как тип потомок
        ((Cat) a2).catchMouse(); // теперь можно!!
        //  такое приведение типа ничего не преобразует,
        // объект внутри a2 остается ровно таким же, каким он был
        // Это все тот же Коржик. Но Java **проверит**, что этот объект
        // действительно является котом (иначе ошибка).
    }
}