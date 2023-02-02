package day.day22;

public class Demo1 {

    public static void main(String[] args) {
        int person = 10;
        int[] gold = new int[] {500, 400, 350, 300, 200};
        int[] goldPerson = {5, 5, 3, 4, 3};

        Demo1 demo1 = new Demo1();
        System.out.println(demo1.getBestGoldMiningV2(person, goldPerson, gold));
        System.out.println(demo1.getBestGoldMiningV1(person, goldPerson, gold, 5));
    }

    public int getBestGoldMiningV1(int w, int[] p, int[] g, int path) {
        if (w == 0 || path == 0) {
            return 0;
        }

        if (w < p[path - 1]) {
            return getBestGoldMiningV1(w, p, g, path - 1);
        }

        return Math.max(
                getBestGoldMiningV1(w, p, g, path - 1),
                getBestGoldMiningV1(w - p[path - 1], p, g, path - 1) + g[path - 1]);
    }

    public int getBestGoldMiningV2(int w, int[] p, int[] g) {
        // 创建表格
        int[][] resultTable = new int[g.length + 1][w + 1];

        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {

                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    resultTable[i][j] =
                            Math.max(
                                    resultTable[i - 1][j],
                                    resultTable[i - 1][j - p[i - 1]] + g[i - 1]);
                }
            }
        }

        return resultTable[g.length][w];
    }
}
