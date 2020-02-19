package Java三.线程常用操作方法;

public class Interrupt1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("****线程开始启动***");
            try {
                Thread.sleep(10000);         //预计准备休眠10秒
            } catch (InterruptedException e) {
                System.out.println("*****线程中断抛出异常****");
            }
        }) ;
        thread.start();    //开始就绪
        Thread.sleep(1000);
        if(!Thread.interrupted()){
            System.out.println("******线程中断****");
            thread.interrupt();
        }
    }
}
