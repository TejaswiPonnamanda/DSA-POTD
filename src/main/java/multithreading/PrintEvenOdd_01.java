package multithreading;

public class PrintEvenOdd_01 {
    static int i=0;
    protected static class EvenTask implements  Runnable
    {

        @Override
        public void run() {
            while(i<10)
            {
                System.out.println("even thread "+ i);

                i++;
            }

        }
    }

    protected static class OddTask implements  Runnable
    {

        @Override
        public void run() {
            while(i<10)
            {
                System.out.println("odd thread "+ i);

                i++;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new EvenTask() );
        t1.start();


        Thread t2=new Thread(new OddTask() );
        t2.start();
    }



}
