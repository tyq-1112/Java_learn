package Exception;

class Math{
    public static int div(int x,int y)throws Exception{
        int res = 0;
        System.out.println("*********开始除法计算****");
        res = x/ y ;                                        //当除数为0，出现异常，向上抛
        System.out.println("*****除法计算结束****");
        return res ;
    }
}
public class EDemo {
    public static void main(String[] args)throws Exception {
        try{
            System.out.println(Math.div(10,0));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
