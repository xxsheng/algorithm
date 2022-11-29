package day.day13;

import java.util.concurrent.TimeUnit;

public class TokenBucket {
    long next = System.nanoTime();

    long interval = 1000_000_000;

    synchronized long reserve(long now) {

        if (now > next) {
            next = now;
        }

        long at = next;

        next = next + interval;
        return Math.max(at, 0);
    }

    void acquire() throws InterruptedException {
        long now = System.nanoTime();
        long reserve = reserve(now);
        long waitTime = Math.max(reserve - now, 0);
        if (waitTime > 0) {
            TimeUnit.NANOSECONDS.sleep(waitTime);
        }
    }
}
