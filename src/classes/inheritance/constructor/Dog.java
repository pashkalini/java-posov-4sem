package classes.inheritance.constructor;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String getSound() {
        return "woof";
    }
}
