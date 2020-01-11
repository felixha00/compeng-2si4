package Labs.Lab_01;

public class TestHugeInteger {

    public static void main (String args[]){
        HugeInteger h = new HugeInteger(1);
        HugeInteger h2 = new HugeInteger(2);

        System.out.println(h.toString());
        System.out.println(h2.toString());

        HugeInteger h3 = h.add(h2);
        System.out.println(h3.toString());
    }
}