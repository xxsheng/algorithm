package day.day26;

public class PowerOf2 {

    public boolean isPowerOf2(int num) {
        return ((num - 1) & num) == 0;
    }
}
