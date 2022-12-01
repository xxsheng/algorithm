package day.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<Future<Integer>> futureTasks = new ArrayList<>();

        List<Integer> integers = Arrays.asList(1, 2, 3);
        for (Integer integer : integers) {
            futureTasks.add(
                    executorService.submit(
                            () -> {
                                System.out.println(integer);
                                return integer;
                            }));
        }
        System.out.println("---");
        for (Future<Integer> futureTask : futureTasks) {
            System.out.println(futureTask.get());
        }
    }
}
