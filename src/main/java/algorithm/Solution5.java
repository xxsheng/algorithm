package algorithm;

public class Solution5 {
    public static void main(String[] args) {
        String str = "babad";
        String s = find(str);

        System.out.println(s);
    }

    static String find(String str) {
        String result = str.substring(0, 1);
        if (str.length() == 1) {
            result = str;
        } else {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int prev=i-1,next=i+1;
//                int temp = next;
//                if(next == str.length()) {
//                    next = str.length()-1;
//                } else {
////                    next = temp;
//                }
                for(; prev>=0 && next<=str.length();) {

                    if(next != str.length() &&(str.charAt(prev) == str.charAt(next))){
//                        next = temp;
                        prev--;
                        next++;
//                        break;
                    } else {

                        if(c == str.charAt(prev) && c == str.charAt(prev+1) && (next != str.length() && c != str.charAt(next))){
//                        next = i;
                            prev--;
//                            break;
                        } else
                        if((next != str.length() && (c == str.charAt(next) && c== str.charAt(next-1) && c != str.charAt(prev)))) {
//                        prev = i;
                            prev++;
                            next ++;
//                            break;
                        }
                        if (c != str.charAt(prev) && c==str.charAt(next == str.length() ? str.length()-1 : next)) {
                            prev++;
                            break;
                        }
                        if(c== str.charAt(prev) && c!=str.charAt(next == str.length() ? str.length()-1 : next)) {
                            if (next != str.length()-1) {
                                next--;
                            }
                            break;
                        }
                        if (c!=str.charAt(prev) && c!=str.charAt(next == str.length() ? str.length()-1 : next)) {
                            prev++;
                            next--;
                            break;
                        }


                    }
                    if(prev<0) {
                        prev=0;
//                        next--;
                        break;
                    }
                }
                if (prev<0) prev=0;

                int length = (next-1 ) - (prev ) + 1;

                    if (result.length() < length) {
                        if (next == str.length()) {
                            result = str.substring(prev);
                        } else {
                            result = str.substring(prev,next);
                        }

                    }


            }
        }


        return result;
    }
}
