package Labs.Lab_01;

public class TestHugeInteger {

    public static void main (String args[]){
        HugeInteger h = new HugeInteger("12345678901234B56789012567890");
        HugeInteger h2 = new HugeInteger("129323912939239123912932399");
        HugeInteger h4 = new HugeInteger(8);
        HugeInteger h5 = new HugeInteger(8);
        HugeInteger h6 = new HugeInteger("123456789012345678901234567890");

        System.out.println("h: "+h.toString());
        System.out.println("h2: "+h2.toString());
        System.out.println("h4: "+h4.toString());
        System.out.println("h5: "+h5.toString());

        HugeInteger h3 = h.add(h2);
        System.out.println("Sum: "+h3.toString());
      //  System.out.println(h.compareTo(h2));
       // System.out.println(h4.compareTo(h5));
    }
}