package day.day17;

/** 最大公约数 */
public class GcdTest {

    public static void main(String[] args) {
        GcdTest gcdTest = new GcdTest();
        System.out.println(gcdTest.gcdTest(10, 25));
        System.out.println(gcdTest.gcdTestV2(100, 25));
        System.out.println(gcdTest.gcdTestV3(100, 80));
    }

    /**
     * 欧几里得算法（辗转相除法）
     *
     * @param number1
     * @param number2
     * @return
     */
    public int gcdTest(int number1, int number2) {
        int max = number1 > number2 ? number1 : number2;
        int min = number1 > number2 ? number2 : number1;

        int mod = max % min;
        if (mod == 0) {
            return min;
        } else {
            return gcdTest(min, mod);
        }
    }

    /**
     * 更相减损术
     *
     * @param number1
     * @param number2
     * @return
     */
    public int gcdTestV2(int number1, int number2) {
        int max = number1 > number2 ? number1 : number2;
        int min = number1 > number2 ? number2 : number1;
        int result = max - min;
        if (result == min) {
            return result;
        } else {
            return gcdTestV2(result, min);
        }
    }

    /**
     * 更相减损术-优化版
     *
     * @param number1
     * @param number2
     * @return
     */
    public int gcdTestV3(int number1, int number2) {

        if (number1 == number2) {
            return number1;
        }

        int max = number1 > number2 ? number1 : number2;
        int min = number1 > number2 ? number2 : number1;
        if ((max & 1) == 0 && (min & 1) == 0) {
            return gcdTestV3(max >> 1, min >> 1) << 1;
        } else if ((max & 1) == 0 && (min & 1) == 1) {
            return gcdTestV3(max >> 1, min);
        } else if ((max & 1) == 1 && (min & 1) == 0) {
            return gcdTestV3(max, min >> 1);
        } else {
            return gcdTestV3(min, max - min);
        }
    }
}
