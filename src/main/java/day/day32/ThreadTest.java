package day.day32;

public class ThreadTest {

    public static int i = 1;
    static final Object o = new Object();

    public static void main(String[] args) {
        new Thread(
                        () -> {
                            while (i < 100) {
                                synchronized (o) {
                                    if (i % 2 != 0) {
                                        System.out.println("线程1，打印的值" + i);
                                        i++;
                                    }
                                }
                            }
                            System.out.println("线程1结束");
                        })
                .start();

        new Thread(
                        () -> {
                            while (i <= 100) {
                                synchronized (ThreadTest.class) {
                                    if (i % 2 == 0) {
                                        System.out.println("线程2，打印的值" + i);
                                        i++;
                                    }
                                }
                            }
                            System.out.println("线程2结束");
                        })
                .start();

        //        new Thread(
        //                        () -> {
        //                            while (i <= 100) {
        //                                synchronized (o) {
        //                                    System.out.println("线程3，打印的值" + i);
        //                                    i++;
        //                                }
        //                            }
        //                            System.out.println("线程3结束");
        //                        })
        //                .start();
    }
}
