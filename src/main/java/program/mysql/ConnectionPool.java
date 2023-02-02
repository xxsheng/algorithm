package program.mysql;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {

    private int poolSize;

    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool() {
        this.poolSize = 20;
        initPool();
    }

    public ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        initPool();
    }

    public synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.addLast(connection);
            notifyAll();
        }
    }

    public synchronized Connection fetchConnection(long mills) throws InterruptedException {

        if (mills <= 0) {
            while (pool.isEmpty()) {
                wait();
            }
            return pool.removeFirst();
        } else {
            long remaining = mills;
            long future = System.currentTimeMillis() + mills;
            while (pool.isEmpty() && remaining > 0) {
                wait(remaining);
                remaining = future - System.currentTimeMillis();
            }
            if (pool.isEmpty()) {
                return null;
            } else {
                return pool.removeFirst();
            }
        }
    }

    private void initPool() {
        for (int i = 0; i < poolSize; i++) {
            pool.add(ConnectionDriver.getConnection());
        }
    }

    public static class ConnectionDriver {

        public static Connection getConnection() {
            return ((Connection)
                    Proxy.newProxyInstance(
                            ConnectionDriver.class.getClassLoader(),
                            new Class[] {Connection.class},
                            new InvocationHandler() {
                                @Override
                                public Object invoke(Object proxy, Method method, Object[] args)
                                        throws Throwable {
                                    if (method.getName().equals("commit")) {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                    }

                                    return null;
                                }
                            }));
        }
    }
}
