package Labs.Lab_01;

public class TestHugeInteger {

    public static void main (String args[]){
        HugeInteger h = new HugeInteger(8);
        HugeInteger h2 = new HugeInteger(23);
        HugeInteger h4 = new HugeInteger("-99");
        HugeInteger h5 = new HugeInteger("-99");

        System.out.println(h.toString());
        System.out.println(h2.toString());

        HugeInteger h3 = h.add(h2);
        System.out.println("Sum of h + h2 = "+h3.toString());
        System.out.println(h.compareTo(h2));
        System.out.println(h4.compareTo(h5));
    }
}