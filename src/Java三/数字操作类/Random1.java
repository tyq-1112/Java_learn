package Java三.数字操作类;

import java.util.Random;

public class Random1 {
    public static void main(String[] args) {
        Random random = new Random() ;
        for(int i=0 ; i<10 ;i++){
            System.out.print(random.nextInt(100)+"、");   //产生10个不大于100的数
        }
    }
}
