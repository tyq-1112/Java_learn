package Java三.多线程综合案例;

public class Math_add_sub {
    public static void main(String[] args) {
        Resource res = new Resource();
        Add add = new Add(res);
        Sub sub = new Sub(res) ;
        new Thread(add,"加法线程-A").start();
        new Thread(add,"加法线程-B").start();
        new Thread(sub,"减法线程-X").start();
        new Thread(sub,"减法线程-Y").start();
    }
}
class Resource{
    private boolean flag = true ;
    //true为加法操作，无法执行减法操作
    //false为减法操作，无法执行加法操作
    private int num = 0 ;
    public synchronized void add () throws Exception{
        if(this.flag == false){              //现在需要执行减法操作，加法操作需要等待
            super.wait();
        }
        Thread.sleep(100);
        this.num++ ;
        System.out.println(Thread.currentThread().getName()+"、num = "+this.num);
        this.flag = false ;                    //加法操作执行完毕，需要执行减法
        super.notifyAll();                     //唤醒全部等待线程
    }

    public synchronized void sub()throws Exception{
        if(this.flag == true){                //减法操作需要等待
            super.wait();
        }
        Thread.sleep(1000);
        this.num--;
        System.out.println(Thread.currentThread().getName()+"、num ="+this.num);
        this.flag = true ;
        super.notifyAll();
    }
}
class Add implements Runnable{
    private Resource resource ;
    public Add(Resource resource){
        this.resource = resource ;
    }
    @Override
    public void run() {
        for(int i = 0 ; i<50 ; i++){
            try {
                this.resource.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Sub implements Runnable{
    private Resource resource ;
    public Sub(Resource resource){
        this.resource = resource ;
    }
    @Override
    public void run() {
        for(int i = 0 ; i<50 ; i++){
            try {
                this.resource.sub();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}