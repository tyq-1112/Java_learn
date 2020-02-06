package java二.Genericty;


class Gpoint<T> {
    private T x;
    private T y;

    public void setX(T x) {
        this.x = x;
    }

    public Gpoint(T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x的坐标：" + this.x + "  y的坐标：" + this.y;
    }
}

public class GDemo {
    public static void main(String[] args) {
        Gpoint<Integer> gpointA = new Gpoint<>(5, 10);
        Gpoint<String> gpointB = new Gpoint<>("5","10");

        fun(gpointA);     //引用传递
        fun(gpointB);
    }

     static void fun(Gpoint<?> temp){         //通配符，可以接收所有的类型，并且不允许修改只可以获取
        //temp.setX("2");                   //提示错误，不允许修改
        System.out.println(temp);
    }
}
