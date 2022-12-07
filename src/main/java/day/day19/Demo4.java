package day.day19;

// 求最短路径
public class Demo4 {

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(demo4.minPathSum(array));
    }

    private int minPathSum(int[][] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int rows = array.length, columns = array[0].length;
        int[][] dp = new int[rows][columns];
        // 先求出行数的搜索路径
        dp[0][0] = array[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + array[i][0];
        }

        for (int i = 1; i < columns; i++) {
            dp[0][i] = dp[0][i - 1] + array[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + array[i][j];
            }
        }

        return dp[rows - 1][columns - 1];
    }
}
