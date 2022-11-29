package day.day13;

public class LeakyBucket {

    long timestamp = System.currentTimeMillis();

    // 总容量
    long capacity;

    // 剩余容量
    long water;

    // 速率
    int rate;

    public boolean grant() {
        long currentTimestamp = System.currentTimeMillis();
        water = water - Math.max(0, rate * (currentTimestamp - this.timestamp));

        this.timestamp = currentTimestamp;
        if (water + 1 > capacity) {
            return false;
        } else {
            water = water + 1;
            return true;
        }
    }
}
