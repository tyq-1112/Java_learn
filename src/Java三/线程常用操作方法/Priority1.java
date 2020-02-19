package Java三.线程常用操作方法;

public class Priority1 {
    public static void main(String[] args) throws Exception{
        Runnable Run = ()->{
            for(int x= 0 ;x <10 ;x++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread threadA = new Thread(Run,"线程对象A");
        Thread threadB = new Thread(Run,"线程对象B");
        Thread threadC = new Thread(Run,"线程对象C");
        threadA.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
