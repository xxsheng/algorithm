package day.day31;

import java.util.concurrent.TimeUnit;

public class TokenBucket {

    private long next = System.nanoTime();

    private long interval = 100_000_000;

    public long doAcquire(long time) {
        if (time > next) {
            next = time;
        }

        long at = next;

        next = next + interval;
        return Math.max(at, 0);
    }

    public void acquire() throws InterruptedException {
        long now = System.nanoTime();
        long tokenTime = doAcquire(now);
        long max = Math.max(tokenTime - now, 0);

        TimeUnit.NANOSECONDS.sleep(max);
    }
}
