package Java三.线程的同步与死锁;

//模拟卖票
class Mythread implements Runnable {
    private int ticket = 100;//总票数

    @Override
    public synchronized void run() {
        while (true) {
            //synchronized (this) {               //每一次只允许一个线程访问
                if (ticket > 0) {
                    try {
                        Thread.sleep(1);                   //模拟网络延迟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "、ticket = " + ticket--);
                } else {
                    System.out.println("*****票卖光了");
                    break;
                }
            }
        }
    //}
}

public class synchronized1 {
    public static void main(String[] args) {
        Mythread mt = new Mythread();
        new Thread(mt, "卖票A").start();
        new Thread(mt, "卖票B").start();
        new Thread(mt, "卖票C").start();
    }
}
