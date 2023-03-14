import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CyclicBarrier barrier = new CyclicBarrier(11);
        for (int i = 0; i < 10; i++) {
            Task task = new Task(count, barrier, countDownLatch);
            task.start();
        }

        barrier.await();
        System.out.println(count.get());
//        countDownLatch.await();
//        System.out.println(count.get());
//        barrier.reset();

    }

    static class Task extends Thread {
        AtomicInteger count;
        CyclicBarrier barrier;
        CountDownLatch countDownLatch;

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                count.addAndGet(1);
            }
            // countDownLatch.countDown();
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            // System.out.println(count.get());
        }

        public Task(AtomicInteger count, CyclicBarrier barrier, CountDownLatch countDownLatch) {
            this.count = count;
            this.barrier = barrier;
            this.countDownLatch = countDownLatch;
        }
    }
}
