package day.day22;

public class Demo4 {

    private long[] words;

    private int size;

    public Demo4(int size) {
        this.size = size;
        this.words = new long[getWordIndex(size - 1) + 1];
    }

    public boolean getBit(int bitIndex) {
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    public void setBit(int bitIndex) {
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    private int getWordIndex(int bitIndex) {

        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4(128);
        //        demo4.setBit(126);
        //        demo4.setBit(75);
        demo4.setBit(2);
        //        System.out.println(demo4.getBit(126));
        //        System.out.println(demo4.getBit(75));
        //        System.out.println(demo4.getBit(76));
        //        System.out.println(demo4.getBit(78));
        demo4.setBit(3);
        System.out.println(demo4.getBit(2));
        System.out.println(demo4.getBit(3));
        //        System.out.println(4 | 6);
    }
}
