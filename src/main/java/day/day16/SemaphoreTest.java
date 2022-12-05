package day.day16;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    static Semaphore semaphore1 = new Semaphore(1);
    static Semaphore semaphore2 = new Semaphore(1);

    public static void main(String[] args) {
        new Thread(
                        () -> {
                            try {
                                semaphore1.acquire();
                                System.out.println("获取锁1");
                                semaphore2.acquire();
                                System.out.println("获取锁2");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                semaphore2.release();
                                ;
                                semaphore1.release();
                            }
                        })
                .start();

        new Thread(
                        () -> {
                            try {
                                semaphore2.acquire();
                                System.out.println("获取锁2");

                                semaphore1.acquire();
                                System.out.println("获取锁1");

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                semaphore2.release();
                                semaphore1.release();
                            }
                        })
                .start();
    }
}
