import java.util.concurrent.CountDownLatch;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            System.out.println("a is start");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("a is end");
            latch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("b is start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b is end");
            latch.countDown();
        }).start();
        System.out.println("wait ...");
        latch.await();
        System.out.println("all is finish");
    }
}
