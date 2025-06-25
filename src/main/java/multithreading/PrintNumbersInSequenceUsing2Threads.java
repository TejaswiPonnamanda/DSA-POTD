package multithreading;

//package multithreading;
//✅ 1. Print numbers in sequence using 2 threads
//Example output (Thread1 and Thread2 alternate):
//
//1 2 3 4 5 6 7 8 9 10
public class PrintNumbersInSequenceUsing2Threads {

    private static final Object lock=new Object();
    private static int number=1;//start
    private static final int MAX=10;//end

    static class printUsingTwoThreads implements  Runnable
    {

        @Override
        public void run() {
            while(number<=MAX)
            {
                synchronized (lock)
                {
                    System.out.println(Thread.currentThread().getName()+" prints:"+number);
                    number++;
                    lock.notify();
                    try
                    {
                        if(number<=MAX)
                        {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new printUsingTwoThreads(),"Thread1" );
        Thread t2=new Thread(new printUsingTwoThreads(),"Thread2" );
        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}
