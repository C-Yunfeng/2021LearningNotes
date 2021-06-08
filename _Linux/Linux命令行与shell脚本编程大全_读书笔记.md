### 配置

- 禁用Ubuntu的alt+Tab快捷键，[参考](https://ubuntuforums.org/showthread.php?t=2211863)【在VMware里还是不行，有时间再看】
  1. 安装compizconfig：`sudo apt-get install compizconfig-settings-manager`
  2. 安装插件：`sudo apt-get install compiz-plugins`
  3. 按Alt+F2，输入ccsm打开compiz界面
  4. 。。。。不行



### 第5章 shell

#### 1. shell的父子关系

- 用bash创建子线程，子线程还能继续创建，用exit退出一个线程（子线程父线程都行）【ps --forest可以查看子shell间的嵌套结构】

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608180226.png)

  图中黄框中，第一个bash是CLI，第二个是创建的子shell

- 进程列表：

  - 用(;)包起来，则这里面的命令由一个子shell执行，可以用`echo $BASH_SUBSHELL`来查看shell的编号【用中括号{;}提示error】

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608181447.png)

    如图，第一次没有括起来，输出0表明没有子shell；第二次有一个子shel，第三次又在子shell里嵌套了一个子shell。

  - 疑问：

    > 但我用ps -f查看子shell时，并没有显示嵌套的子shell：![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608181926.png)

- 后台模式

  - 除了能用`ps -f`查看进程外，用jobs也能显示`当前运行的后台进程`（不能显示已完成的），`jobs -l`则可以查看更多信息：

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608182852.png)

    如图，`sleep 3`时必须等3s才能继续操作，`sleep 10&`时仍可继续输入命令，且可以看到端口号`3160`和之前的一致

- 进程列表置入后台
  - 



#### 2. 内建命令







#### 3. 小结

- [ ] shell进程
- [ ] 子shell
  - [ ] 生成子shell
  - [ ] 新环境
- [ ] 子进程
- [ ] 默认的交互shell
- [ ] 内建命令和外部命令
  - [ ] 新环境





### 第23章 dash shell

#### dash shell

- 关系图![关系图](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210606150040.png)

- Ubuntu的shell

  - 用户默认的交互shell是：bash![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608174859.png)

  - 默认的系统shell是：dash

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210604104427.png)




#### dash shell的特性

- set查看环境变量