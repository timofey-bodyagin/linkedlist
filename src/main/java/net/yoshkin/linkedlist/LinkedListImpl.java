package net.yoshkin.linkedlist;

/**
 * Created by TiM on 06.04.2018.
 */
public class LinkedListImpl implements LinkedList {
    private Node firstNode = null;
    private Node lastNode = null;
    private int size = 0;

    @Override
    public void append(int value) {
        Node node = new Node(value);
        if (lastNode != null) {
            node.setPrev(lastNode);
            lastNode.setNext(node);
        } else {
            firstNode = node;
        }
        size++;
        lastNode = node;
    }

    @Override
    public void removeLast() {
        removeNode(lastNode);
    }

    @Override
    public void removeGreaterThan(int value) {
        Node node = firstNode;
        while (node != null) {
            Node nextNode = node.next();
            if(node.getValue() > value) {
                removeNode(node);
            }
            node = nextNode;
        }
    }

    @Override
    public Node getFirstNode() {
        return firstNode;
    }

    @Override
    public Node getLastNode() {
        return lastNode;
    }

    @Override
    public int size() {
        return size;
    }

    private void removeNode(Node node) {
        if (size == 0) {
            return;
        }
        size--;
        if (size == 0) {
            firstNode = null;
            lastNode = null;
        } else {
            if (node.prev() == null) {
                firstNode = node.next();
            } else {
                node.prev().setNext(node.next());
            }
            if (node.next() == null) {
                lastNode = node.prev();
            } else {
                node.next().setPrev(node.prev());
            }
        }
        node.setPrev(null);
        node.setNext(null);
    }
}
