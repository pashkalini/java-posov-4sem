package classes.inheritance.constructor;

public class Cat extends Animal {
    // При создании гарантированно вызывается его конструктор.
    // А перед этим гарантированно вызываются конструкторы всех базовых классов.
    // Логично: создать кота в частности означает создать животное
    public Cat() {
        //super похож на this, super ссылается на класс,
        // от которого унаследованы.
        // В данном случае это ссылка на конструктор базового класса
        super("Murzik");
    }

    // можно просто получить имя и передать его конструктору базового класса
    public Cat(String name) {
        super(name);
    }
    // можно сделать еще какие-то действия
    // важно только что

    @Override
    public String getSound() {
        return "meow";
    }

    // этот метод есть только у Cat
    public void catchMouse() {
        System.out.println("Om nom nom");
    }
}