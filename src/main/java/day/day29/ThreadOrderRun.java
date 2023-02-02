package day.day29;

import java.util.concurrent.CountDownLatch;

public class ThreadOrderRun {

    public static void main(String[] args) {
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        CountDownLatch countDownLatch3 = new CountDownLatch(1);
        new Thread(
                        () -> {
                            try {
                                countDownLatch3.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("线程3");
                        })
                .start();

        new Thread(
                        () -> {
                            try {
                                countDownLatch2.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("线程2");
                            countDownLatch3.countDown();
                        })
                .start();
        new Thread(
                        () -> {
                            try {
                                countDownLatch1.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("线程1");
                            countDownLatch2.countDown();
                        })
                .start();

        countDownLatch1.countDown();
    }
}
