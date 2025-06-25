package multithreading;
/*
✅ What is a Race Condition?
A race condition happens when two or more threads access shared data at the same time, and the final result depends on the timing of how the threads are scheduled.

This leads to unexpected, inconsistent, or incorrect results because the threads are "racing" to update or read shared memory without coordination.
 */
/*
public class RaceExample {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                count++; // no synchronization, race condition here
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count: " + count); // ❌ Might NOT be 2000
    }
}

Output:
===========
Final Count: 1873   // or 1920 or 1999... not always 2000!

 */
/*
🔍 Why does this happen?
count++ is not atomic. It involves 3 steps:

Read value from memory

Increment value

Write updated value back

If two threads do this simultaneously, they can overwrite each other’s updates.

✅ How to fix a race condition?
You synchronize access to the shared resource.

🔸 Option 1: synchronized

synchronized (lock) {
    count++;
}
🔸 Option 2: AtomicInteger

AtomicInteger count = new AtomicInteger(0);
count.incrementAndGet();

 */

/*
Why Join?
✅ What is join() in Java threads?
The join() method allows one thread to wait for another thread to finish before continuing.

🔹 Real-life analogy:
Think of join() like saying:

"Hey, I’ll wait here until you (another thread) are done. Then I’ll continue."

🔸 Syntax:
thread.join();

✅ Simple Example:

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread-1: " + i);
            }
        });

        t1.start();

        t1.join();  // main thread waits for t1 to finish

        System.out.println("Main thread resumes after t1 finishes.");
    }
}

🟢 Output:

Thread-1: 1
Thread-1: 2
Thread-1: 3
Main thread resumes after t1 finishes.
Without join(), the main thread might print before t1 is done.

❓ Why use join()?
To ensure proper order of execution.

To avoid race conditions in some scenarios.

To wait for result from a thread.
=========================================================
✅ Use in your even-odd code (if needed):

Thread t1 = new Thread(new EvenTask());
Thread t2 = new Thread(new OddTask());

t1.start();
t2.start();

t1.join();  // Wait for t1 to finish
t2.join();  // Wait for t2 to finish

System.out.println("Both threads finished!");
Without join(), main() might print before threads are done.


 */
public class RaceCondition {
}
