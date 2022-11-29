package day.day13;

public class Counter {

    long timestamp = System.currentTimeMillis();

    long count;

    long time = 60 * 1000;

    long maxRequest = 100;

    public boolean limit() {
        long timestamp = System.currentTimeMillis();
        if (timestamp + time > this.timestamp) {
            this.timestamp = timestamp;
            count = 1;
            return true;
        } else {
            count = count + 1;
            return maxRequest >= count + 1;
        }
    }
}
