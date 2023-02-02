package day.day26;

public class Demo3 {

    public int getMaxDistance(int[] array) {
        int bucketNum = array.length;
        int min = array[0];
        int max = array[0];

        // 求出最大最小值
        for (int num : array) {
            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        // 初始化桶
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - min) / (max - min) * (bucketNum - 1);
            Bucket bucket = buckets[index];
            if (bucket.min == null || bucket.min > array[i]) {
                bucket.min = array[i];
            }
            if (bucket.max == null || bucket.max < array[i]) {
                bucket.max = array[i];
            }
        }

        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }

        return maxDistance;
    }

    public static class Bucket {
        Integer min;
        Integer max;

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }
    }
}
