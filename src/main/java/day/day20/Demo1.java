package day.day20;

public class Demo1 {

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        System.out.println(demo1.test1("1593212", 3));
    }

    private String test1(String num, int k) {
        int top = 0;
        int newLength = num.length() - k;

        char[] stack = new char[num.length()];

        for (int i = 0; i < num.length(); i++) {

            char data = num.charAt(i);

            while (k > 0 && top > 0 && stack[top - 1] > data) {
                top--;
                k--;
            }

            stack[top++] = data;
        }

        int offset = 0;
        for (int i = 0; i < newLength; i++) {

            if (stack[i] == '0') {
                offset++;
            } else {
                break;
            }
        }

        return new String(stack, offset, newLength);
    }
}
