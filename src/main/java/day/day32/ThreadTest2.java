package day.day32;

import java.util.concurrent.CountDownLatch;

public class ThreadTest2 {

    static int i = 1;

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(
                        () -> {
                            try {
                                countDownLatch.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            while (i <= 100) {
                                synchronized (ThreadTest2.class) {
                                    ThreadTest2.class.notify();
                                    System.out.println("线程1：" + i++);
                                    if (i == 100) {
                                        break;
                                    }
                                    try {
                                        ThreadTest2.class.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            System.out.println("线程1结束");
                        })
                .start();

        new Thread(
                        () -> {
                            while (i <= 100) {
                                synchronized (ThreadTest2.class) {
                                    ThreadTest2.class.notify();
                                    System.out.println("线程2：" + i++);
                                    if (i > 100) {
                                        break;
                                    }
                                    countDownLatch.countDown();
                                    try {
                                        ThreadTest2.class.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            System.out.println("线程2结束");
                        })
                .start();
    }
}
