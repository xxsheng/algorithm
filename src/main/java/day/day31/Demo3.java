package day.day31;

public class Demo3 {
    private static int i = 1;

    public static void main(String[] args) {

        Object object = new Object();

        new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                while (i <= 100) {
                                    synchronized (object) {
                                        object.notify();
                                        System.out.println(
                                                Thread.currentThread().getName() + "执行结果1：" + i++);
                                        try {
                                            object.wait();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        })
                .start();

        new Thread(
                        () -> {
                            while (i <= 100) {
                                synchronized (object) {
                                    System.out.println(
                                            Thread.currentThread().getName() + "执行结果2：" + i++);
                                    object.notify();
                                    try {
                                        object.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        })
                .start();
    }
}
