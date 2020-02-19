package Java三.线程常用操作方法;

public class Sleep1 {
    public static void main(String[] args) {
        for(int num = 0 ; num<5 ; num++){
            new Thread(()->{
                for(int i = 0 ; i < 5 ;i++){
                    System.out.println(Thread.currentThread().getName()+"、num=" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"线程对象-"+num).start();
            //表面上是一起休眠然后一起进行自动唤醒，实际上有差别
        }
    }
}
