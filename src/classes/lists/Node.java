package classes.lists;

public class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public String toString() {
        if (this.next != null) {
            return (this.value + ", " + this.next);
        }
        return Integer.toString(this.value);
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }
}
