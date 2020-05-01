package classes.ver1;

import classes.ver1.Student;

public class Tester {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = s1;

        s1.name = "John";
        s2.name = "Ilya";

        s1.age = 42;
        s2.age = 41;
        System.out.println(s1.name);
        s1.sayHello();
        s2.sayHello();
        s3.sayHello();
    }

}
