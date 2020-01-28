package Labs.Lab_01;

public class TestHugeInteger {

    public static void main (String args[]){
        HugeInteger h = new HugeInteger("1234567890123456789012567890");
        HugeInteger h2 = new HugeInteger("129323912939239123912932399");
        HugeInteger h4 = new HugeInteger(8);
        HugeInteger h5 = new HugeInteger(8);
        HugeInteger h6 = new HugeInteger("123456789012345678901234567890");

        System.out.println("h: "+h.toString());
        System.out.println("h2: "+h2.toString());
        System.out.println("h4: "+h4.toString());


        HugeInteger h3 = h.add(h2);
        System.out.println("Sum: "+h3.toString());

        HugeInteger h7 = new HugeInteger("33333");
        HugeInteger h8 = new HugeInteger("3929");
        HugeInteger h9 = h7.subtract(h8);
        System.out.println("Difference: "+h9.toString());
      //  System.out.println(h.compareTo(h2));
       // System.out.println(h4.compareTo(h5));
    }
}