package day.day30;

public class BubbleSort {
    public static void main(String[] args) {
        //        int[] array = {5, 4, 3, 2, 1, 6, 7, 8, 9, 10, 11};
        //        bubbleSort(array);
        //        System.out.println(Arrays.toString(array));
        testFor();
    }

    private static void testFor() {
        int index = 10;
        for (int i = 0; i <= (index + 1); i++) {
            System.out.println("test");
            index = index - 1;
        }
    }

    private static void bubbleSort(int[] array) {
        boolean sorted = true;
        int index = array.length - 1;
        int tempIndex = 0;
        for (int i = 0; i <= index + 1; i++) {
            for (int j = 0; j < index; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false;
                    tempIndex = j;
                }
            }

            index = tempIndex;
            if (sorted) {
                break;
            }
        }
    }
}
