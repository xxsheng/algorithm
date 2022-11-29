package day.day13;

import java.util.LinkedList;
import java.util.Random;

public class SlidingTimeWindow {
    final int limit = 100;
    Integer count = 0;
    LinkedList<Integer> linkedList = new LinkedList<>();
    int split = 10;
    boolean isLimit = false;

    public void doCheck() throws InterruptedException {
        while (true) {
            linkedList.addLast(count);
            if (linkedList.size() > split) {
                linkedList.removeFirst();
            }

            if ((linkedList.peekLast() - linkedList.peekFirst()) > limit) {
                isLimit = true;
                //                count = 0;
            } else {
                isLimit = false;
            }

            Thread.sleep((1000 / 10));
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //        System.out.println(new Random().nextInt(15));
        SlidingTimeWindow slidingTimeWindow = new SlidingTimeWindow();

        new Thread(
                        () -> {
                            try {
                                slidingTimeWindow.doCheck();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        })
                .start();

        while (true) {
            if (!slidingTimeWindow.isLimit) {
                slidingTimeWindow.count++;
                Thread.sleep(new Random().nextInt(15));
                System.out.println("业务方法执行完毕");
            } else {
                System.out.println("被限流");
            }
        }
    }
}
