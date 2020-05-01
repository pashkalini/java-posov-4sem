package classes.inheritance;

/*
Ключевое слово extends говорит, что класс наследуюется
от другого:
A extends B = A расширяет B = A наследник B =
B базовый класс для A.

После этого Cat имеет все поля и методы класса Animal
(не конструкторы)
 */
public class Cat extends Animal {
    //уже есть name, getSound, sayHello
    //переопределим (override) метод getSound
    // т.е. у всех котов, но будет работать по-другому:
    // достаточно написать метод с аналогичным заголовком
    @Override
    public String getSound() {
        return "meow";
    }

    // этот метод есть только у Cat
    public void catchMouse() {
        System.out.println("Om nom nom");
    }
}