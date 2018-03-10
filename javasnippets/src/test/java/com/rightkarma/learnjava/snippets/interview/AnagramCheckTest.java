package com.rightkarma.learnjava.snippets.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnagramCheckTest {

    private String word="hear";
    private String anagram="hare";
    private AnagramCheck anagramCheck;

    @Before
    public void setup(){
        anagramCheck=new AnagramCheck();
    }

    @Test
    public void isAnagramBasic() {
        assertTrue(anagramCheck.isAnagramBasic(word, anagram));
    }

    @Test
    public void checkAnagramStringBuilder() {
        assertTrue(anagramCheck.checkAnagramStringBuilder(word, anagram));
    }

    @Test
    public void isAnagramJustSort() {
        assertTrue(anagramCheck.isAnagramJustSort(word, anagram));
    }

}
