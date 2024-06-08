package MultithreadingIssues;

public class MemoryInconsistencyIssue {
    private static volatile Boolean flag = false;
    private static volatile Integer counter = 0;

    public static class Writer implements Runnable {
        @Override
        public void run() {
            counter = 42; // Write to counter
            flag = true;  // Write to flag
        }
    }

    public static class Reader implements Runnable {
        @Override
        public void run() {
            while (!flag) {
                // Busy-wait until flag is set
            }
            System.out.println("Counter: " + counter);
        }
    }
}
