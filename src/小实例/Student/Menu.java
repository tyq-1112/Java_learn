package 小实例.Student;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 菜单
 */
public class Menu {
    public static void choose() throws SQLException {
        IStudentService ss = StudentFactory.getInstance();
        System.out.println("【1】:查询当前插入学生结果");
        System.out.println("【2】:查询数据库全体学生结果");
        System.out.println("【3】：插入学生数据");
        System.out.println("【其他】：退出系统");
        while (true) {
            Scanner input = new Scanner(System.in);
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    System.out.println(Arrays.toString(ss.getData1()));
                    break;
                case 2:
                    System.out.println(Arrays.toString(ss.getData2()));
                    break;
                case 3:
                    try {
                        ss.addStudent();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    return;
            }
        }
    }
}
