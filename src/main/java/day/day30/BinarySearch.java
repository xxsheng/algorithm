package day.day30;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = binarySearch(array, 1);
        System.out.println(result);
    }

    private static int binarySearch(int[] array, int data) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int temp = array[mid];
            if (temp > data) {
                right = mid;
            } else if (temp < data) {
                right = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
