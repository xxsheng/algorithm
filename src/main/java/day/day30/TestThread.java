package day.day30;

public class TestThread {

    public static void main(String[] args) {
        new Thread(
                        () -> {
                            while (true) {
                                System.out.println("子线程");
                            }
                        })
                .start();

        System.out.println("main线程");
    }
}
