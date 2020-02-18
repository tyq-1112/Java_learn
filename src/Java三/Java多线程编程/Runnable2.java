package Java三.Java多线程编程;

public class Runnable2 {
    public static void main(String[] args) {
        for (int x = 0; x < 2; x++) {
            String title = "线程对象-" + x;
            Runnable run = () -> {
                for (int y = 0; y < 10; y++) {
                    System.out.println(title + " y = " + y);
                }
            };
            new Thread(run).start();
        }
        /*
        for (int x = 0; x < 2; x++) {
            String title = "线程对象-" + x;
            new Thread(() -> {
                for (int y = 0; y < 10; y++) {
                    System.out.println(title + " y = " + y);
                }
            }).start();
        }
       */
    }
}
