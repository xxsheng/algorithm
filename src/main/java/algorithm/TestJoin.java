package algorithm;

import java.util.ArrayList;
import java.util.List;

public class TestJoin {
    public static void main(String[] args) throws Exception{
        Thread mainThread = Thread.currentThread();
        List<String> abc = new ArrayList<>();
        abc.add("1");
        abc.add("2");

        abc.stream().parallel().forEach(s -> {
            System.out.println(s);
            System.out.println("current thread" + Thread.currentThread().getState());
            System.out.println("main thread" + mainThread.getState());
            try {
                Thread.sleep(500000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        System.out.println("main thread");
    }
}
