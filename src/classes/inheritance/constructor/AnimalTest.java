package classes.inheritance.constructor;

public class AnimalTest {
    public static void main(String[] args) {
        Cat c1 = new Cat();
        Cat c2 = new Cat("Karamelka");
        c1.sayHello();
        c2.sayHello();
    }
}