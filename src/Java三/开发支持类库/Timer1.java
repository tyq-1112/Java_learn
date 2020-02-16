package Java三.开发支持类库;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Mytask extends TimerTask {         //任务主体,每一个任务都是一个线程

    @Override
    public void run() {        //多线程处理方法
        System.out.println(Thread.currentThread().getName()+"、定时任务执行，当前时间"+ new Date());
    }
}
public class Timer1 {
    public static void main(String[] args) {
        Timer timer = new Timer() ;    //定时任务
        //定义间隔，100毫秒后开始执行，每秒执行一次
        timer.scheduleAtFixedRate(new Mytask(),100,1000);        //0为 立即启动
    }
}
