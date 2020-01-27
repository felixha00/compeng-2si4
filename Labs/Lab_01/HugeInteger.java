package Labs.Lab_01;

import java.lang.StringBuilder;
import java.util.Random;

public class HugeInteger {
    private String value = "";
    private boolean signed; // negative or positive

    public HugeInteger(String val) {
        if (val == "") { // empty string
            val = "0";
        }

        int start;
        if (val.charAt(0) == '-') {
            start = 1;
        } else {
            start = 0;
        }

        for (int i = start; i < val.length(); i++) {
            int c = Character.getNumericValue(val.charAt(i));
            if (c == -1 || c >= 10) {

                throw new IllegalArgumentException("Non-integer HugeInteger (Either a character or decimal found)");
            }

        }

        if (val.charAt(0) == '-') {
            this.signed = true;
            this.value = val.substring(1, val.length());

        } else {
            this.signed = false;
            this.value = val;
        }

    }

    public HugeInteger(int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randDigit = rand.nextInt(10);
            if (randDigit == 0 && i == 0) {
                randDigit++;
            } // checks for first digit to be 0, if so, add 1
            this.value = this.value + Integer.toString(randDigit);

        }

        int sign = rand.nextInt(2);
        if (sign == 1) {
            this.signed = false; // positive number
        } else {
            this.signed = true; // negative number
        }

    }

    public HugeInteger add(HugeInteger h) {

        String addVal = "";
        String reverse = "";

        int digitSum = 0; // sum of digit
        int carry = 0; // carry for next int

        if (this.signed == true && h.signed == true) { // -n + -m

        }

        if (h.isBiggerThan(this) == true) { // check if h or this is bigger

            int diffLen = h.value.length() - this.value.length();

            for (int i = h.value.length() - 1; i >= 0; i--) { // starts from least significant decimal
                digitSum = 0;

                if (i >= diffLen) {
                    digitSum += Character.getNumericValue(this.value.charAt(i - diffLen));
                } // checks when the length

                digitSum += Character.getNumericValue(h.value.charAt(i)) + carry; // adds the values

                if (digitSum >= 10) {
                    carry = 1;
                    digitSum %= 10;
                } else {
                    carry = 0;
                }

                addVal += Integer.toString(digitSum); // concatenates value to the end of the string

                if (carry == 1 && i == 0) { // adds 1 to the end for carrying
                    addVal += "1";
                }
            }

        }

        else {
            int diffLen = this.value.length() - h.value.length();

            for (int i = this.value.length() - 1; i >= 0; i--) { // starts from least significant decimal
                digitSum = 0;

                if (i >= diffLen) {
                    digitSum += Character.getNumericValue(h.value.charAt(i - diffLen));
                } // checks when the length

                digitSum += Character.getNumericValue(this.value.charAt(i)) + carry; // adds the values

                if (digitSum >= 10) {
                    carry = 1;
                    digitSum %= 10;
                } else {
                    carry = 0;
                }

                addVal += Integer.toString(digitSum); // concatenates value to the end of the string

                if (carry == 1 && i == 0) { // adds 1 to the end for carrying
                    addVal += "1";
                }
            }
        }

        for (int j = addVal.length() - 1; j >= 0; j--) {

            reverse += addVal.charAt(j);
        }
        HugeInteger addHugeInteger = new HugeInteger(reverse);

        return addHugeInteger;
    }

    public HugeInteger subtract(HugeInteger h) {
        HugeInteger sub = new HugeInteger("");

        StringBuilder sb = new StringBuilder();
        
        int digitDiff = 0;
        int borrow = 0;
        int carry = 0;
        String addVal = "";
        int diffLen = Math.abs(this.value.length() - h.value.length()); // absolute value of differential length

        if (this.signed == false) { // n
            if (h.signed == true) { // -m (n--m)
                sub = this.add(h);
                return sub;
            } else { // (n-m) ()

                if (this.compareTo(h) == 1) { // case where this (n) is greater than h (m)
                    
                    for (int i = h.value.length() - 1; i >= 0; i--) { // starts from least significant decimal
                        borrow = 0;
                        carry = 0;
                        digitDiff = 0;
                        if (i >= diffLen) {
                            if (Character.getNumericValue(this.value.charAt(i)) < Character.getNumericValue(h.value.charAt(i - diffLen)) ){
                                borrow = 1; 
                                carry = 10;
                            }
                            digitDiff = Character.getNumericValue(this.value.charAt(i)) - Character.getNumericValue(h.value.charAt(i - diffLen)) - borrow + carry; // h is the smaller number (length or otherwise)
                        } // checks when the length
                        else {
                            digitDiff = Character.getNumericValue(this.value.charAt(i));
                        }
                        

                        // adds the values

                        addVal += Integer.toString(digitDiff); // concatenates value to the end of the string
                        
                    }
                    sub.value = addVal;
                        return sub;
                }

                else {

                }

            }

        } else { // -n
            if (h.signed == false) { // -n - m
                sub = this.add(h);
                sub.invertSign();
                return sub;
            } else { // -n --m

            }
        }

        return null;

    }

    public HugeInteger multiply(HugeInteger h) { // utilizes the Karatsuba algorithm

        int hSize = h.value.length();
        int thisSize = this.value.length();
        int carry = 0;
        int sum;
        int digitProd = 0;

        if (this.isBiggerThan(h) == true) {
            for (int i = 0; i < h.value.length(); i++) {
                for (int j = 0; j < this.value.length(); i++) {
                    digitProd = (Character.getNumericValue(this.value.charAt(i))
                            * Character.getNumericValue(this.value.charAt(j))) + carry;

                    if (digitProd >= 10) {
                        carry = 1;
                        digitProd %= 10;
                    } else {
                        carry = 0;
                    }
                }
            }
        }

        HugeInteger prod = new HugeInteger(3);

        // CONDITIONS FOR SIGN WHEN MULTIPLYING
        if (this.signed == true && h.signed == true) {
            prod.signed = false;
        } else if ((this.signed == false && h.signed == true) || (this.signed == true && h.signed == false)) {
            prod.signed = true;
        } else {
            prod.signed = false;
        }

        return null;
    }

    public int compareTo(HugeInteger h) {
        if (this.signed == true) { // check if negative
            if (h.signed == true) { // checks if h is also negative
                if (this.value.length() > h.value.length()) { // checks only LENGTH
                    return -1;
                } else if (this.value.length() == h.value.length()) {
                    for (int i = 1; i < this.value.length(); i++) {
                        if (Character.getNumericValue(this.value.charAt(i)) > Character
                                .getNumericValue(h.value.charAt(i))) {
                            return -1;
                        } else if (Character.getNumericValue(this.value.charAt(i)) < Character
                                .getNumericValue(h.value.charAt(i))) {
                            return 1;
                        }
                    }
                    return 0;
                } else {
                    return 1;
                }
            }

            else {
                return -1;
            } // returns -1 because a negative number will always be smaller

        }

        if (this.value.length() > h.value.length()) { // checks only LENGTH
            return 1;
        }

        else if (this.value.length() == h.value.length()) {
            for (int i = 0; i < this.value.length(); i++) {
                if (Character.getNumericValue(this.value.charAt(i)) > Character.getNumericValue(h.value.charAt(i))) {
                    return 1;
                } else if (Character.getNumericValue(this.value.charAt(i)) < Character
                        .getNumericValue(h.value.charAt(i))) {
                    return -1;
                }
            }
            return 0;
        } else {
            return -1;
        }

    }

    public String toString() {
        int count = 0;
        for (int i = 0; i < this.value.length(); i++) {
            if (this.value.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }

        if (this.signed == true) {
            return "-" + this.value.substring(count, this.value.length());
        } else {
            return this.value.substring(count, this.value.length());
        }

    }

    public boolean isBiggerThan(HugeInteger h) {
        if (this.value.length() >= h.value.length()) {
            return true;
        } else {
            return false;
        }
    }

    public void invertSign() {
        if (this.signed == true) {
            this.signed = false;
        } else {
            this.signed = true;
        }

    }

}