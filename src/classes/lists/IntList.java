package classes.lists;

import java.util.Scanner;

public class IntList {
    private Node first;

    public IntList() {
        first = null;
    }

    public void add(int value) {
        //el.next = first;
        first = new Node(value, first);
    }

    public void print() {
        System.out.println(first.toString());
    }

    public int length() {
        int cnt = 0;
        Node nd = first;

        while (nd != null) {
            cnt++;
            nd = nd.getNext();
        }
        return cnt;
    }

    public int getElementByIndex(int index) {
        int cnt = 0;
        Node nd = first;

        while (nd != null) {
            if (cnt == index)
                break;

            nd = nd.getNext();
            cnt++;
        }
        if (nd == null)
            throw new IndexOutOfBoundsException();

        return nd.getValue();
    }

    public void deleteElementByIndex(int index) {
        int cnt = 0;
        Node nd = first;

        while (nd != null) {
            if (index == 0) {
                nd.value = nd.next.value;
                nd.next = nd.next.next;
                break;
            }
            if (cnt == index - 1) {
                nd.next = nd.next.next;
                break;
            } else {
                nd = nd.next;
                cnt++;
            }
        }
    }

    public void insertElementByIndex(int element, int index) {
        int cnt = 0;
        Node nd = first;

        if (index == 0) {
            first = new Node(element, nd);
        }

        while (nd != null) {
            if (cnt == index - 1) {
                Node ndNew = new Node(element, null);
                ndNew.next = nd.next;
                nd.next = ndNew;
            }
            nd = nd.next;
            cnt++;
        }
    }

}