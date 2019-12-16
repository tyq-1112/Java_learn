package Mapping_transformation;

class item
{
    private long id ;
    private  String title ;
    private subitem subitems[] ;          //一个分类有多个子分类
    public item(long id , String title)
    {
        this.id = id ;
        this.title = title ;
    }

    public void setSubitems(subitem[] subitems) {
        this.subitems = subitems;
    }

    public subitem[] getSubitems() {
        return subitems;
    }

    public String getInfo()
    {
        return "【分类信息】id = "+this.id + " title = "+this.title ;
    }

}
class subitem
{
    private long id ;
    private  String title ;
    private item item ;
    public subitem(long id , String title)
    {
        this.id = id ;
        this.title = title ;
    }
    public void setItem(item item)
    {
        this.item = item ;
    }
    public item getItem()
    {
        return item ;
    }
    public String getInfo()
    {
        return "【子分类信息】id = "+this.id + " title = "+this.title ;
    }
}
public class One_to_many {
    public static void main(String[] args) {
        item item = new item(001,"编程书籍");
        subitem subitems[] = new subitem[]{
                new subitem(002,"java从入门到放弃"),
                new subitem(003,"c++从入门到放弃")
        };
        item.setSubitems(subitems);             //一个分类有多个子分类

        for(int i = 0 ; i<subitems.length ; i++)
        {
            subitems[i].setItem(item);
        }


        System.out.println(item.getInfo());
        for(int  i = 0 ; i<item.getSubitems().length ; i++)
        {
            System.out.println(item.getSubitems()[i].getInfo());
        }
    }
}
