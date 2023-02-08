package program.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    private static final int MAX_POOL_SIZE = 10;

    private static final int DEFAULT_POOL_SIZE = 5;

    private static final int MIN_POOL_SIZE = 1;

    private final LinkedList<Job> jobs = new LinkedList<>();

    private List<Worker> workers = Collections.synchronizedList(new ArrayList<>());

    private AtomicInteger threadNum = new AtomicInteger();

    private int workedNUm = DEFAULT_POOL_SIZE;

    public DefaultThreadPool() {
        initWork(DEFAULT_POOL_SIZE);
    }

    public DefaultThreadPool(int num) {
        workedNUm = num > MAX_POOL_SIZE ? MAX_POOL_SIZE : num < MIN_POOL_SIZE ? MIN_POOL_SIZE : num;
        initWork(workedNUm);
    }

    private void initWork(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet()).start();
        }
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.addLast(job);
                notify();
            }
        }
    }

    @Override
    public void shutDown() {
        for (Worker worker : workers) {
            worker.shutDown();
        }
    }

    @Override
    public void addWorker(int num) {
        synchronized (jobs) {
            if (num + this.workedNUm > MAX_POOL_SIZE) {
                num = MAX_POOL_SIZE - this.workedNUm;
            }

            initWork(num);
            this.workedNUm += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num < 0) {
                throw new IllegalArgumentException("非法的参数");
            }
            if (num > this.workedNUm - MIN_POOL_SIZE) {
                num = this.workedNUm - MIN_POOL_SIZE;
            }
            int count = 0;
            while (count < num) {

                Worker remove = workers.remove(0);
                remove.shutDown();
                count++;
            }
            this.workedNUm -= count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    public class Worker implements Runnable {

        private boolean running = true;

        @Override
        public void run() {
            while (running) {
                synchronized (jobs) {
                    if (jobs.isEmpty()) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    } else {
                        Job job = jobs.removeFirst();
                        if (job != null) {

                            try {
                                job.run();
                            } catch (Exception e) {
                                // 忽略
                            }
                        }
                    }
                }
            }
        }

        public void shutDown() {
            this.running = false;
        }
    }
}
