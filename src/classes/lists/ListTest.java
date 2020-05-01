package classes.lists;


public class ListTest {
    public static void main(String[] args) {
        IntList l1 = new IntList();
        //System.out.println(l1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.print();
        System.out.println(l1.length());
        System.out.println(l1.length());
        System.out.println(l1.getElementByIndex(0));
        l1.deleteElementByIndex(0);
        l1.print();
        l1.insertElementByIndex(6, 1);
        //l1.insertElementByIndex(3, 1);
        l1.print();
    }
}
