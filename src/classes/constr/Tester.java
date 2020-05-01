package classes.constr;

public class Tester {
    public static void main(String[] args) {
        Student s2 = new Student("John", 42);
        s2.sayHello();

        Student s3 = new Student();
        s3.sayHello();
    }
}
