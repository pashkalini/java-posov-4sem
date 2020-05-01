package classes.getset;

public class Tester {
    public static void main(String[] args) {
        Student s1 = new Student("Ilya", 62);
        System.out.println(s1.getName());

        System.out.println(Student.e);
        Student.printE();

        s1.setAge(42);
        s1.sayHello();
    }
}
