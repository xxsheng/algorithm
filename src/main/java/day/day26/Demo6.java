package day.day26;

public class Demo6 {

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        System.out.println(demo6.kNum("1593212", 3));
    }

    public String kNum(String num, int k) {
        int length = num.length();
        int newLength = length - k;

        int[] nums = new int[length];

        int top = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int data = c - '0';
            while (top > 0 && k > 0 && nums[top - 1] > data) {
                k--;
                top--;
            }
            nums[top++] = data;
        }

        int offset = 0;
        while (offset < newLength && nums[offset] == 0) {
            offset++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = offset; i < newLength; i++) {

            stringBuilder.append(nums[i]);
        }

        return stringBuilder.toString();
    }
}
