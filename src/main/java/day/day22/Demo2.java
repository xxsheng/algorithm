package day.day22;

public class Demo2 {

    public static void main(String[] args) {
        int person = 10;
        int[] gold = new int[] {500, 400, 350, 300, 200};
        int[] goldPerson = {5, 5, 3, 4, 3};
        Demo2 demo2 = new Demo2();
        System.out.println(demo2.getBestGoldMining(person, gold, goldPerson));
    }

    private int getBestGoldMining(int person, int[] gold, int[] goldPerson) {

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
