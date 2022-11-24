package day.day01;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo1 {

    Integer[] data = new Integer[]{1, 2, 4, 6, 7, 5, 3, 2};

    @Test
    public void test1() {

        for (int i = 0; i < data.length; i++) {
            int currentData = data[i];
            for (int j = 0; j < i; j++) {
                Integer prev = data[j];
                if (currentData == prev) {
                    System.out.println("当前重复的数字为:" + currentData + "索引下标为：" + i + "和" + j);
                }
            }
        }
    }

    @Test
    public void test2() {

        for (int i = 0; i < data.length; i++) {
            Integer currentNumber = data[i];
            for (int j = 0; j < data.length; j++) {
                Integer number = data[j];
                if (currentNumber.intValue() == number.intValue() && i != j) {
                    System.out.println("当前重复数字为" + currentNumber);
                    System.out.println(i + "_" + j);
                }
            }
        }
    }

    @Test
    public void test3() {
        Map<Integer, Integer> dataMap = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            Integer integer = dataMap.get(data[i]);
            if (integer != null) {
                System.out.println("当前重复数字为：" + data[i] + "索引为：" + integer + "_" + i);
            } else {
                dataMap.put(data[i], i);
            }
        }
    }
}
