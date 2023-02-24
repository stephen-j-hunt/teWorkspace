package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignalProcessorTest {

    SignalProcessor processor;

    @Before
    public void setup() {
        processor = new SignalProcessor();
    }

    @Test
    public void AND_gate_works_correctly() {
        Assert.assertEquals("AND works correctly",
                "--______--______--______--______--______--",
                processor.processSignals("AND",
                        "----____----____----____----____----____--",
                        "--____----____----____----____----____----"));
    }

    @Test
    public void OR_gate_works_correctly() {
        Assert.assertEquals("OR works correctly",
                "----__--------------____------__-----_-_--",
                processor.processSignals("OR",
                        "----____----____----____----____----____--",
                        "---___---___------______------______-_-_-_"));
    }

    @Test
    public void XOR_gate_works_correctly() {
        Assert.assertEquals("XOR works correctly",
                "_-_--_-_____--__---_---_---_--__-__-_--_-_",
                processor.processSignals("XOR",
                        "----____----____----____----____----____--",
                        "-_-_-_-_------_____----____---___--__--__-"));
    }

    @Test
    public void NAND_gate_works_correctly() {
        Assert.assertEquals("NAND works correctly",
                "---_-_---_-_---_-_---_-_--",
                processor.processSignals("NAND",
                        "_-_-_-_-_-_-_-_-_-_-_-_-_-",
                        "___---___---___---___---__"));
    }

    @Test
    public void NOR_gate_works_correctly() {
        Assert.assertEquals("NOR works correctly",
                "___-_-____________-____-______---__-___-__",
                processor.processSignals("NOR",
                        "---___---___------______------______-_-_-_",
                        "-_-_-_-_------_____----____---___--__--__-"));
    }

    @Test
    public void NXOR_gate_works_correctly() {
        Assert.assertEquals("NXOR works correctly",
                "------------------------------------------",
                processor.processSignals("NXOR",
                        "---___---___------______------______-_-_-_",
                        "---___---___------______------______-_-_-_"));
    }

}