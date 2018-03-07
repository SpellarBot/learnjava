package com.rightkarma.learnjava.snippets.iq;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveCharFromStringTest {

    RemoveCharFromString r = new RemoveCharFromString();
    String word = "We are now in the final stages";

    @Test
    public void removeRecursive() {
        String expectedWord="We re now in the finl stges";
        String output = r.removeRecursive(word, 'a');
        assertEquals(expectedWord, output);
    }

    @Test
    public void removeIterative() {
        String expectedWord="We re now in the finl stges";
        String output = r.removeIterative(word, 'a');
        assertEquals(expectedWord, output);
    }
}