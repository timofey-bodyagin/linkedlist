package net.yoshkin.linkedlist;

/**
 * Created by TiM on 06.04.2018.
 */
public class Node {
    private final int value;
    private Node prev = null;
    private Node next = null;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node prev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
