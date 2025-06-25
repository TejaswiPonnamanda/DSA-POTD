package multithreading;

public class PrintOddNumbersInSeqUsing2Threads {


    private static final Object lock = new Object();
    private static int number = 1;//start
    private static final int MAX = 20;//end

    static class PrintUsingTwoThreads implements Runnable {

        @Override
        public void run() {
            while (number <= MAX) {
                synchronized (lock) {
                    if (number % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " prints odd:" + number);
                        number += 2;
                        lock.notify();


                    }
//                        System.out.println(Thread.currentThread().getName() + " print even:" + number);
//                        number += 1;


                        try {
                            if (number <= MAX) {
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                }

            }
        }

        public static void main(String[] args) throws InterruptedException {
            Thread t1 = new Thread(new PrintUsingTwoThreads(), "Thread1");
            Thread t2 = new Thread(new PrintUsingTwoThreads(), "Thread2");
            t1.start();
            t2.start();

            t1.join();
            t2.join();

        }


    }
}
