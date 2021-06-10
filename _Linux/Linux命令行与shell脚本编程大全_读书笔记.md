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

    > 但我用ps -f查看子shell时，并没有显示嵌套的子shell：![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608181926.png)

- 后台模式

  - 除了能用`ps -f`查看进程外，用jobs也能显示`当前运行的后台进程`（不能显示已完成的），`jobs -l`则可以查看更多信息：

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608182852.png)

    如图，`sleep 3`时必须等3s才能继续操作，`sleep 10&`时仍可继续输入命令，且可以看到端口号`3160`和之前的一致

- 进程列表置入后台
  - sleep和echo命令的进程列表只是作为一个示例而已。使用tar（参见第4章）创建备份文件是有效利用后台进程列表的一个更实用的例子。如` (tar -cf Rich.tar /home/rich ; tar -cf My.tar /home/christine)& `，

- 协程

  - 会做两件事：生成子shell，然后置入后台。如`coproc sleep 10`，也可以自己给进程起名：`corpoc myjob { sleep 10; }`：

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608202222.png)

    另外，如果在上一个coproc执行时创建一个新的，则会警告并等待上一个执行完成：

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608204144.png)

    如上图，开始桌面上有两个文件`01.txt`和`02.txt`，接下来快速执行三个命令（在上一个进程结束前就执行下一个），中间会警告：`still exists`。最后`ls`发现两个文件都删除成功。

    > - `jobs`结果中减号和加号是什么意思？？？
    >
    > - 执行时ps输出结果还不能完全看懂【重新跑了一遍，所以PID对不上】：
    >
    >   ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608204834.png)

  - 携程与进程列表结合



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