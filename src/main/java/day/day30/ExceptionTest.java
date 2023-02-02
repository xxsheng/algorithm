package day.day30;

public class ExceptionTest {

    class A extends Exception {}

    class B extends A {}

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        B b = exceptionTest.new B();
        try {
            try {
                throw b;
            } catch (A e) {
                System.out.println("caught exception");
                throw e;
            }
        } catch (B e) {
            System.out.println("caught b");
            return;
        }
    }
}
