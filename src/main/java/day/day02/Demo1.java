package day.day02;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Demo1 {

    @Test
    public void test1() {
        Integer[] data = new Integer[] {1,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,11,12,7,8,9,11,11,12,2,11,4,4};

        Arrays.sort(data, Comparator.reverseOrder());
        int numberIndex = 0;
        int slow = 0;
        Integer elevenNumber  = null;
        for (int i = 1; i < data.length; i++) {

            if (data[slow].equals(data[i])) {
//                slow = i;
            } else {
                numberIndex = numberIndex + 1;
                if (numberIndex == 11) {
                    elevenNumber = data[slow];

                }
            }
            slow = i;

        }


    }
}
