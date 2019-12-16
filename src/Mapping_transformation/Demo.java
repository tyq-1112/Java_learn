package Mapping_transformation;

class Dept
{
    private long deptno ;
    private  String dname ;
    private  String loc ;
    private Emp emps[] ;         //多个雇员信息
    public  Dept(long deptno , String dname ,String loc)
    {
        this.deptno = deptno ;
        this.dname = dname ;
        this.loc = loc ;
    }

    public void setEmps(Emp[] emps) {
        this.emps = emps;
    }
    public Emp[] getEmps()
    {
        return this.emps ;
    }
    //setter、getter、无参构造略
    public String getInfo()
    {
        return "【部门信息】部门编号："+this.deptno+"、部门名称："+this.dname +"、部门位置："+this.loc ;
    }

}
class Emp
{
    private long empno ;
    private  String ename ;
    private  String job ;
    private double sal ;
    private  double comm ;
    private Dept dept ;     //所属部门
    private Emp mgr ;       //所属领导
    public Emp(long empno ,String ename ,String job , double sal ,double comm)
    {
        this.empno = empno ;
        this.ename = ename ;
        this.job = job ;
        this.sal = sal ;
        this.comm = comm ;
    }
    //setter、getter、无参构造略
    public String getInfo()
    {
        return "【雇员信息】雇员编号："+this.empno + "、雇员姓名："+this.ename + "、雇员工作："+
                this.job + "、雇员薪水："+this.sal + "、雇员佣金"+this.comm ;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }

    public Dept getDept()
    {
        return this.dept ;
    }
    public Emp getMgr()
    {
        return this.mgr ;
    }

}
public class Demo {
    public static void main(String[] args) {
        Dept dept = new Dept(10,"财务部","长沙");
        Emp empA = new Emp(001,"A","java工程师",800.00,0.0);
        Emp empB = new Emp(002,"B","经理",1000.00,0.0);
        Emp empC = new Emp(003,"C","boss",1200.00,0.0);

        empA.setDept(dept);
        empB.setDept(dept);      //设置雇员与部门的关联
        empC.setDept(dept);

        empA.setMgr(empB);       //设置雇员与领导的关联
        empB.setMgr(empC);

        dept.setEmps(new Emp[]{empA,empB,empC});   //部门与雇员
        for(int i = 0 ; i<dept.getEmps().length;i++)
        {
            System.out.println(dept.getEmps()[i].getInfo());
        }

        //获取数据
        /*System.out.println(dept.getInfo()+"\n"); //部门信息
        for(int i = 0 ; i < dept.getEmps().length ; i++)
        {
            System.out.println(dept.getEmps()[i].getInfo());  //雇员信息
            if(dept.getEmps()[i].getMgr()!=null)
            System.out.println(dept.getEmps()[i].getMgr().getInfo());   //雇员的领导信息
            System.out.println();
        }
        System.out.println("------------------------------------------");
        System.out.println(empA.getDept().getInfo());     //雇员获取部门信息
        System.out.println(empA.getMgr().getInfo());      //雇员获取领导信息*/
    }
}
