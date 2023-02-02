package day.day21;

public class Demo2 {

    public static void main(String[] args) {
        int person = 10;
        int[] gold = new int[] {500, 400, 350, 300, 200};
        int[] goldPerson = {5, 5, 3, 4, 3};

        System.out.println(Demo2.maxGold(person, gold.length, gold, goldPerson));
    }

    public static int maxGold(int person, int length, int[] gold, int[] goldPerson) {

        if (person == 0 || length == 0) {
            return 0;
        }

        if (person < goldPerson[length - 1]) {
            return maxGold(person, length - 1, gold, goldPerson);
        }

        return Math.max(
                maxGold(person, length - 1, gold, goldPerson),
                maxGold(person - goldPerson[length - 1], length - 1, gold, goldPerson)
                        + gold[length - 1]);
    }
}
