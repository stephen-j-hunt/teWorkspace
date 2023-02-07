package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {
    public WordCount wordCount = new WordCount();
    public Map<String, Integer> expected;


    @Test
    public void single_appearance_word() {
        expected = new HashMap<>();
        expected.put("a", 1);
        Map<String, Integer> actual = wordCount.getCount(new String[]{"a"});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void multi_appearance_word() {
        expected = new HashMap<>();
        expected.put("hi", 3);

        Map<String, Integer> actual = wordCount.getCount(new String[]{"hi", "hi", "hi"});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void if_empty_string() {
        expected = new HashMap<>();
        expected.put("", 1);
        Map<String, Integer> actual = wordCount.getCount(new String[]{""});
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void if_string_null() {
        expected = new HashMap<>();
        Map<String, Integer> actual = wordCount.getCount(new String[]{});
        Assert.assertEquals(expected, actual);
    }

}




/*
1. words is null
2. words is []
3. single appearance word
4. multi appearance word
5. words contains an empty string
 */
