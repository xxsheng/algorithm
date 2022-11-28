package day.day11;

import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(2.0);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        final long[] prev = {System.nanoTime()};
        for (int i = 0; i < 20; i++) {
            // 限流器限流
            rateLimiter.acquire();
            executorService.execute(
                    () -> {
                        long time = System.nanoTime();
                        System.out.println((time - prev[0]) / 1000_000);
                        prev[0] = time;
                    });
        }
    }
}
