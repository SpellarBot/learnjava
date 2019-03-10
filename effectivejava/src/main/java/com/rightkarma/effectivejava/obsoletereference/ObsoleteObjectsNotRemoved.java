package com.rightkarma.effectivejava.obsoletereference;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * NOTE - here elements array is traversed based upon size.
 * After element is popped, its reference still remains in the stack
 * Simple fix is to put this line to remove the reference.
 *
 * elements[size]=null;
 */

public class ObsoleteObjectsNotRemoved {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public ObsoleteObjectsNotRemoved() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();

        // remove the object before returning.
        // that way, array will not hold reference and free up the memory
        Object element = elements[size];
        elements[size]=null;
        return element;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
