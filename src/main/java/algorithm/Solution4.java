package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    public static void main(String[] args) {
        String s = "abba";
//        if (s.length() == 0) return 0;
//        if (s.length()==0) return 0;
        Integer length= 0;
        char temp = s.charAt(0);
        int strLength = s.length();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strLength; i++) {
            char test = s.charAt(i);
            Integer integer = map.get(test);
            if (integer != null) {
                left = Math.max(left, integer + 1);
//                length =  Math.max((i-1 - map.get(temp) +1), length);
//                i = integer+1;
//                map.put(s.charAt(i), i);
//                temp = s.charAt(i);
            }
            map.put(test, i);
            length = Math.max(i-left + 1,length );
        }


//        System.out.println(max);
//        return length;
    }
}
