package com.antlrengine.util;

/**
 *
 * @author qplc
 */
public class Util {

    public Util() {

    }

    public int add(int a, int b, int c) {
        int output = a + b + c;
        System.out.println("Addition of [" + a + "+" + b + "+" + c + "] is: " + output);
        return output;
    }

    public int factorial(int number) {
        int i, fact = 1;
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + number + " is: " + fact);
        return fact;
    }

    public boolean isPalindrom(String str) {
        char[] word = new char[str.length()];
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                System.out.println("The word \"" + str + "\" is not a palindrom.");
                return false;
            }
            ++i1;
            --i2;
        }
        System.out.println("The word \"" + str + "\" is a palindrom.");
        return true;
    }
}
