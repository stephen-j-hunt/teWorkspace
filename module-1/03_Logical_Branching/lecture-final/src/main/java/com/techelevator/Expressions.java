package com.techelevator;

public class Expressions {
    public static void main(String[] args) {
        System.out.println(1 == 1);
        System.out.println(1 == 2);
        System.out.println(1 != 2);
        System.out.println(1 > 2);
        System.out.println(1 < 2);
        System.out.println(1 >= 2);
        System.out.println(1 <= 2);
        System.out.println(1 <= 1);

        int one = 1;
        int two = 2;
        System.out.println(one == two);

        // and &&
        System.out.println(true && true);
        System.out.println(true && false);

        // or ||
        System.out.println(true || true);
        System.out.println(false || true);
        System.out.println(false || false);

        // not !
        System.out.println(! true);
        System.out.println(! false);
        System.out.println(!!!true);

        // exclusive OR
        System.out.println(true ^ true);
        System.out.println(false ^ false);
        System.out.println(false ^ true);

        // rule: you can play outside if the temperature is above 32 and your homework is done
        //  or it's the weekend
        boolean isAbove32degrees = true;
        boolean isWeekend = false;
        boolean isHomeworkCompleted = false;

        // these two lines mean the same thing
        boolean canPlayOutside = isAbove32degrees == true && isHomeworkCompleted == true || isWeekend == true;

        boolean canPlayOutside2 = isAbove32degrees && (isHomeworkCompleted || isWeekend);

    }
}
