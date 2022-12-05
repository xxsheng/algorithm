package day.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {
        double[] array = new double[] {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        BucketSort bucketSort = new BucketSort();
        System.out.println(Arrays.toString(bucketSort.bucketSort(array)));
    }

    private double[] bucketSort(double[] array) {
        int bucketNum = array.length;
        double min = array[0];
        double max = array[0];

        for (double number : array) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        List<LinkedList<Double>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            LinkedList<Double> linkedList = new LinkedList<>();
            buckets.add(linkedList);
        }

        for (double number : array) {
            int index = (int) ((number - min) * (bucketNum - 1) / (max - min));
            buckets.get(index).add(number);
        }

        for (LinkedList<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        double[] doubles = new double[array.length];
        int index = 0;
        for (LinkedList<Double> bucket : buckets) {
            for (Double number : bucket) {
                doubles[index++] = number;
            }
        }
        return doubles;
    }
}
