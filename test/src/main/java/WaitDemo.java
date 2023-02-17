public class WaitDemo {
    private static final Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
        final WaitDemo waitDemo = new WaitDemo();

        new Thread(() -> {
            try {
                //
                waitDemo.doNotify();
                waitDemo.doSleep();
                waitDemo.doWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(200);
        waitDemo.doNotify();
    }

    void doSleep() throws InterruptedException {
        synchronized (locker) {
            System.out.println("sleep start");
            Thread.sleep(1000);
            System.out.println("sleep end");
        }
    }
    void doWait() throws InterruptedException {
        synchronized (locker) {
            System.out.println("wait start");
            locker.wait();
            System.out.println("wait end");
        }
    }

    void doNotify() {
        synchronized (locker) {
            System.out.println("notify start");
            locker.notify();
            System.out.println("notify end");
        }
    }


}
