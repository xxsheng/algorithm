package day.day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPackage {

    public static void main(String[] args) {
        RedPackage redPackage = new RedPackage();
        List<Integer> result = redPackage.divideRedPackage(1000, 10);

        System.out.println(result);
    }

    private List<Integer> divideRedPackage(int amount, int person) {
        List<Integer> result = new ArrayList<>();

        Random random = new Random();
        int remainingPerson = person;
        for (int i = 1; i <= person - 1; i++) {
            int data = random.nextInt(amount / remainingPerson * 2 - 1) + 1;
            result.add(data);
            amount = amount - data;
            remainingPerson = remainingPerson - 1;
        }
        result.add(amount);
        return result;
    }
}
