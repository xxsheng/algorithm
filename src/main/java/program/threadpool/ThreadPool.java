package program.threadpool;

public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutDown();

    void addWorker(int num);

    void removeWorker(int num);

    int getJobSize();
}
