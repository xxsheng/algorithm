package day.day19;

/** 删除k个数后最小的数 */
public class Demo1 {

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        System.out.println(demo1.test("1593212", 3));
        System.out.println(demo1.test2("1593212", 3));
    }

    String test(String number, int k) {
        for (int i = 0; i < k; i++) {
            boolean hasCheck = false;
            for (int j = 0; j < number.length() - 1; j++) {
                if (number.charAt(j) > number.charAt(j + 1)) {
                    hasCheck = true;
                    // 重新组装数字
                    number = number.substring(0, j) + number.substring(j + 1);
                    break;
                }
            }

            if (!hasCheck) {
                number = number.substring(0, number.length() - 1);
            }

            number = removeZero(number);
        }
        return number;
    }

    private String removeZero(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                break;
            }
            number = number.substring(i + 1);
        }
        return number;
    }

    public String test2(String num, int k) {
        int newLength = num.length() - k;

        char[] chars = new char[num.length()];

        int top = 0;

        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && k > 0 && chars[top - 1] > c) {
                k = k - 1;
                top = top - 1;
            }

            chars[top++] = c;
        }

        int offset = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                offset++;
            } else {
                break;
            }
        }

        return newLength == 0 ? "0" : new String(chars, offset, newLength);
    }
}
