package day.day28;

public class BestGoldDemo {

    public static void main(String[] args) {
        int person = 10;
        int[] gold = new int[] {500, 400, 350, 300, 200};
        int[] goldPerson = {5, 5, 3, 4, 3};
        BestGoldDemo bestGoldDemo = new BestGoldDemo();
        //        System.out.println(bestGoldDemo.getBestGolding(gold, goldPerson, person,
        // gold.length));
        //        System.out.println(bestGoldDemo.bestGoldingV2(gold, goldPerson, person));
        System.out.println(bestGoldDemo.getBestGoldingV2(gold, goldPerson, person));
        //        System.out.println(bestGoldDemo.getBestGoldingV3(gold, goldPerson, person));
    }

    /**
     * @param gold
     * @param goldPerson
     * @param person
     * @param goldNum 表示几个金矿
     * @return
     */
    public int getBestGolding(int[] gold, int[] goldPerson, int person, int goldNum) {
        if (goldNum == 0 || person == 0) {
            return 0;
        }

        if (person < goldPerson[goldNum - 1]) {
            return getBestGolding(gold, goldPerson, person, goldNum - 1);
        }

        return Math.max(
                getBestGolding(gold, goldPerson, person, goldNum - 1),
                getBestGolding(gold, goldPerson, person - goldPerson[goldNum - 1], goldNum - 1)
                        + gold[goldNum - 1]);
    }

    public int bestGoldingV2(int[] gold, int[] goldPerson, int person) {
        int[][] resultTable = new int[gold.length + 1][person + 1];

        for (int i = 1; i <= gold.length; i++) {
            for (int j = 1; j <= person; j++) {
                if (j < goldPerson[i - 1]) {
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    resultTable[i][j] =
                            Math.max(
                                    resultTable[i - 1][j],
                                    gold[i - 1] + resultTable[i - 1][j - goldPerson[i - 1]]);
                }
            }
        }
        return resultTable[gold.length][person];
    }

    public int getBestGoldingV2(int[] gold, int[] goldPerson, int person) {
        int[][] resultTable = new int[gold.length][person];
        for (int i = 0; i < person; i++) {
            if (i < goldPerson[0]) {
                resultTable[0][i] = 0;
            } else {
                resultTable[0][i] = gold[0];
            }
        }

        for (int i = 1; i < gold.length; i++) {
            for (int j = 0; j < person; j++) {
                if (j + 1 < goldPerson[i - 1]) {
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    resultTable[i][j] =
                            Math.max(
                                    resultTable[i - 1][j],
                                    gold[i] + resultTable[i - 1][j + 1 - goldPerson[i - 1]]);
                }
            }
        }
        return resultTable[gold.length - 1][person - 1];
    }

    public int getBestGoldingV3(int[] gold, int[] goldPerson, int person) {
        int[][] resultTable = new int[gold.length + 1][person + 1];
        for (int i = 1; i <= gold.length; i++) {
            for (int j = 1; j <= person; j++) {
                if (j < goldPerson[i - 1]) {
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    resultTable[i][j] =
                            Math.max(
                                    resultTable[i - 1][j],
                                    resultTable[i - 1][j - goldPerson[i - 1]] + gold[i - 1]);
                }
            }
        }

        return resultTable[gold.length][person];
    }
}
