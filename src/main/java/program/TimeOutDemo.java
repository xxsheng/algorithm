package program;

public class TimeOutDemo {

    public synchronized Object get(long mills) throws InterruptedException {

        Object o = new Object();

        long future = System.currentTimeMillis() + mills;
        long remaining = mills;
        while (o == null && future - System.currentTimeMillis() > 0) {
            // 可能存在notify
            wait(remaining);
            remaining = future - System.currentTimeMillis();
        }

        return o;
    }
}
