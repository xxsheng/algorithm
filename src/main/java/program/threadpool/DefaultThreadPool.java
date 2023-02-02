package program.threadpool;

import java.util.LinkedList;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    private static final int MAX_POOL_SIZE = 10;

    private static final int DEFAULT_POOL_SIZE = 5;

    private static final int MIN_POOL_SIZE = 1;

    private final LinkedList<Job> jobs = new LinkedList<>();

    public DefaultThreadPool() {
        initWork(DEFAULT_POOL_SIZE);
    }

    private void initWork(int poolSize) {}

    @Override
    public void execute(Job job) {
        jobs.addLast(job);
    }

    @Override
    public void shutDown() {}

    @Override
    public void addWorker(int num) {}

    @Override
    public void removeWorker(int num) {}

    @Override
    public int getJobSize() {
        return 0;
    }
}
