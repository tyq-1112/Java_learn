package Java三.线程常用操作方法;


class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class Thread1 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt,"线程A").start();
        new Thread(mt).start();
        new Thread(mt,"线程B").start();

        mt.run();   //对象直接调用run方法
        System.out.println(Thread.currentThread().getName());
    }
}
