package classes.getset;

//get, set методы
public class Student {
    private String name;
    private int age;

    public static double e = 2.718281828459045;

    public static void printE() {
        System.out.println(e);
    }
    //  this нельзя в static

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name + ". I'm " + age + ".");
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
