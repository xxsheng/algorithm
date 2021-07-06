package algorithm;

public class String2Long {

    static {

    }
    public static void main(String[] args) {
        String test = "123";
        stringtoLong(test);
//        Long.parseLong(test);
        System.out.println(Double.parseDouble("9999"));
    }

    static void stringtoLong(String str) {
        int length = str.length();
        char[] ints = new char[length];
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                ints[i] = c;
            } else {
                throw new NumberFormatException();
            }
        }

        int number = 0;
        int radix = 1;
        for (int i = length-1; i >= 0; i--) {
            int i1 = (ints[i] - '0') * radix;
            number += i1;
            radix *= 10;
        }
        System.out.println(number);
    }
}
