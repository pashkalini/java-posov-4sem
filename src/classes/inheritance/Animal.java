package classes.inheritance;

public class Animal {

    public String name; // временно публично

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
