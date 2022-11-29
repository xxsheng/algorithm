package day.day13;

import java.util.concurrent.TimeUnit;

public class TokenBucket2 {
    long capacity;

    long interval = 1000_000_000;

    long next = System.nanoTime();

    long tokens = 0;

    void resync(long now) {
        if (now > next) {
            tokens = Math.min(capacity, tokens + (now - next) / interval);
            next = now;
        }
    }

    long reserve(long now) {
        resync(now);

        long at = next;

        //
        long token = Math.min(1, tokens);

        long nr = 1 - token;

        next = next + nr * interval;

        this.tokens = tokens - token;
        return at;
    }

    void acquire() throws InterruptedException {
        long l = System.nanoTime();
        long reserve = reserve(l);
        if (reserve > l) {
            TimeUnit.NANOSECONDS.sleep(reserve - l);
        }
    }
}
