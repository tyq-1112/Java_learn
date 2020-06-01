package Java三.反射.反射与简单java类;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        String value = "empno:7369|ename:Smith|job:Clerk|salary:750.00|hiredate:2000-11-12";
        Emp emp = ClassInstanceFactory.creat(Emp.class, value);

        System.out.println("编号：" + emp.getEmpno() + "  姓名：" + emp.getEname() + "  职位：" + emp.getJob() +
                "  薪水：" + emp.getSalary() + "  入职日期：" + emp.getHiredate());
    }
}

class ClassInstanceFactory {
    private ClassInstanceFactory() {
    }

    /**
     * 实例化对象的创建方法，该对象可以根据传入的字符串结构：属性：内容|属性：内容
     *
     * @param tClass 要进行反射实例化的Class类对象
     * @param value  要设置给对象的属性内容
     * @return 配置好属性内容的对象
     */
    public static <T> T creat(Class<T> tClass, String value) {

        try {
            //如果想采用反射进行简单java类对象属性的设置，类中必须要有无参构造
            Object obj = tClass.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(obj, value);     //通过反射设置属性
            return (T) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class StringUtils {     //实现首字母大写功能

    public static String initcap(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (str.length() == 1) return str.toUpperCase();
        else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }

}

class BeanUtils {    //进行Bean处理
    private BeanUtils() {
    }

    public static void setValue(Object obj, String value) {
        String results[] = value.split("\\|");     //按照"|"进行每一组属性的拆分
        for (int x = 0; x < results.length; x++) {
            String attval[] = results[x].split(":");    //获取属性名称与内容
            try {
                Field field = obj.getClass().getDeclaredField(attval[0]);     //获取成员
                Method setmethod = obj.getClass().getDeclaredMethod("set" + StringUtils.initcap(attval[0]), field.getType());
                Object convertvalue = convertAttributeValue(field.getType().getName(), attval[1]);
                setmethod.invoke(obj, convertvalue);     //调用setter方法设置值
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现属性类型转换处理
     *
     * @param type  属性类型，通过Filed获取
     * @param value 属性内容，传入的都是字符串，需转为指定类型
     * @return 转换后的数据
     */
    public static Object convertAttributeValue(String type, String value) {

        if ("long".equals(type) || "java.lang.Long".equals(type)) return Long.parseLong(value);
        else if ("int".equals(type) || "java.lang.Integer".equals(type)) return Integer.parseInt(value);
        else if ("double".equals(type) || "java.lang.Double".equals(type)) return Double.parseDouble(value);
        else if ("java.util.Date".equals(type)) {     //日期型
            SimpleDateFormat sdf = null;
            if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else return new Date();
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();    //当前日期
            }
        }
        return value;
    }
}

class Emp {
    private Long empno;
    private String ename;
    private String job;
    private double salary;
    private Date hiredate;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getName() {
        return ename;
    }

    public void setName(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}