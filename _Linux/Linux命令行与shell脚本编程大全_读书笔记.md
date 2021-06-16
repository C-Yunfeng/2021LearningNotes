### 配置

##### 1. 禁用Ubuntu的alt+Tab快捷键

参考：https://ubuntuforums.org/showthread.php?t=2211863【没解决】

1. 安装compizconfig：`sudo apt-get install compizconfig-settings-manager`
2. 安装插件：`sudo apt-get install compiz-plugins`
3. 按Alt+F2，输入ccsm打开compiz界面
4. 。。。。不行

##### 2. VMware的Ubuntu卡启动页

参考：[VMware中Ubuntu开机时停在启动界面，不进入X-window的解决办法](https://www.cnblogs.com/tyee/p/10476642.html)

多重启几次就好了





### 第5章 shell

> 这一章看的比较细，也上手做了很多实验，主要是理解进程和shell

#### 5.1 shell的父子关系

- 用bash创建子线程，子线程还能继续创建，用exit退出一个线程（子线程父线程都行）【ps --forest可以查看子shell间的嵌套结构】

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608180226.png)

  图中黄框中，第一个bash是CLI，第二个是创建的子shell

##### 5.1.1 进程列表

- 用(;)包起来，则这里面的命令由一个子shell执行，可以用`echo $BASH_SUBSHELL`来查看shell的编号【用中括号{;}提示error】

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608181447.png)

  如图，第一次没有括起来，输出0表明没有子shell；第二次有一个子shell，第三次又在子shell里嵌套了一个子shell。

  > 但我用ps -f查看子shell时，并没有显示嵌套的子shell：
  >
  > ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608181926.png)

##### 5.1.2 后台模式

- 除了能用`ps -f`查看进程外，用jobs也能显示`当前运行的后台进程`（不能显示已完成的），`jobs -l`则可以查看更多信息：

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608182852.png)

  如图，`sleep 3`时必须等3s才能继续操作，`sleep 10&`时仍可继续输入命令，且可以看到端口号`3160`和之前的一致

- 进程列表置入后台
- sleep和echo命令的进程列表只是作为一个示例而已。使用tar（参见第4章）创建备份文件是有效利用后台进程列表的一个更实用的例子。如` (tar -cf Rich.tar /home/rich ; tar -cf My.tar /home/christine)& `，

##### 5.1.3 协程

- 会做两件事：生成子shell，然后置入后台。如`coproc sleep 3`，也可以自己给进程起名：`corpoc myjob { sleep 3; }`：

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608202222.png)

  另外，如果在上一个coproc执行时创建一个新的，则会警告并等待上一个执行完成：

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210611121334.png)

  如上图，开始桌面上有两个文件`01.txt`和`02.txt`，接下来快速执行三个命令（在上一个进程还在sleep时就执行下一个），中间会警告：`still exists`。最后`ls`发现两个文件都删除成功。

  在进程结束前使用`ps --forest -f`查看父子进程关系：可以看到前两次coproc都创建了子shell来执行进程列表；第三次coproc也创建了子shell，没有在`ps`中显示，但可以看到子shell的PID为2190。最后一个命令`ps --forest -f`时用的是子进程来执行的（PID为2191），这是因为它是外部命令，后面会讲。

  > 至于为什么前两次coproc只显示sleep而不显示rm，好像是因为它只显示第一个。。。



#### 5.2 内建命令

- 内建命令和shell结合在一起，不需要外部进程来执行。

- type可以看是否是内建，`type -a`可以看命令的所有实现方式，which只能看是否有外部命令。

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612111344.png)

  如上图，红圈中，echo有内建和外部两种命令，which只返回外部命令。而黄圈中，cd只有内建命令，因此which没有返回结果。




#### 5.3 小结

##### 5.3.1 [子shell和子进程的区别](http://c.biancheng.net/view/3015.html)

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









### 第8章 文件系统

> 这一章也做了一些实验，遇到了一些bug，也找到了解决办法

#### 8.1 如何操作FS

##### 8.1.1 创建分区fdisk，

- 先查看分区`fdisk -l`，已经有三个了（也可以用`sudo fdisk /dev/sda`然后按p查看）

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612145525.png)

  不知道为什么不够用了，不是能有4个分区吗？没办法先把sda5删了，然后用`partprobe`重新加载，再看发现删除成功了：

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612151010.png)

- 新增分区，中间一路回车用默认选项。【我也不知道为什么编号没有3和4，直接到5了】

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612151651.png)

  新建成功：

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612151822.png)

  然后用`partprobe`重新加载，添加成功了：

  > 用partprobe时的warning：
  >
  > ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612143009.png)
  >
  > 查了一下，[说是没指定分区](https://www.linuxquestions.org/questions/linux-newbie-8/partprobe-error-in-lvm-creation-4175558916/)，没影响。也可以`partx -a /dev/sda5`指定一下
  >
  > I am new to using Linux, any advice will be appreciated.
  >
  > If you run *partprobe* without specifying a device, it probes all block devices, including the read-only CD drive if there is a disk loaded.

##### 8.1.2 创建文件系统

- `type`查看文件系统是否可用，如图：

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612141449.png)

- 在刚才新建的分区上创建一个默认的文件系统：`sudo mkfs.ext4 /dev/sda5`。遇到问题：/dev/sda5 contains a swap file system，不知道为什么，重启虚拟机就好了，然后重新创建FS：

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612153128.png)

- 挂载

  先创建存储数据的文件夹：`ls /mnt`，默认有这个文件夹，但是空的。在这创建一个子文件夹 my_part作为挂载点，然后用mount将分区sda5添加到这个挂载点：

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210612154118.png)

  【省略自动挂载】

- 文件系统的 检查与恢复





### 第10章 编辑器

> 这一章基本跳着看，简单试了下vim的命令模式和输入模式，其他的编辑器只看了没上手

#### 10.1 vim

##### 10.1.1 安装

- Ubuntu自带vi，只有vim的少量功能，所以先要安装vim：`sudo apt install vim`
- [apt和apt-get的区别](https://www.sysgeek.cn/apt-vs-apt-get/)

##### 10.1.2 退出

- 在命令模式下，按`:q`然后回车退出，不过可能要确认。可以用`:q!`不保存强制退出









### 第23章 dash shell

> 这一章学习了shell的历史，

#### 1. dash shell

- 关系图![关系图](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210606150040.png)

- Ubuntu的shell

  - 用户默认的交互shell是：bash【打开的Terminal就是默认交互shell】![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210608174859.png)

  - 默认的系统shell是：dash

    ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210604104427.png)




#### 2. dash shell的特性

- set查看环境变量