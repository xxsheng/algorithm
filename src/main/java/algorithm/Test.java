package algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;
public class Test {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        Thread thread1 = new Thread(new Task(null, 1));
        Thread thread2 = new Thread(new Task(thread1, 2));
        Thread thread3 = new Thread(new Task(thread2, 3));
        Thread thread4 = new Thread(new Task(thread3, 4));
        Thread thread5 = new Thread(new Task(thread4, 5));
        Thread thread6 = new Thread(new Task(thread5, 6));
        Thread thread7 = new Thread(new Task(thread6, 7));
        Thread thread8 = new Thread(new Task(thread7, 8));
        Thread thread9 = new Thread(new Task(thread8, 9));
        Thread thread10 = new Thread(new Task(thread9, 10));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();


    }

}

class Task implements Runnable {

    private Thread thread;

    private Integer i;

    public Task(Thread thread, int i) {
        this.thread = thread;
        this.i = i;
    }

    @Override
    public void run() {
        if (i == 2 || i == 5) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            if (i!=1) {

            thread.join();

            }
        } catch (Exception e) {


        }
        System.out.println("---这是第" + i + "线程");
    }
}