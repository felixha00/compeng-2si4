package Labs.Lab_01;

import java.util.Random;

public class HugeInteger {
    private String value = "";
    private boolean signed; // negative or positive 
    
    public HugeInteger(String val) {

        if (val.charAt(0) == '-'){
            this.signed = true;
            this.value = val.substring(1, val.length());
        }
        else {
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
            this.signed = false;
        }

        
    }

    public HugeInteger add(HugeInteger h) {
        
        String addVal = "";
        String reverse = "";
      

        int digitSum = 0; // sum of digit
        int carry = 0; // carry for next int


        if (h.isBiggerThan(this) == true) { // check if h or this is bigger

            int diffLen = h.value.length() - this.value.length();
            
            for (int i = h.value.length() - 1; i >= 0; i--) { // starts from least significant decimal
                    digitSum = 0; 
                    
                   if (i >= diffLen) {digitSum += Character.getNumericValue(this.value.charAt(i-diffLen));} // checks when the length 

                    digitSum += Character.getNumericValue(h.value.charAt(i))+ carry; // adds the values

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
                    
                   if (i >= diffLen) {digitSum += Character.getNumericValue(h.value.charAt(i-diffLen));} // checks when the length 

                    digitSum += Character.getNumericValue(this.value.charAt(i))+ carry; // adds the values

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
        if (this.value.charAt(0) == '-') { // check if negative
            if (h.value.charAt(0) == '-') { // checks if h is also negative
                if (this.value.length() > h.value.length()) { // checks only LENGTH 
                    return -1;
                } 
                
                else if (this.value.length() == h.value.length()){
                    for (int i = 1; i < this.value.length(); i++){
                        if (Character.getNumericValue(this.value.charAt(i)) > Character.getNumericValue(h.value.charAt(i))){
                            return -1;
                        }
                        else if (Character.getNumericValue(this.value.charAt(i)) < Character.getNumericValue(h.value.charAt(i))){
                            return 1;
                        }
                    }
                    return 0;
                }
                else {
                    return 1; 
                }
            }


            else {return -1;} // returns -1 because a negative number will always be smaller

        }

        if (this.value.length() > h.value.length()) { // checks only LENGTH 
            return 1;
        } 

        else if (this.value.length() == h.value.length()){
            for (int i = 0; i < this.value.length(); i++){
                if (Character.getNumericValue(this.value.charAt(i)) > Character.getNumericValue(h.value.charAt(i))){
                    return 1;
                }
                else if (Character.getNumericValue(this.value.charAt(i)) < Character.getNumericValue(h.value.charAt(i))){
                    return -1;
                }
            }
            return 0;
        }
        else {
            return -1; 
        }

        }
    

    public String toString() {

        return this.value;

    }

    public boolean isBiggerThan(HugeInteger h) {
        if (this.value.charAt(0) == '-') { // check if negative
            if (h.value.charAt(0) != '-') {
            }
        }

        if (this.value.length() >= h.value.length()) {
            return true;
        } else {
            return false;
        }
    }

}