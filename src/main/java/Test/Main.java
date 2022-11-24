package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有100个人，编号从1到100，从1开始数数，数到M的那个人退出游戏，当剩余人数少于M时，游戏结束，求剩余的人的编号为多少
 * （经测试要求为顺序）
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(test(n));
    }

    public static String test(int n) {
        int size = 100;
        TestLisNode testLisNode = new TestLisNode(0, null);
        TestLisNode head = testLisNode;
        if (n<=1 || n>= 100) {
            return "ERROR!";
        } else {
            for (int i = 1; i <= 100; i++) {
                head.setNext(new TestLisNode(i, null));
                head = head.next;
            }
            head.next = testLisNode.next;
            // 链表
            head = testLisNode.next;
            TestLisNode prev = null;
            for (int i =1; i<=n; i++) {

                if(i==n && size >= n && head!=null ) {
                    TestLisNode next = head.next;
                    prev.next = next;
                    size--;
                    i=0;
                    head = prev.next;
//                    head = head.next;
                } else {
                    if (i==n-1) {
                        prev = head;
                    }
                    head = head.next;
                }

                if (size <n) {
                    break;
                }
            }
            TestLisNode temp = head;
            StringBuilder stringBuilder = new StringBuilder();

            int [] result = new int[size];
            int index=0;
            while (head.next != null) {
                result[index] = head.value;
                index++;
                head = head.next;
                if(head == temp) {
                    break;
                }
            }
            Arrays.sort(result);
            for (int i = 0; i < result.length; i++) {
                stringBuilder.append(result[i]).append(",");
            }

            String s = stringBuilder.toString();
            s = s.substring(0, s.length()-1);
            return s;
        }


    }



}

class TestLisNode {
    int value;
    TestLisNode next;

    public TestLisNode(int value, TestLisNode next) {
        this.value = value;
        this.next = next;
    }

    public TestLisNode setNext(TestLisNode next) {
        this.next = next;
        return this;
    }
}
