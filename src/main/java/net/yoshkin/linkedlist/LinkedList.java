package net.yoshkin.linkedlist;

/**
 * Created by TiM on 06.04.2018.
 */
public interface LinkedList {
    void append(int value);
    void removeLast();
    void removeGreaterThan(int value);

    Node getFirstNode();
    Node getLastNode();
    int size();
}
