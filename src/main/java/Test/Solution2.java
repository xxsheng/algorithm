package Test;

import java.util.*;

/**
 * A:3,a:2,b:5,c:2@a:1,b:2,A:3
 * d:1,a:3,b:5,c:2@a:1,b:2
 * 如上所示，@左边为全量字符，A表示字符，3表示字符个数，@右边表示已经使用的字符个数，求剩余字符可使用数，以下为条件
 * 1、区分大小写 输出格式与输入格式保持一致，顺序保持一致
 * 2、当字符个数为0时，不需要显示
 * 3、还有个条件忘了，没看懂是什么意思。
 */
public class Solution2 {
    static List<String> charStrings = new ArrayList<>();
    static  Map<String, Integer> stringTotimes = new HashMap<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str == null || str.length()==0) {
            System.out.println(str);
            return;
        }
        String[] split = str.split("@");
        if (split.length ==1) {
            System.out.println(str);
        } else {
            String allChar = split[0];
            String usedChar = split[1];
            String[] chars = allChar.split(",");
            String[] usedChars = usedChar.split(",");
            parseString(chars, true);
            parseString(usedChars, false);

            StringBuilder stringBuilder = new StringBuilder();
            for (String charString : charStrings) {
                if (charString != null) {
                    Integer integer = stringTotimes.get(charString);
                    stringBuilder.append(charString).append(":").append(integer).append(",").append("\r\n");
                }
            }
            String result = stringBuilder.toString().trim();

            System.out.println(result.substring(0, result.length()-1));
        }


    }

    static void parseString(String[] chars, boolean flag) {
        for (String aChar : chars) {
            String[] split1 = aChar.split(":");
            String charString = split1[0];
            int times = Integer.parseInt(split1[1]);
            if (flag) {
                charStrings.add(charString);
                stringTotimes.put(charString, times);
            } else {
                Integer integer = stringTotimes.get(charString);
                if (integer != null) {
                    if ((integer - times) != 0) {

                        stringTotimes.put(charString, integer - times);
                    } else {
                        charStrings.remove(charString);
                    }
                }
            }
        }
    }
}
