package com.rightkarma.learnjava.threads.threadsafety;

/**
 * Generates sequential unique IDs starting with 1, 2, 3, and so on.
 * <p>
 * This class is NOT thread-safe.
 * </p>
 */
public class BrokenUniqueIdGenerator {
    private long counter = 0;
 
    public long nextId() throws InterruptedException {
    	Thread.sleep(5);
        return ++counter;
    }
}