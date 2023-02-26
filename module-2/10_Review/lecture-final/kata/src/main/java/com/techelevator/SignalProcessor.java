package com.techelevator;

class SignalProcessor {
    /*
    A logic gate is an electronic device implementing a boolean function, performing a logical
    operation on one or more binary inputs and producing a single binary output.

    All type of gates will always have two inputs and one output.
    All input signal data always have the same length.

    The type of gates are :
    AND : performs a logical AND operation.
    OR : performs a logical OR operation.
    XOR : performs a logical exclusive OR operation.
    NAND : performs a logical negated AND operation.
    NOR : performs a logical negated OR operation.
    NXOR : performs a logical negated exclusive OR operation.

    Signals are represented with underscore and minus characters, an underscore matching a low level (0, or false)
    and a minus matching a high level (1, or true).
    For example: --_-_  is equivalent to Boolean[]  { true, true, false, true, false };

     processSignals() Method receives a gate type and two input signals. It needs to process (combine) the inputs and produce
     a single output signal. The output signal is a result of applying a particular (gate) operation to both input signals

     For example:
     processing...
         Gate Operation: OR
                Input 1: ---_-
                Input 2: __-_-

     Should produce...
                 Output: ---_-

    Write the implementation of processSignals(...) method for all gate types listed above.
    Hint: NOR operation is the "not" (!) OR, XOR is the "not" XOR etc.

    We have provided unit tests that currently fail.
    Keep refining your implementation until they all pass ;)

    Bonus: Add handling for cases where signalProcessor is given invalid signals and/or operations

*/
    public String processSignals(String operation, String input1, String input2) {
        if (operation == null || operation.isEmpty()) {
            throw new IllegalArgumentException("operation required");
        }

        if (input1 == null || input2 == null || input1.isEmpty() || input2.isEmpty()) {
            throw new IllegalArgumentException("two signals are required");
        }

        if (input1.length() != input2.length()) {
            throw new IllegalArgumentException("both signals must be of the same length");
        }

        final String op = operation.toLowerCase();
        final StringBuilder sb = new StringBuilder();
        for(int i=0; i < input1.length(); i++) {
            final boolean op1 = decode(input1.charAt(i));
            final boolean op2 = decode(input2.charAt(i));
            boolean result = false;
            if (op.endsWith("and")) {
                result = op1 && op2;
            } else if (op.endsWith("xor")) {
                result = op1 ^ op2;
            } else if (op.endsWith("or")) {
                result = op1 || op2;
            }

            if (op.startsWith("n")) {
                result = !result;
            }

            sb.append(encode(result));
        }

        return sb.toString();
    }

    private boolean decode(char c) {
        if (c == '-') {
            return true;
        } else if (c == '_') {
            return false;
        } else {
            throw new IllegalArgumentException("invalid signal value: " + c);
        }
    }

    private char encode(boolean val) {
        return val ? '-' : '_';
    }
}
