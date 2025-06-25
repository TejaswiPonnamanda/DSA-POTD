package multithreading;
/*using 2 threads
 1A 2B 3C 4D 5E 6F 7G 8H
 */

//Brute force : by implementing Runnable interface

public class PrintAlternateLetterAndNumberSequence {
    protected static class LetterTask implements Runnable
    {

        @Override
        public void run() {
            for(char ch='A';ch<='Z';ch++)
            {
                System.out.print(" "+ch);
                try
                {
                    Thread.sleep(2000);
                }
                catch(InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    protected static class NumberTask implements Runnable
    {

        @Override
        public void run() {
            for(int i=1;i<=26;i++)
            {
                System.out.print(" "+i);
                try
                {
                    Thread.sleep(2000);
                }
                catch(InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {

        Runnable letterTask=new LetterTask();
        Runnable numberTask=new NumberTask();
        Thread letterThread=new Thread(letterTask);
        Thread numberThread=new Thread(numberTask);

        letterThread.start();
        numberThread.start();

        letterThread.join();
        numberThread.join();
        //why join? to make main thread to wait until letterThread, numberTread finishes




    }
}
