package Labs.Lab_01;

import java.lang.StringBuilder;
import java.util.Random;

public class HugeInteger {
    private String value = "";
    private boolean signed; // negative or positive

    public HugeInteger(String val) {

        if (val == "" || val == "-0") { // empty string or -0
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

    public HugeInteger(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
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
        HugeInteger addHugeInteger = new HugeInteger("");

        int digitSum = 0; // sum of digit
        int carry = 0; // carry for next int

        ///////////////////////////////////////////
        if (this.signed == true) {
            if (h.signed == true) {
                addHugeInteger.signed = true;
            } // double negative
            else { // this is negative, h is positive
                HugeInteger this2 = new HugeInteger(this.value);
                this2.signed = false;
                addHugeInteger = h.subtract(this2);
                return addHugeInteger;
            }
        } else {
            if (h.signed == true) {
                HugeInteger h2 = new HugeInteger(h.value);
                h2.signed = false;
                addHugeInteger = this.subtract(h2);
                return addHugeInteger;
            } else {
                addHugeInteger.signed = false;
            }
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

        addHugeInteger.value = reverse;
        return addHugeInteger;
    }

    public HugeInteger subtract(HugeInteger h) {
        HugeInteger sub = new HugeInteger("");
        HugeInteger top = new HugeInteger("");
        HugeInteger bot = new HugeInteger("");

        StringBuilder diff = new StringBuilder("");
        int digitDiff = 0;
        int borrow = 0;
        int carry = 0;

        int diffLen = Math.abs(this.value.length() - h.value.length()); // absolute value of differential length

        if (this.compareTo(h) == 0) { // if both values are same return 0;
            sub.value = "0";
            sub.signed = false;
            return sub;
        }

        if (this.signed == false) { // n
            if (h.signed == true) { // -m (n--m)
                HugeInteger h2 = new HugeInteger(h.value);
                sub = this.add(h2);
                sub.signed = false;
                return sub;
            } else { // (n-m) ()
                     // ////////////////////////////////////////////////////////////////////////////////////
                     // ONLY POSITIVE N AND M GO HERE
                if (this.compareTo(h) == -1) { // inverts sign when the lower is greater than top
                    top.value = h.value;
                    bot.value = this.value;
                    sub.signed = true;
                } else {
                    top.value = this.value;
                    bot.value = h.value;
                }

                for (int i = top.value.length() - 1; i >= 0; i--) { // starts from least significant decimal

                    digitDiff = 0;
                    carry = 0;
                    if (i >= diffLen) {
                        if (Character.getNumericValue(top.value
                                .charAt(i)) < (Character.getNumericValue(bot.value.charAt(i - diffLen)) + borrow)) {
                            carry = 10;
                        }
                        digitDiff = Character.getNumericValue(top.value.charAt(i))
                                - Character.getNumericValue(bot.value.charAt(i - diffLen)) - borrow + carry;

                    } // checks when the length
                    else {
                        digitDiff = Character.getNumericValue(top.value.charAt(i));
                    }

                    if (carry == 10) {
                        borrow = 1;
                    } else {
                        borrow = 0;
                    }
                    // System.out.println(digitDiff);

                    diff.append(digitDiff);// // concatenates value to the end of the string
                    if (borrow == 1 && i == 0) { // checks for when overflow of borrow so deletes first char
                        diff.deleteCharAt(0);
                    }

                }

                sub.value = diff.reverse().toString();
                return sub;
            }

            ////////////////////////////////////////////////////////////////////////////////////
        } else { // -n
            if (h.signed == false) { // -n - m
                HugeInteger this2 = new HugeInteger(this.value);
                sub = this2.add(h);
                sub.signed = true;
                return sub;
            } else { // -n --m

                if (this.compareTo(h) == 1) { // inverts sign when the lower is smaller (reverse since both are
                                              // negative)
                    top.value = h.value;
                    bot.value = this.value;
                    sub.signed = false;
                } else {
                    top.value = this.value;
                    bot.value = h.value;
                    sub.signed = true;
                }

                for (int i = top.value.length() - 1; i >= 0; i--) { // starts from least significant decimal
                    digitDiff = 0;
                    carry = 0;
                    if (i >= diffLen) {
                        if (Character.getNumericValue(top.value.charAt(i)) < Character
                                .getNumericValue(bot.value.charAt(i - diffLen))) {
                            carry = 10;
                        }
                        digitDiff = Character.getNumericValue(top.value.charAt(i))
                                - Character.getNumericValue(bot.value.charAt(i - diffLen)) - borrow + carry;

                    } // checks when the string ends.
                    else {
                        digitDiff = Character.getNumericValue(top.value.charAt(i));
                    }

                    if (carry == 10) {
                        borrow = 1;
                    } else {
                        borrow = 0;
                    }
                    // adds the values
                    diff.append(digitDiff);// addVal += Integer.toString(digitDiff); // concatenates value to the end of
                                           // the string
                    if (borrow == 1 && i == 0) { // adds 1 to the end for carrying
                        diff.deleteCharAt(0);
                    }

                }

                sub.value = diff.reverse().toString();
                return sub;
            }
        }

    }

    public HugeInteger multiply(HugeInteger h) { // utilizes the Karatsuba algorithm
        if (this.value == "0" || h.value == "0") {
            HugeInteger sub = new HugeInteger("0");
            return sub;
        }

        int carry = 0;
        int digitProd = 0;
        HugeInteger prod = new HugeInteger("0");
        HugeInteger h2 = new HugeInteger("0");
        StringBuilder sb = new StringBuilder("");
        int zCount = 0;

        if (this.isBiggerThan(h) == true) {
            for (int i = h.value.length() - 1; i >= 0; i--) {
                for (int j = this.value.length() - 1; j >= 0; j--) {
                    digitProd = (Character.getNumericValue(h.value.charAt(i))
                            * Character.getNumericValue(this.value.charAt(j))) + carry;

                    if (digitProd >= 10) {
                        carry = digitProd / 10;
                        digitProd %= 10;
                        if (j != 0) {
                            sb.append(digitProd);
                        }
                        else { // append it reversed
                            sb.append(digitProd);
                            sb.append(carry);
                        }
                    } else {
                        carry = 0;
                        sb.append(digitProd);

                    }

                }

                h2 = new HugeInteger(sb.reverse().toString());
                // System.out.println("LINE: " + sb.toString());
                prod = prod.add(h2);
                sb = new StringBuilder("");
                zCount++;
                for (int k = 0; k < zCount; k++) { // adds zeroes based on the digit position.
                    sb.append("0");
                }
                carry = 0;

            }

        } else {
            for (int i = this.value.length() - 1; i >= 0; i--) {
                for (int j = h.value.length() - 1; j >= 0; j--) {
                    digitProd = (Character.getNumericValue(this.value.charAt(i))
                            * Character.getNumericValue(h.value.charAt(j))) + carry;

                    if (digitProd >= 10) {
                        carry = digitProd / 10;
                        digitProd %= 10;
                        if (j != 0) {

                            sb.append(digitProd); // each line for adding
                        }

                        else {
                            sb.append(digitProd);
                            sb.append(carry);
                        }
                    } else {
                        carry = 0;
                        sb.append(digitProd);

                    }

                }

                h2 = new HugeInteger(sb.reverse().toString());
                // System.out.println("LINE: " + sb.toString());
                prod = prod.add(h2);
                sb = new StringBuilder("");
                zCount++;
                for (int k = 0; k < zCount; k++) { // adds zeroes based on the digit position.
                    sb.append("0");
                }
                carry = 0;

            }

        }

        // CONDITIONS FOR SIGN WHEN MULTIPLYING
        if (this.signed == true && h.signed == true) {
            prod.signed = false;
        } else if ((this.signed == false && h.signed == true) || (this.signed == true && h.signed == false)) {
            prod.signed = true;
        } else {
            prod.signed = false;
        }

        return prod;
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

        } else {
            if (h.signed == true) {
                return 1;
            }
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
            if (this.value.charAt(i) == '0' && this.value != "0") {
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

}