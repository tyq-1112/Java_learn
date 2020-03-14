# SQL进阶及查询练习

### mysql编码问题

**1.查看MYSQL数据库编码：**show variables like ‘char%’ ；

+--------------------------+---------------------------------------------------------+
| Variable_name            | Value                                                   |
+--------------------------+---------------------------------------------------------+
**| character_set_client     | gbk**                                                     |
| character_set_connection | gbk                                                     |
| character_set_database   | utf8mb4                                                 |
| character_set_filesystem | binary                                                  |
**| character_set_results    | gbk**                                                     |
| character_set_server     | utf8mb4                                                 |
| character_set_system     | utf8                                                    |
| character_sets_dir       | C:\Program Files\MySQL\MySQL Server 8.0\share\charsets\ |
+--------------------------+---------------------------------------------------------+

**2.编码解释**：

> **character_set_client :** Mysql使用该编码来解读客户端发送过来的数据，
>
> **character_set_results：**Mysql会把数据转换成该编码后，再发送给客户端

**3.乱码：**

**character_set_client = utf8 ;无论客户端发送的是什么数据，mysql都当成utf8的数据，**

> 若客户端发送的是GBK
>
> 服务器当成utf8对待
>
> 结果：必然会乱码
>
> 解决一：让客户端发送utf8的数据（行不通）
>
> 解决二：把character_set_client修改为gbk ，

**character_set_results = utf8;把数据用utf8编码发送给客户端**

> 若服务器发送给客户端的是utf8数据
>
> 客户端会把它当成gbk，因为cmd只能显示gbk
>
> 结果：必然乱码
>
> 解决一：让小黑屏使用utf8来解读（行不通）
>
> 解决二：让服务器发送gbk数据，set character_set_results = gbk ;



### mysql备份与恢复数据库

数据库——>sql ：备份

sql——>数据库 ：恢复

**1.数据库导出sql脚本(备份数据库内容，不是备份数据库)：**

> **mysqldump** -u 用户名 -p密码 数据库名 **>** 升成的脚本的路径
>
> 此语句不需要打分号，不需要登陆mysql，直接在cmd下运行
>
> 生成的脚本文件不包含creat database语句

**2.执行SQL脚本**

第一种方式：

> mysql -u用户名 -p密码 数据库**<**脚本文件路径

第二种方式：

> 登陆mysql
>
> source SQL脚本路径
>
> 如：source c:\goods.sql



### 约束之主键约束

**主键约束(唯一标识)**

> 非空
>
> 唯一
>
> 被引用

当表的某一列被指定为主键后，该列不能为空，不能有重复值

**修改表时指定主键：**alter table 表名 add primary key( 列 ) ；

**删除主键：**alter table 表名 drop primary key ；

**alter：**

> add  ——> 添加列
>
> modify——>修改列名和列类型
>
> change——>修改列名
>
> rename to——>修改表名



#### **主键自增长：**

**修改表时设置主键自增长：**alter table 表名  sid modify  int **auto_increment** ；

**修改表时删除主键自增长：**alter table 表名  sid modify int ；



#### **非空和唯一约束：**

因为某些列不能设置为NULL值，所以可以对列添加非空约束

create table stu(

​           sid int **primary key auto_increment ,**

​            sname carchar(20) **not null** 

)

**not null：**可以重复，不能为空

**not unique：**不能重复



### 外键约束

> 外键必须是另一表的主键的值
>
> 外键可以重复
>
> 外键可以为空

**1.添加外键：**alter table 表名 add **constraint** 外键名 **foreign key** （外键） **references** 表名（主键） ；



### 合并结果集

> 要求被合并的表中，列的类型和列数相同
>
> union：去除重复行
>
> union all：不去除重复行

select * from cd

union all

select * from ab ；



### 连接查询

*内连接

*外连接

> 右外连接
>
> 左外连接
>
> 全外连接（Mysql不支持）

*自然连接

##### *内连接：

> ***方言：**select * from 表1 别名1 ，表2 别名2 where 别名1.xx = 别名2.xx
>
> **标准：**select * from 表1 别名1 **inner join** 表2 别名2 on 别名1.xx = 别名2.xx
>
> **自然：**select * from 表1 别名1 **natural join** 表2 别名2 

##### ***外连接：**

> **左外：**select * from 表1 别名1 **left outer join** 表2 别名2 on别名1.xx = 别名2.xx
>
> **右外：**select * from 表1 别名1 **right outer join** 表2 别名2 on 别名1.xx = 别名2.xx
>
> **左右外自然：**select * from 表1 别名1 **natural right/left outer join** 表2 别名2 

##### *全连接：

可以使用union 来完成全连接



### 练习题：

**1.列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级**

select e.* , d.danme , m.ename , s.grade

from emp e left outer join dept d on e.deptno = d.deptno

​                  left outer join emp m on e.mgr = m.empno

​                  left outer join salgrade s on e.sal between s.losal and s.hisal

where e.sal>(select avg(sal) from emp) ;



**2.列出与SMITH从事相同工作的所有员工及部门名称**

 select e.*,d.dname
    from emp e,dept d
    where job=(select job from emp where ename='SMITH') and e.deptno = d.deptno;



**3.列出薪金高于在部门30工作的所有员工姓名和薪金、部门名称**

select e.ename , e.sal ,d.dname

 from emp.e , dept d

where e.sal > all (select  sal from emp where deptno =30) and e.deptno = d.deptno ;