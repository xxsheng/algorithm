package day.day31;

import java.util.concurrent.TimeUnit;

public class TokenBucket2 {

    int capacity;

    int tokens;

    long next = System.nanoTime();

    long interval = 100_000_000;

    public void reSync(long time) {
        if (time > next) {
            long tokens = (time - next) / interval;
            tokens = Math.min(capacity, tokens + this.tokens);
            next = time;
        }
    }

    public long doAcquire(long time) {
        reSync(time);
        long at = next;
        int min = Math.min(1, tokens);
        if (min < 0) {
            next = next + interval;
        }
        this.tokens = tokens - min;

        return at;
    }

    public void acquire() throws InterruptedException {
        long now = System.nanoTime();
        long tokenTime = doAcquire(now);
        long min = Math.min(0, tokenTime - now);
        if (min > 0) {
            TimeUnit.NANOSECONDS.sleep(min);
        }
    }
}
