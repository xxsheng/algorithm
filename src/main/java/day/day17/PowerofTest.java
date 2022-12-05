package day.day17;

/** 确定一个数字是否是2的幂次方 */
public class PowerofTest {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println("数字：" + i + "；是否是2的幂次方" + new PowerofTest().isPowerOf2V2(i));
        }
    }

    public boolean isPowerOf2(int number) {
        if ((number % 2) != 0) return false;
        int result = number / 2;
        if (result == 1) {
            return true;
        } else {
            return isPowerOf2(result);
        }
    }

    public boolean isPowerOf2V2(int number) {
        return (number & (number - 1)) == 0;
    }
}
