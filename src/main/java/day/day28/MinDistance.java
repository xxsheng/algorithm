package day.day28;

public class MinDistance {

    public static void main(String[] args) {
        int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int num = getMinDistance(array);
        System.out.println(num);
    }

    private static int getMinDistance(int[][] array) {

        int rows = array.length;
        int columns = array[0].length;

        for (int i = 1; i < columns; i++) {
            array[0][i] = array[0][i] + array[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            array[i][0] = array[i][0] + array[i - 1][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                array[i][j] =
                        Math.min(array[i - 1][j] + array[i][j], array[i][j - 1] + array[i][j]);
            }
        }

        return array[rows - 1][columns - 1];
    }
}
