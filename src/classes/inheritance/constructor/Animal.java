package classes.inheritance.constructor;

public class Animal {

    private String name; // временно публично

    public Animal(String name) {
        this.name = name;
    }

    public String getSound() {
        return "rrrrrr";
    }

    public String getName() { //узнвть имя
        return name;
    }

    public void sayHello() {
        System.out.println(
                "Hello, I'm " + name + ", " + getSound()
        );
    }
}
