package Java三.Java多线程编程;

class MyThread extends Thread{          //线程的主体类
    private String title ;

    public MyThread(String title){
        this.title = title;
    }

    @Override
    public void run() {           //线程的主体方法
        for(int i = 0 ; i < 10 ;i++){
            System.out.println("多线程启动：i = "+i);
        }
    }
}
public class Thread1 {
    public static void main(String[] args) {
        new MyThread("A").start();
        new MyThread("B").start();
        //一个多线程只能启动一次，不能够重复启动，否则抛出异常
    }
}
