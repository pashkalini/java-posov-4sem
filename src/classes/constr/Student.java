package classes.constr;

public class Student {
    //поля
    //Полям можно сразу присваивать значения
    String name = "default";
    int age = 0;

    //конструкторы
    Student() {
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //методы
    void sayHello() {
        System.out.println("Hello, my name is " + name + ". I'm " + age + ".");
    }
}
