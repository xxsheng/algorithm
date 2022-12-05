package day.day17;

public class ArrayMaxDistance {

    public static void main(String[] args) {
        ArrayMaxDistance arrayMaxDistance = new ArrayMaxDistance();
        int[] array = new int[] {3, 6, 7, 8, 9, 10, 15, 43, 65, 34};
        System.out.println(arrayMaxDistance.getMaxDistance(array));
    }

    private int getMaxDistance(int[] array) {
        int bucketNum = array.length;

        int min = array[0];
        int max = array[1];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int num : array) {
            int index = (num - min) * (bucketNum - 1) / (max - min);
            Bucket bucket = buckets[index];
            if (bucket.max == null || bucket.max < num) {
                bucket.max = num;
            }

            if (bucket.min == null || bucket.min > num) {
                bucket.min = num;
            }
        }

        int maxDistance = 0;
        int leftMax = buckets[0].max;

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

    private static class Bucket {
        Integer max;
        Integer min;

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }
    }
}
