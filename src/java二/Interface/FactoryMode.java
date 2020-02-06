package java二.Interface;

interface IFood {            //客户端
    void eat();
}

class Milk implements IFood {
    @Override
    public void eat() {
        System.out.println("drink milk");
    }
}

class Bread implements IFood {
    @Override
    public void eat() {
        System.out.println("eat bread");
    }
}

class Factory {
    public static IFood getInstance(String className) {
        if ("milk".equals(className)) {
            return new Milk();
        } else if ("bread".equals(className)) {
            return new Bread();
        } else return null;
    }
}
//子类扩充的时候只需要修改Factory类

//代理设计模型，帮助用户将所有的开发注意力只集中在核心业务功能的处理上
public class FactoryMode {
    public static void main(String[] args) {
        IFood food = Factory.getInstance(args[0]);
        food.eat();
    }
}
