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

    如图，第一次没有括起来，输出0表明没有子shell；第二次有一个子shell，第三次又在子shell里嵌套了一个子shell。

    > 但我用ps -f查看子shell时，并没有显示嵌套的子shell：![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608181926.png)

- 后台模式

  - 除了能用`ps -f`查看进程外，用jobs也能显示`当前运行的后台进程`（不能显示已完成的），`jobs -l`则可以查看更多信息：

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608182852.png)

    如图，`sleep 3`时必须等3s才能继续操作，`sleep 10&`时仍可继续输入命令，且可以看到端口号`3160`和之前的一致

- 进程列表置入后台
  
- sleep和echo命令的进程列表只是作为一个示例而已。使用tar（参见第4章）创建备份文件是有效利用后台进程列表的一个更实用的例子。如` (tar -cf Rich.tar /home/rich ; tar -cf My.tar /home/christine)& `，
  
- 协程

  - 会做两件事：生成子shell，然后置入后台。如`coproc sleep 3`，也可以自己给进程起名：`corpoc myjob { sleep 3; }`：

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608202222.png)

    另外，如果在上一个coproc执行时创建一个新的，则会警告并等待上一个执行完成：

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210611121334.png)

    如上图，开始桌面上有两个文件`01.txt`和`02.txt`，接下来快速执行三个命令（在上一个进程还在sleep时就执行下一个），中间会警告：`still exists`。最后`ls`发现两个文件都删除成功。

    在进程结束前使用`ps --forest -f`查看父子进程关系：可以看到前两次coproc都创建了子shell来执行进程列表；第三次coproc也创建了子shell，没有在`ps`中显示，但可以看到子shell的PID为2190。最后一个命令`ps --forest -f`时用的是子进程来执行的（PID为2191），这是因为它是外部命令，后面会讲。

    > 至于为什么前两次coproc只显示sleep而不显示rm，好像是因为它只显示第一个。。。



#### 2. 内建命令

- 内建命令和shell结合在一起，不需要外部进程来执行。

- type可以看是否是内建，`type -a`可以看命令的所有实现方式，which只能看是否有外部命令。

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612111344.png)

  如上图，红圈中，echo有内建和外部两种命令，which只返回外部命令。而黄圈中，cd只有内建命令，因此which没有返回结果。

- history：`!!`，`!20`

- 别名：`alias -p`，`alias li='ls-li'`



#### 3. 小结

- [子shell和子进程的区别](http://c.biancheng.net/view/3015.html)

  > - 简单地说，子shell是一种纯粹的子进程
  > - 父进程需要等子进程执行完才能继续执行![子Shell和子进程](http://c.biancheng.net/uploads/allimg/190419/1-1Z4191AJ2A0.gif)
  >
  > - 创建子进程的两种方式：
  >   - 第一种只使用 fork() 函数，子进程和父进程几乎是一模一样的，父进程中的函数、变量、别名等在子进程中仍然有效。
  >   - 第二种使用 fork() 和 exec() 函数，子进程和父进程之间除了硬生生地维持一种“父子关系”外，再也没有任何联系了，它们就是两个完全不同的程序。
  >
  >   对于 Shell 来说，以新进程的方式运行脚本文件，比如`bash ./test.sh`、`chmod +x ./test.sh; ./test.sh`，或者在当前 Shell 中使用 bash 命令启动新的 Shell，它们都属于**第二种**创建子进程的方式，所以子进程除了能继承父进程的环境变量外，基本上也不能使用父进程的什么东西了，比如，父进程的全局变量、局部变量、文件描述符、别名等在子进程中都无效。
  >
  >   但是，组命令、命令替换、管道这几种语法都使用**第一种**方式创建进程，所以子进程可以使用父进程的一切，包括全局变量、局部变量、别名等。我们将这种子进程称为**子 Shell（sub shell）**。
  >
  > - 创建子shell的两种方式：小括号和coproc

  



### 第6章 环境变量

#### 1. 全局和局部变量

- `env`，`printenv`，`printenv HOME`，`echo $HOME`，`set`返回全局、局部和自定义，

#### 2. 自定义变量

- `echo`自定义变量时，不能初始化，只能先声明再赋值。

#### 3. 删除环境变量

- `unset my_var`
- 如果要用到变量，使用\$；如果要操作变量，不使用\$

#### 4. 默认的shell变量

- Bourne的变量，bash shell自带的变量

#### 6. 定位shell

- 登录shell

- 交互shell
- 非交互shell
  - 系统执行shell脚本时用的这种
- 持久化环境变量
  - \$HOME/.bashrc文件
  - 数组变量







### 第23章 dash shell

#### 1. dash shell

- 关系图![关系图](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210606150040.png)

- Ubuntu的shell

  - 用户默认的交互shell是：bash【打开的Terminal就是默认交互shell】![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608174859.png)

  - 默认的系统shell是：dash

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210604104427.png)




#### 2. dash shell的特性

- set查看环境变量