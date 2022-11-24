package Test;

import java.util.*;

public class Solution4 {

    static Map<String, Integer> temp = new HashMap<>();
    static List<String> temp1 = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = new ArrayList<>();

        data.add("3 1");
        data.add("1 2");
        data.add("1 3");
        data.add("2 3");

        String first = data.get(0);
        Integer times = Integer.parseInt(first.split(" ")[1]);


        for (int i = 1; i < data.size(); i++) {
            String s = data.get(i);
            String[] s1 = s.split(" ");
            int result = Integer.parseInt(s1[0]) + Integer.parseInt(s1[1]);
            temp.put(s1[0]+i, result);
            temp1.add(s1[0]+i);
        }

        int i=1;
        Integer integer = temp.get(temp.get(0));
        for (int i1 = 1; i1 < temp1.size(); i1++) {
            Integer times1 = temp.get(temp1.get(i1));
            if ((times1 + times) == times1) {
                i++;
            }

        }

        System.out.println(i);
    }
}
