package day.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
    public static void main(String[] args) {
        double[] aray = new double[] {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        BucketSort bucketSort = new BucketSort();
        System.out.println(Arrays.toString(bucketSort.bucketSort(aray)));
    }

    double[] bucketSort(double[] array) {
        double max = array[0];
        double min = array[0];

        for (double number : array) {
            if (number > max) {
                max = number;
            }

            if (number < min) {
                min = number;
            }
        }

        int bucketNum = array.length;

        ArrayList<LinkedList<Double>> linkedLists = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            LinkedList<Double> doubles = new LinkedList<>();
            linkedLists.add(doubles);
        }

        for (double v : array) {
            int index = (int) ((v - min) / (max - min) * (bucketNum - 1));
            linkedLists.get(index).add(v);
        }

        for (LinkedList<Double> linkedList : linkedLists) {
            Collections.sort(linkedList);
        }

        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> linkedList : linkedLists) {
            for (Double num : linkedList) {
                sortedArray[index++] = num;
            }
        }

        return sortedArray;
    }
}
