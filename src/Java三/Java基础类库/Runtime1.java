package Java三.Java基础类库;

public class Runtime1 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors()); //获取本机CPU的内核数，决定并发访问量的最佳状态

        System.out.println("最大可用内存空间"+runtime.maxMemory()/1024/1024/1024+"G");
        System.out.println("可用内存空间"+runtime.totalMemory()/1024/1024/1024+"G");
        System.out.println("空闲内存空间"+runtime.freeMemory()/1024/1024/1024+"G");

        runtime.gc();
    }
}
