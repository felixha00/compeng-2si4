package Labs.Lab_01;

import java.util.Random;

public class HugeInteger {
    private String value = "";

    public HugeInteger(String val) {
        this.value = val;
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
    }

    public HugeInteger add(HugeInteger h) {
        String addVal = "";
        String reverse = "";

        int digitSum = 0; // sum of digit
        int carry = 0; // carry for next int

        if (h.isBiggerThan(this) == true) {
            
            for (int i = h.value.length() - 1; i >= 0; i--) { // starts from least significant decimal
                digitSum = 0;
                try {
                    digitSum = Character.getNumericValue(this.value.charAt(i))
                            + Character.getNumericValue(h.value.charAt(i)) + carry; // adds the values
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("J");
                    digitSum = Character.getNumericValue(h.value.charAt(i)) + carry;
                } finally {
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
        }

        else {
            for (int i = this.value.length() - 1; i >= 0; i--) { // starts from least significant decimal
                digitSum = Character.getNumericValue(this.value.charAt(i))
                        + Character.getNumericValue(h.value.charAt(i)) + carry; // adds the values

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
        return null;
    }

    public HugeInteger multiply(HugeInteger h) {
        return null;
    }

    public int compareTo(HugeInteger h) {
        return 0;
    }

    public String toString() {

        return this.value;

    }

    public boolean isBiggerThan(HugeInteger h) {
        if (this.value.charAt(0) == '-') { // check if negative
            if (h.value.charAt(0) != '-') {
            }
        }

        if (this.value.length() > h.value.length()) {
            return true;
        } else {
            return false;
        }
    }

}
