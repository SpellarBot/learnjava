package com.rightkarma.learnjava.snippets.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList linkedListCyclic ;
    LinkedList linkedListNonCyclic ;

    @Before
    public void setup(){
        linkedListCyclic = new LinkedList();
        LinkedList.Node headNode = new LinkedList.Node("101");
        linkedListCyclic.appendIntoTail(headNode);
        linkedListCyclic.appendIntoTail(new LinkedList.Node("201"));
        linkedListCyclic.appendIntoTail(new LinkedList.Node("301"));
        linkedListCyclic.appendIntoTail(new LinkedList.Node("401"));
        linkedListCyclic.appendIntoTail(headNode);

        linkedListNonCyclic = new LinkedList();
        linkedListNonCyclic.appendIntoTail(new LinkedList.Node("101"));
        linkedListNonCyclic.appendIntoTail(new LinkedList.Node("201"));
        linkedListNonCyclic.appendIntoTail(new LinkedList.Node("301"));
        linkedListNonCyclic.appendIntoTail(new LinkedList.Node("401"));

    }
    @Test
    public void isCyclicTrue() {
        assertTrue(linkedListCyclic.isCyclic());
    }
    @Test
    public void isCyclicFalse() {
        assertFalse(linkedListNonCyclic.isCyclic());
    }
    @Test
    public void testLengthCyclic(){
        assertEquals(4, linkedListNonCyclic.lengthIterative());
    }
    @Test
    public void testLengthNonCyclic(){
        assertEquals(4, linkedListNonCyclic.lengthIterative());
    }
}
