package Java三.多线程深入话题;
/*
* 后台守护线程
* 守护线程是随着整体程序存在的，
* 如果程序执行完毕了，守护线程就消失了，在JVM里最大的守护线程就是GC线程
* */
public class Daemon1 {
    public static void main(String[] args) {
        Thread useThread = new Thread(()->{
            for(int x = 0 ; x<10 ; x++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"、x="+x);
            }
        },"用户线程");

        Thread daemonThread = new Thread(()->{
            for(int x = 0 ; x<20 ; x++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"、x="+x);
            }
        },"守护线程");
        daemonThread.setDaemon(true);    //设为守护线程
        useThread.start();
        daemonThread.start();
/*
用户线程、x=0
守护线程、x=0
守护线程、x=1
用户线程、x=1
守护线程、x=2
用户线程、x=2
守护线程、x=3
用户线程、x=3
守护线程、x=4
用户线程、x=4
用户线程、x=5
守护线程、x=5
守护线程、x=6
用户线程、x=6
守护线程、x=7
用户线程、x=7
守护线程、x=8
用户线程、x=8
守护线程、x=9
用户线程、x=9
        */
    }
}
