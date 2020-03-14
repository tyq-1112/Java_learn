# 数据库及SQL/MySQL基础

### SQL语言的概述

**SQL：**结构化查询语言

**SQL的作用：**客户端使用SQL来操作服务器

> 启动mysql.exe，连接服务器后，就可以使用sql来操作服务器
>
> 先java程序连接服务器，然后使用sql来操作服务器

**SQL语句分类：**

**DDL：**数据定义语言，用来定义数据库对象：库、表、列

> 创建、删除、修改：库、表结构

**DML**：数据操作语言，用来定义数据库记录

> 增、删、改：表记录

**DCL：**数据控制语言，用来定义访问权限和安全级别

**DQL：**数据查询语言，用来查询记录



### DDL之操作数据库

**查看所有的数据库：**show databases

**切换数据库：**ues 数据库名

**创建数据库：**create database [if not exists]  数据库名 [charset=utf8]

**删除数据库：**drop database [if exists] 数据库名

**修改数据库编码：**alter database 数据库名 character set utf8



### 数据类型

**double：**浮点型，如double(5,2)，其中必须有2为小数，即最大999.99

**decimal：**浮点型，在表单线方面使用该类型，不会出现精度缺失问题

**char：**固定长度字符串，char(255)

**varchar：**可变长度字符串类型，varchar(65535)

**text(clob)：**字符串类型

**blob：**字节类型

**date：**日期类型，yyyy-MM-dd

**time：**时间类型，hh：mm：ss

**timestamp：**时间戳类型



### DDL之操作表

**表：**

   **创建表：**

create table 表名(                                       create table if not exists tb_stu(

​    列名  列类型，                                         -> name varchar(15),

​    列名  列类型，                                         -> age int, 

​    .....）;                                                        -> gender varchar(10) )；



**查看当前数据库所有表名称：**show tables;

**查看表结构：**desc 表名；

**查看指定表的创建语句：**show create table 表名 ；

**删除表：**drop table 表名 ；



**添加列：**alter table 表名 add(

​     列名  列类型，

​     列名  列类型，

​      .....

);

**修改列类型：**alter table 表名 modify 列名  列类型 ；

**修改列名：**alter table 表名 change 原列名 新列名 列类型 ;

**删除列：**alter table 表名 drop 列名 ；

**修改表名称：**alter table 原表名 rename to 新表名 ；



### DML之插入记录

在数据库中所有的字符串类型，单引号，日期也是单引号

insert into 表名(字段，字段，....) values (.....) ,(....);

insert into user_info （user_id,user_name,status,years）values （123,'你好',1,15）,(456,‘你好’,2,16)；

不给出插入列，默认为所有列，值得顺序与创建时列的顺序相同



### DML之修改与删除记录

1.update 表名 set age = 18 where name = ‘张三’ ;

> 条件必须为boolean类型或者表达式
>
> 运算符：=、！=、<>、>、<、>=、<=、between .... and 、in（....）、is null 、not、or、and

2.delete from 表名  where  条件 ;



### DCL（数据控制语言）

一个项目创建一个用户，一个项目对应的数据库只有一个

这个用户只能这个数据库有权限，其他数据库操作不了

**创建用户：**

  create user 用户名@ip地址 identified by '密码' ;

> 用户只能在只能的IP地址上登陆

create user 用户名@**'%'** identified by '密码' ；

> 用户可以在**任意IP地址**上登陆

**给用户授权：**

grant 权限1，权限2，.... on 数据库.* **to** 用户名@IP地址 ;

> 给用户分派在指定的数据库上的指定的权限，
>
> 权限：create、alter、delete、updat.....

grant all on 数据库.*  **to** 用户名@IP地址

> 给用户分派指定数据库上的所有权限

**撤销授权：**

revoke 权限1、权限2，..... on 数据库.*  **from** 用户名@IP地址

**查看权限：**

show grants for 用户名@IP地址；

> show grants for root@localhost ;

**删除用户：**

drop user 用户名@IP地址



### DQL之基础查询之列控制

> **列运算：**select sal*1.5 from emp ；

> **连接字符串：**select **concat**('我的名字是'，ename) from emp ；

有时需要把NULL转换成其他值，方便四则运算，把null 换成0

> **处理NULL值：**select sal + if null (comm,0) from emp ;

> **起别名：**select ename **as** 姓名 from emp ；

​     as可以省略

> **取出完全重复的行：****select distinct comm from emp ；



### DQL之条件与模糊查询

条件查询与update、delete语句一样，使用where子句来控制记录

> select empno、sal、comm from emp where sal>10000 and comm is not null ；

**'_' 表示匹配一个字符  ‘%’ 匹配0-n个字符**

> select * from emp where ename like '%三' ;



### DQL之排序

ASC：升序  （可以省略）

DESC：降序

> **select * from goods order by shop_price asc , discount desc** ;



### DQL之聚合函数

**1.min 与 max**

> select min(sal) from emp ;   查询最低工资

**2.sum 与 avg**

> select sum（sal） from emp ；查询工资合

>select avg(sal) from emp ;   查询平均工资

**3.count**

> select count(*) from emp ; 计算emp表中所有列不为null的个数
>
> select count(sal) from emp ; 查询sal列不为NULL的个数



### DQL之分组查询

**group by ：**where语句之后

>  select cat_id,count(*) from goods **group by** cat_id ;
> +--------+----------+
> | cat_id | count(*) |
> +--------+----------+
> |      4 |        3 |
> |      8 |        3 |
> |     11 |        2 |
> |      3 |       15 |
> |      2 |        1 |
> |      5 |        1 |
> |     13 |        2 |
> |     15 |        2 |
> |     14 |        2 |
> +--------+----------+

**分完组之后的数据还是一张表，可以使用 having 继续进行DQL**

> select cat_id,count(*) as count from goods group by cat_id having count >=3;
>
> +--------+-------+
> | cat_id | count |
> +--------+-------+
> |      4 |     3 |
> |      8 |     3 |
> |      3 |    15 |
> +--------+-------+

**顺序：select —from — where — group by — having — order by**



### DQL之limit方言(Mysql)

limit 用来限定查询结果的起始行、以及总行数

> select * from emp limit 4,3 ;
>
> 4：表示从第五行开始，3：表示一共查询三行，即3行数据

