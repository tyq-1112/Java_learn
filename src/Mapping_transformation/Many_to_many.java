package Mapping_transformation;

class Meber
{
    private String name ;
    private int age ;
    private Product products[] ;           //一个人浏览多个商品
    public Meber(String name , int age)
    {
        this.name = name ;
        this.age = age ;
    }
    public void setProducts(Product products[] )
    {
        this.products = products ;
    }
    public Product[] getProducts()
    {
        return products ;
    }
    public String getInfo()
    {
        return "【用户信息】姓名："+this.name + "年龄："+this.age ;
    }
}
class Product
{
    private String name ;
    private double price ;
    private Meber mebers[] ;                    //一个商品被多个人浏览
    public Product(String name ,double price)
    {
        this.name = name ;
        this.price = price ;
    }
    public String getInfo()
    {
        return "【商品信息】名称："+this.name + "价格："+this.price ;
    }

    public void setMebers(Meber[] mebers) {
        this.mebers = mebers;
    }

    public Meber[] getMebers() {
        return mebers;
    }
}
public class Many_to_many {
    public static void main(String[] args) {
        //设置关系
        Meber meberA = new Meber("小兔子",35);
        Meber meberB = new Meber("小白喵",20);
        Product proA = new Product("c++从入门到放弃",50.00);
        Product proB = new Product("java从入门到放弃",49.00);
        Product proC = new Product("C语言从入门到放弃",46.00);
        meberA.setProducts(new Product[]{proA,proB});
        meberB.setProducts(new Product[]{proA,proC});
        proA.setMebers(new Meber[]{meberA,meberB});
        proB.setMebers(new  Meber[]{meberB});
        proC.setMebers(new Meber[]{meberB});
     //获取数据
        System.out.println("-----------------根据用户查看浏览商品信息--------------------");
        System.out.println(meberA.getInfo());
        for(int i = 0 ; i<meberA.getProducts().length ;i++)
        {
            System.out.println("\t|-"+meberA.getProducts()[i].getInfo());
        }
        System.out.println("-----------------根据被浏览的商品查看用户--------------------");
        System.out.println(proA.getInfo());
        for(int i = 0 ; i< proA.getMebers().length ; i++)
        {
            System.out.println("\t|-"+proA.getMebers()[i].getInfo());
        }

    }
}
