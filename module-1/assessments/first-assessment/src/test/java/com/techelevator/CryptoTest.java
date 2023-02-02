package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CryptoTest {

    Crypto crypto;

    @Before
    public void setup() {
        crypto = new Crypto();
    }

    @Test
    public void Step1_1_hello_encrypts_correctly() {
        Assert.assertEquals("HELLO not encrypted correctly", "RAOOU", crypto.encrypt("HELLO"));
    }

    @Test
    public void Step1_2_alphabet_encrypts_correctly() {
        Assert.assertEquals("Alphabet not encrypted correctly", "NJFQAPSRXGDOTEUHMVBCWKZILY", crypto.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void Step2_1_alphabet_decrypts_correctly() {
        Assert.assertEquals("Alphabet not decrypted correctly", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", crypto.decrypt("NJFQAPSRXGDOTEUHMVBCWKZILY"));
    }

    @Test
    public void Step2_2_hello_world_encrypts_correctly() {
        Assert.assertEquals("Hello, World! not decrypted correctly", "HELLOWORLD", crypto.decrypt("RAOOUZUVOQ"));
    }

    @Test
    public void Step3_1_hello_world_encrypts_correctly() {
        Assert.assertEquals("Hello, World! not encrypted correctly", "RAOOU, ZUVOQ!", crypto.encrypt("HELLO, WORLD!"));
    }

    @Test
    public void Step3_2_no_letters_encrypts_correctly() {
        Assert.assertEquals("String with no letters encrypted correctly", "!@#$%^&*()_+", crypto.encrypt("!@#$%^&*()_+"));
    }
}
