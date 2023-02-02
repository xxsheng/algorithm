package program.mysql;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadSize = 10;
        end = new CountDownLatch(threadSize);

        int exeCount = 20;
        AtomicInteger got = new AtomicInteger(0);
        AtomicInteger notGot = new AtomicInteger(0);
        for (int i = 0; i < threadSize; i++) {
            new Thread(new ConnectionRunner(exeCount, got, notGot), "ConnectionRunnerThread")
                    .start();
        }

        start.countDown();
        end.await();
    }

    public static class ConnectionRunner implements Runnable {

        private int count;
        private AtomicInteger got;
        private AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
                while (count > 0) {
                    try {
                        Connection connection = pool.fetchConnection(1000);
                        if (connection == null) {
                            notGot.incrementAndGet();
                        } else {
                            try {

                                connection.createStatement();
                                connection.commit();
                            } catch (Exception e) {

                            } finally {
                                got.incrementAndGet();
                                pool.releaseConnection(connection);
                            }
                        }
                    } catch (Exception e) {

                    } finally {

                        count--;
                    }
                }
                end.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
