package net.yoshkin.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by TiM on 06.04.2018.
 */
public class LinkedListImplTest {
    private LinkedList list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedListImpl();
    }

    @Test
    public void testAppend() throws Exception {
        list.append(10);
        assertEquals(1, list.size());
        assertNotNull(list.getFirstNode());
        assertNotNull(list.getLastNode());
        assertEquals(list.getFirstNode(), list.getLastNode());
        assertEquals(10, list.getFirstNode().getValue());

        list.append(20);
        assertEquals(2, list.size());
        assertEquals(10, list.getFirstNode().getValue());
        assertEquals(20, list.getLastNode().getValue());

    }

    @Test
    public void removeLast() throws Exception {
        list.append(10);
        list.append(20);
        list.append(30);

        assertEquals(3, list.size());

        list.removeLast();
        assertEquals(2, list.size());
        assertEquals(20, list.getLastNode().getValue());
        assertNull(list.getLastNode().next());

        list.removeLast();
        assertEquals(1, list.size());
        assertEquals(10, list.getLastNode().getValue());
        assertEquals(10, list.getFirstNode().getValue());
        assertNull(list.getLastNode().next());

        list.removeLast();
        assertEquals(0, list.size());
        assertNull(list.getFirstNode());
        assertNull(list.getLastNode());

        list.removeLast();
        assertEquals(0, list.size());
        assertNull(list.getFirstNode());
        assertNull(list.getLastNode());
    }

    @Test
    public void removeGreaterThan() throws Exception {
        list.append(30);
        list.append(20);
        list.append(30);
        list.append(25);
        list.append(30);

        list.removeGreaterThan(25);
        assertEquals(2, list.size());
        assertEquals(20, list.getFirstNode().getValue());
        assertEquals(25, list.getLastNode().getValue());

        list.removeGreaterThan(20);
        assertEquals(1, list.size());
        assertEquals(20, list.getFirstNode().getValue());
        assertEquals(20, list.getLastNode().getValue());

        list.removeGreaterThan(10);
        assertEquals(0, list.size());
        assertNull(list.getFirstNode());
        assertNull(list.getLastNode());
    }
}