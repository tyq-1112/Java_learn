package Java三.Java多线程编程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        for(int i = 0  ; i < 5 ; i++){
            System.out.println("线程执行：i = " + i);
        }
        return "线程执行完毕" ;
    }
}
public class Callable1 {
    public static void main(String[] args)throws Exception {
        FutureTask<String> task = new FutureTask<>(new MyCallable()) ;
        new Thread(task).start();
        System.out.println("【线程返回数据 】"+task.get());
    }
}
