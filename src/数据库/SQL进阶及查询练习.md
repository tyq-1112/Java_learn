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



### 引擎

##### Myisam

它管理的表具有一下特征：

> 使用三个文件表示每个表：
>
> > 格式文件：——存储结构的定义（xxx.frm）
> >
> > 数据文件：——存储表行的内容（xxx.MYD）
> >
> > 索引文件：——存储表上索引（xxx.MYI）



> 灵活的AUTO_INCREMENT字段处理
>
> 可被转换为压缩，只读表来节省空间
>
> 不支持事务



##### InnoDB

1、支持事务、行级锁、外键等，这种存储引擎数据的安全得到保障（缺省引擎）

> 表的结构存储在xxx.frm文件中
>
> 数据存储在tablespace空间中（逻辑概念），无法被压缩，无法转换只读
>
> 在数据库崩溃之后提供自动恢复
>
> 支持级联更新和级联删除



##### MEMORY（HEPA）

缺点：不支持事务，数据容易丢失，因为数据和索引存储在内存当中

优点：查询速度最快

### 事务

事务包括四大特性：ACID

> A：原子性：事务是最小的工作单元，不可再分
>
> C：一致性：事务必须保证多条DML语句同时成功同时失败
>
> I：隔离性：事务A与事务B之间具有隔离
>
> D：持久性：最终数据必须持久化到硬盘文件中，事务才算成功的结束



事务隔离性存在隔离级别：

> 第一级别：读未提交（read uncommitted），

对方事务还没有提交，我们当前事务可以读取到对方未提交的数据，

存在脏读现象，表示读到了脏的数据



> 第二级别：读已提交（read committed）

对方事务提交之后的数据我方可以读取到，解决了脏读现象

读已提交存在的问题：不可重复读



> 第三级别：可重复读（repeatable read）

解决了：不可重读读的问题

存在的问题是：读取的数据是幻象的



> 第四级别：系列化读

解决了所有问题，效率低，事务需要排队



Oracle数据库默认的隔离级别是：读已提交

MySQL数据库默认的隔离级别是：可重复读



##### 演示事务

MySQL中的事务是支持自动提交的，只要执行一条DML，则提交一次，

关闭自动提交：start transaction；



mysql> insert into t_user values (null,null);
Query OK, 1 row affected (0.03 sec)

mysql> select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | NULL     |
+----+----------+
1 row in set (0.00 sec)

mysql> rollback;
Query OK, 0 rows affected (0.00 sec)

mysql> select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | NULL     |
+----+----------+
1 row in set (0.00 sec)



关闭自动提交：start transaction；

mysql> start transaction;
Query OK, 0 rows affected (0.00 sec)

mysql> insert into t_user values(null,'lisi'),(null,'wangwu');
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | NULL     |
|  4 | lisi     |
|  5 | wangwu   |
+----+----------+
3 rows in set (0.00 sec)

mysql> rollback;
Query OK, 0 rows affected (0.01 sec)

mysql> select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | NULL     |
+----+----------+
1 row in set (0.00 sec)



rollback：只能回滚到上一次的提交点，

savepoint 命名 ；

rollback 名字；

commit  提交 ；



### 索引

查询一张表的时候两种检索方式：

> 全表扫描
>
> 根据索引检索（效率很高）



1.什么时候考虑给字段添加索引

> 数据量庞大
>
> 该字段很少的DML操作（因为字段进行修改操作，索引也需要维护）
>
> 该字段经常出现在where子句中



注：主键和具有unique约束的字段自动会添加索引

根据主键查询效率很高，



新建索引：create index 索引名称 on 表名（字段名）

删除索引：drop  index 索引名称 on 表名（字段名）



索引底层采用的数据结构是：B+Tree



索引会自动排序

![image-20200526123928283](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20200526123928283.png)



索引什么时候失效？

如：模糊查询第一个通配符使用百分号

ename like '%A%';