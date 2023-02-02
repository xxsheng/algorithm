package day.day20;

public class NumberPlus {

    public static void main(String[] args) {
        NumberPlus numberPlus = new NumberPlus();
        System.out.println(numberPlus.numberPlus("426709752318", "95481253129"));
    }

    String numberPlus(String num1, String num2) {
        int length = num1.length() > num2.length() ? num1.length() : num2.length();
        int[] numArray1 = new int[length + 1];
        int[] numArray2 = new int[length + 1];

        int index = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            numArray1[index++] = num1.charAt(i) - '0';
        }

        index = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            numArray2[index++] = num2.charAt(i) - '0';
        }

        int[] result = new int[length + 1];

        for (int i = 0; i < result.length; i++) {
            int data1 = numArray1[i];
            int data2 = numArray2[i];
            int data = data1 + data2 + result[i];
            if (data >= 10) {
                int data3 = data - 10;
                result[i + 1] = 1;
                result[i] = data3;
            } else {
                result[i] = data;
            }
        }

        boolean findNum = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (!findNum) {
                if (result[i] == 0) {
                    continue;
                }
                findNum = true;
            }
            stringBuilder.append(result[i]);
        }

        return stringBuilder.toString();
    }
}
