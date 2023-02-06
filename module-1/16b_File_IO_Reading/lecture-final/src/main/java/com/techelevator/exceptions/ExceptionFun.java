package com.techelevator.exceptions;

import java.util.UnknownFormatFlagsException;
import java.util.regex.PatternSyntaxException;

public class ExceptionFun {

    public static void main(String[] args) {

        ExceptionFun ef = new ExceptionFun();
        int x = 0;
        try {
            x = ef.parse("hello");
        } catch (NumberFormatException nfe) {
            throw new PatternSyntaxException("desc", "regex",0);
        } catch (IllegalArgumentException ae) {
            x = -1;
        }
        finally {
            // the finally will always be executed. always!
            System.out.println("the number was: " + x);
        }
//        catch(Exception e) { // don't do this
//            // do something
//        }
        System.out.println("done");

    }

    public int parse(String s) {
        int x = 0;
        x = Integer.parseInt(s);
        return x;
    }

}
