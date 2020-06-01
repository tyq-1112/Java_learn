### 浏览器发送请求三要素

1.控制浏览器发送请求地址

2.控制浏览器发送请求采用请求方式

3.控制浏览器发送请求携带请求参数



### 1.控制浏览器发送请求地址

1、超链接标签命令

1)、格式：

```html
<a href="www.baidu.com">提示信息</a>
```

​    鼠标单机时执行，要求浏览器立刻按照href属性地址发送请求。



2、表单标签命令

1)、格式：  

```html
<form action="http://www.baidu.com">
   <input type="submit" title="百度"/> <!--提交按钮-->
</form>
```

   在用户单机提交按钮时，触发表单标签命令，浏览器立刻按照action属性地址发送请求。



### 2.控制浏览器发送请求采用请求方式

GET请求方式：

1.要求浏览器发送请求时，携带的【请求参数数量】不能超过4k

2.要求浏览器发送请求时，必须在浏览器地址栏上将【请求参数信息】展示出来

3.要求浏览器发送请求时，必须将请求参数信息保存在HTTP请求协议包中【请求头】

4.要求浏览器在接收到服务器返回的资源文件内容后，必须将资源文件内容保存在浏览器的缓存



POST请求方式：

1.要求浏览器发送请求时，可以携带任意数量的【请求参数】

2.要求浏览器发送请求时，必须在浏览器地址栏上隐藏请求参数信息

3.要求浏览器发送请求时，必须将请求参数信息保存在HTTP请求协议包中【请求体】

4.禁止浏览器将服务器返回资源文件内容进行保存。



> 超链接标签命令在执行时，浏览器必须采用GET方式发送请求

> 表单标签method属性，要求浏览器采用对应的请求方式发送请求

```html
<html>
<body>
    <a href="https://www.sina.com.cn/">新浪</a>  <!-- 超链接默认是get方式请求-->

    <form action="http://www.baidu.com" method="get">  
        <!--method指定浏览器采用某种方式发送请求 默认是get -->
        <input type="submit" title="百度"/>
    </form>
</body>
</html>
```



##### 请求方式适用场景

![image-20200530232739061](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20200530232739061.png)



### 3.控制浏览器发送请求携带请求参数



**请求参数来源：超链接 ， 表单标签**

```html
 <!--浏览器携带参数请求-->
    <a href="http://www.baidu.com?username=xiaoxiang?value=123">百度</a>

    <form action="https://www.sina.com.cn?value=123" method="get">
        <!--此时value是不会作为请求参数发送-->
    <input type="text" name="username" value="mlike" />
    <input type="submit" />
        <!--当用户点击提交后，浏览器发送q请求信息https://www.sina.com.cn?username=mlike-->
    </form>
```



表单标签input ，select，text area：

```html
 <center>
        <form action="http://www.baidu.com">
            用户姓名：<input type="text" name="username" /> <!--文本框--><br />
            用户密码：<input type="password" name="password" /><!--密码框--><br />
            用户性别：<input type="radio" name="sex" value="man" />男
            <input type="radio" name="sex" value="woman" />女 <!--单选框，name值一样作为一组--><br />
            擅长技能：<input type="checkbox" name="jishu" value="java" />java
            <input type="checkbox" name="jishu" value="c++" />c++
            <input type="checkbox" name="jishu" value="python" />python <!--多选框--><br />
            用户头像：<input type="file" name="myfile" /><!--文件选择框，将文件内容作为请求参数内容--><br />

            籍贯：<select name="home">
                <option value="bj">北京</option>
                <option value="sh">上海</option>
                <option value="gd">广东</option>
                <option value="hn'">湖南</option>
            </select> <br />
            自我介绍：<textarea name="intro" rows=10 cols=30></textarea><br />
            <input type="submit" /><!--提交-->
            <input type="reset" /><!--重置-->
        </form>
    </center>
```



**对于radio和checkbox来说，value默认值是‘on’字符串**



满足请求参数的条件：

>必须声明在form标签内部
>
>必须声明name属性

> radio和checkbox 必须还要满足选中，才可以作为请求参数

> disabled：失去作为请求参数条件
>
> read Only：不影响表单域标签作为请求参数条件



# 前端CSS了解

1.通知浏览器将所有满足定位条件的HTML标签进行统一定位

2.通知浏览器对已经定位HTML标签中样式属性进行集中统一赋值管理

### ID选择器

1.根据HTML标签中ID属性的值进行定位



```html
<!DOCTYPE html>
<body>
    <style type="text/css">
        #one{
            color:bisque;
            font-family:fantasy;
        }
    </style>

    <div id="one">这是第一个DIV</div>
    <p id="one">这是第一个段落</p>
    <div id="two">这是第二个DIV</div>
    <p id="two">这是第二个段落</p>
    <div id="three">这是第三个DIV</div>
    <p id="three">这是第三个段落</p>

</body>
</html>
```

### 标签类型选择器

```html
 <style type="text/css">      
p {
            color: palevioletred;
            font-size: 30;
        }

        div {
            width:100px;
            height:100px;
            background-color: palegoldenrod;
            
        }
     </style>
```

### 层级选择器

```html
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        #five p {
            font-size: 60px;
            color: cornflowerblue;
        }
    </style>
</head>
<body>

    <div id="five">
        <p>这是第一个段落</p>
        <span>span1</span>
        <p>这是第二个段落</p>
    </div>

</body>

</html>
```

### 自定义选择器



```html
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        .ten{
            color:red;
        }
    </style>
</head>
<body>

    <div id="five">
        <p>这是第一个段落</p>
        <span>span1</span>
        <p class="ten">这是第二个段落</p>   <!--变为红色-->
    </div>

    <div id="six">
        <p>这是第一个段落</p>
        <span class="ten">span1</span>     <!--变为红色-->
        <p>这是第二个段落</p>
    </div>

</body>

</html>
```

# HTTP

### HTTP请求协议包内部空间

1.按照自上而下划分，分为4个空间

> 请求行：【url：请求地址      method：请求方式（get/post）】

> 请求头：【请求参数信息【get】】

> 空白行：【没有任何内容，起到隔离作用】

> 请求体：【请求参数信息【post】】



### HTTP响应协议包内部结构

> 状态行：【HTTP状态码】

> 响应头：【content-type：指定浏览器采用对应编译器对响应体二进制数据进行解析】

> 空白行：【没内容，起到隔离作用】

> 响应体：【可能被访问静态资源文件内容、命令，或者被访问的动态资源文件运行结果（二进制）】