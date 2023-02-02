package day.day26;

public class MaxGcd {

    public static void main(String[] args) {
        MaxGcd maxGcd = new MaxGcd();
        System.out.println(maxGcd.getMaxGcd(25, 5));
        //        System.out.println(maxGcd.getMaxGcd(27, 14));
    }

    public int getMaxGcd(int num1, int num2) {
        if (num1 == num2) return num1;
        if ((num1 & 1) == 0 && (num2 & 1) == 0) {
            return getMaxGcd(num1 >> 1, num2 >> 1) << 1;
        } else if ((num1 & 1) != 0 && (num2 & 1) == 0) {
            return getMaxGcd(num1, num2 >> 1);
        } else if ((num1 & 1) == 0 && (num2 & 1) != 0) {
            return getMaxGcd(num1 >> 1, num2);
        } else {

            return num1 > num2 ? getMaxGcd(num2, num1 - num2) : getMaxGcd(num1, num2 - num1);
        }
    }
}
