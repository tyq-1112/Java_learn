package Java三.线程常用操作方法;

public class join1 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainthread = Thread.currentThread();             //获得主线程
        new Thread(()->{
            for(int x = 0 ; x<100 ; x++){
                if(x==3){                   //满足条件时
                    try {
                        mainthread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 执行、x = "+ x);
            }
        },"子线程对象").start();
        for(int x=0 ; x<100 ;x++){
            Thread.sleep(100);
            System.out.println("【主线程main】number = "+ x);
        }
    }
}
