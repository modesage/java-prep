package _18_StringBuffer;

import java.util.Arrays;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // constructor 1
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());

        // constructor 2
        StringBuffer sb2 = new StringBuffer("hello world");

        // constructor 3
        StringBuffer sb3 = new StringBuffer(30);
        System.out.println(sb3.capacity());

        sb.append("how");
        sb.append(" are u?");
        //based on the index
        sb.insert(9, " doing");

        sb.replace(8, 16, "they running so fast?");

        sb.delete(0, 8);

        sb.reverse();

        String str = sb.toString();
        System.out.println(str);

        int n = 20;
        String name = RandomString.generate(n);
        System.out.println("Random string: " + name);

        // remove whitespaces
        String sentence = "H    E   L   L   O";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s", ""));

        // split
        String arr = "BMW,Lamborghini,Ferrari,Porsche";
        String[] brands = arr.split(",");
        System.out.println(Arrays.toString(brands));

        // rounding off
        DecimalFormat df = new DecimalFormat("00.0000");
        System.out.println(df.format(7.29));
    }
}