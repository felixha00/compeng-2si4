package Labs.Lab_01;

public class TestHugeInteger {

    public static void main (String args[]){
        
        
        HugeInteger x1;
        HugeInteger x2;
        HugeInteger x3;
        HugeInteger x4;

       
        // String constructor test cases
        // Valid inputs
        long m0 = Runtime.getRuntime().freeMemory();
        String s = new String("Alexandru Tanasescu");
        long m1 = Runtime.getRuntime().freeMemory();
        System.out.println(m0 - m1);
    
        try{
            x1 = new HugeInteger("12345678");
            System.out.println(x1.toString());
            x1 = new HugeInteger("7097209430973667806014363363584489148645");
            System.out.println(x1.toString());
            x1 = new HugeInteger("-7097209430973667806014363363584489148645");
            System.out.println(x1.toString());
            x1 = new HugeInteger("0000007097209430973667806014363363584489148645");
            System.out.println(x1.toString());
            x1 = new HugeInteger("-0");
            System.out.println(x1.toString());
        }
        catch(Exception e){
            System.out.println("String constructor throws exception for valid input\n");
        }
        //Invalid Inputs
        try{
            x1 = new HugeInteger("7097209430973667806-014363363584489148645");
        }
        catch(Exception e){
            System.out.println("S1: String in the middle exception caught\n");
        }
        try{
            x1 = new HugeInteger("7097209430973667806014363363584489148645!");
        }
        catch(Exception e){
            System.out.println("S2: String at the end exception caught\n");
        }
        try{
            x1 = new HugeInteger(",7097209430973667806014363363584489148645");
        }
        catch(Exception e){
            System.out.println("S3: String in the beginning exception caught\n");
        }
        try{
            x1 = new HugeInteger("000-7097209430973667806014363363584489148645");
        }
        catch(Exception e){
            System.out.println("S4: String with leading zeros exception caught\n");
        }
        try{
            x1 = new HugeInteger("-,7097209430973667806014363363584489148645");
        }
        catch(Exception e){
            System.out.println("S5: Negative String with exception caught\n");
        }
        try{
            x1 = new HugeInteger("");
        }
        catch(Exception e){
            System.out.println("S6: Empty String exception caught\n");
        }

        //Random Constructor Test cases

        try{
            x1 = new HugeInteger(10);
            x1 = new HugeInteger(100);
        }
        catch(Exception e){
            System.out.println("Random constructor throws exception for valid input");
        }

        try{
            x1 = new HugeInteger(0);
        }
        catch(Exception e){
            System.out.println("R1: Size zero exception caught\n");
        }
        try{
            x1 = new HugeInteger(-12);
        }
        catch(Exception e){
            System.out.println("R2: Negative size exception caught\n");
        }


        //Addition Test Cases
    
        try{
            x2 = new HugeInteger("999");
            x1 = new HugeInteger("99");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            
            x2 = new HugeInteger("9811943522878929789833327008017571604735");
            x1 = new HugeInteger("27224374369720602368");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x2 = new HugeInteger("70289496792964864710");
            x1 = new HugeInteger("4153692393666040698634991664372669429691");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x2 = new HugeInteger("99999999999999999999999999");
            x1 = new HugeInteger("99999999999999999999999999");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x2 = new HugeInteger("99999999999999999999999999");
            x1 = new HugeInteger("11");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();

        }
        catch(Exception e){
            System.out.println("Exception generated by the class for valid test cases");
            System.out.println("Invalid input for HugeInteger");
            System.out.println("Required: String equivalent of integer");
        }

        
        //Addition with negative numbers
        System.out.println("Addition");
        try{
            x1 = new HugeInteger("-41227118523886958320663418902059206980124172710684");
            x2 = new HugeInteger("-61909791269961487612522934635131397205598718168957");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("-68851396737734913351388212636496036858104587877124");
            x2 = new HugeInteger("41227118523886958320663418902059206");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("688513104587877124");
            x2 = new HugeInteger("-76245861525986285249450820492919113334865206726001");
            x3 = x1.add(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
        }
        catch(Exception e){
            System.out.println("Error during addition");
        }
        System.out.println("Subtraction");
        try{
            x1 = new HugeInteger("-412271185238869583206634189084");
            x2 = new HugeInteger("-6190979126996148761252293435131397205598718168957");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("-7851396737734913351388212636496036858104587877124");
            x2 = new HugeInteger("19851227118523886958320663418902059206");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("688513104587877124");
            x2 = new HugeInteger("-76245861525986285249450820492919113334865206726001");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("688513104587877123467459628736598324");
            x2 = new HugeInteger("762458615259862852494509113334865206726001");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
        }
        catch(Exception e){
            System.out.println("Error during subtraction");
        }
        System.out.println("Multiplication");
        
        try{
            x1 = new HugeInteger("-412271185238869583206634189084");
            x2 = new HugeInteger("-6190979126996148761252293435131397205598718168957");
            x3 = x1.multiply(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("-7851396737734913351388212636496036858104587877124");
            x2 = new HugeInteger("19851227118523886958320663418902059206");
            x3 = x1.multiply(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("688513104587877124");
            x2 = new HugeInteger("-76245861525986285249450820492919113334865206726001");
            x3 = x1.multiply(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("68851310458787712411111112321");
            x2 = new HugeInteger("762458615259862852494508204113334865206726001");
            x3 = x1.subtract(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
            System.out.println();
            System.out.println();
        }
        catch(Exception e){
            System.out.println("Error during multiplication");
        }
        
           

        System.out.println("Comparison");
        try{
            x1 = new HugeInteger("-999");
            x2 = new HugeInteger("-2999");
            int x = x1.compareTo(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x);
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("999");
            x2 = new HugeInteger("999");
            x = x1.compareTo(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x);
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("1000");
            x2 = new HugeInteger("999");
            x = x1.compareTo(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x);
            System.out.println();
            System.out.println();
            x1 = new HugeInteger("999");
            x2 = new HugeInteger("1000");
            x = x1.compareTo(x2);
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x);
            System.out.println();
            System.out.println();

        }
        catch(Exception e){
            System.out.println("Error during multiplication");
        }
        
        
        
        
        
        
        
        /*
        HugeInteger h = new HugeInteger("1234567");
        HugeInteger h2 = new HugeInteger("-1293239");
        HugeInteger h4 = new HugeInteger(8);
        HugeInteger h5 = new HugeInteger(8);
        HugeInteger h6 = new HugeInteger("123456789012345678901234567890");

        System.out.println("h: "+h.toString());
        System.out.println("h2: "+h2.toString());
        System.out.println("h4: "+h4.toString());


        HugeInteger h3 = h.add(h2);
        System.out.println("Sum: "+h3.toString());

        HugeInteger h7 = new HugeInteger("33333");
        HugeInteger h8 = new HugeInteger("33929");
        HugeInteger h9 = h7.subtract(h8);
        System.out.println("Difference: "+h9.toString());
      //  System.out.println(h.compareTo(h2));
       // System.out.println(h4.compareTo(h5));
    // -68851396737734872124269688749537716194685685817918
    // -68851396737734972124269688749537716194685685817918
       */
      
    }
}