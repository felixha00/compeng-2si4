package Labs.Lab_01;

public class TestHugeInteger {

    public static void main (String args[]){
        HugeInteger h = new HugeInteger(8);
        HugeInteger h2 = new HugeInteger(4);

        System.out.println(h.toString());
        System.out.println(h2.toString());

        HugeInteger h3 = h.add(h2);
        System.out.println(h3.toString());
    }
}