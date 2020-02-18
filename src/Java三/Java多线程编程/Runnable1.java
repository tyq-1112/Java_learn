package Java三.Java多线程编程;

class MyRunnable implements Runnable{          //线程的主体类
    private int ticket = 10 ;

    @Override
    public void run() {           //线程的主体方法
        for(int i = 0 ; i < 100 ;i++){
            if(this.ticket > 0)
            System.out.println("票数：ticket = "+ this.ticket--);
        }
    }
}
public class Runnable1 {
    public static void main(String[] args) {
        MyRunnable mt = new MyRunnable() ;
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
        //三个线程访问同一资源
    }
}
