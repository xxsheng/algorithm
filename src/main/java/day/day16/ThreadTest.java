package day.day16;

public class ThreadTest {

    public Object object = new Object();

    public void test1() throws InterruptedException {
        synchronized (object) {
            // do something;
            System.out.println("获取锁");
            object.wait();
            System.out.println("被通知醒了");
        }
    }

    public void test2() {
        synchronized (object) {
            System.out.println("获得锁2");
            object.notify();
            System.out.println("其他");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadTest threadTest = new ThreadTest();
        new Thread(
                        () -> {
                            try {
                                threadTest.test1();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        })
                .start();

        Thread.sleep(1000);
        new Thread(threadTest::test2).start();
    }
}
