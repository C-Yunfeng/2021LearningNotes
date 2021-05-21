### 岗位

面试官好，同学好，我叫崔一帆，是对外经济贸易大学的一名应届生，专业是信息管理与信息系统，

在校期间我学习过MySQL，Oracle，MongoDB等多种数据库的使用，也学了C++，Java，Python等编程语言。做过一些机器学习的项目和比赛，比如选取股票投资组合，健康险风控比赛等等，不过这些使用Python写的。Java的使用主要是平时做力扣题时会用到，但我也学习了工作中会用到的内容。

谢谢



#### JD

> 主要工作内容：
>
> 1.负责社区服务端架构设计和技术实现；
>
> 2.主要负责，雪球的用户中心/帖子/搜索/爬虫/反垃圾等；
>
> 3.主要参与，雪球的运营后台/审核后台设计开发；
>
> 4.其他相关工作内容。
>
> 
>
> 岗位要求：
>
> 1.本科及以上学历，计算机及相关专业；
>
> 2.有大规模高并发在线系统相关经验者优先；
>
> 3.基础知识扎实，熟悉Java及Java相关技术栈，并有深入研究；
>
> 4.熟悉常用的开源框架和开源服务(Spring、MySQL、Redis、MQ、RPC、ES等)；
>
> 5.有较强的系统设计能力、前瞻性的思维；
>
> 6.有较强的执行能力、良好的组织和协调能力，并能够完成高难度的问题。



> 一定要谦虚，别被骂。美团的凉经？





### 一、Java基础

#### 1. 类与接口

- 访问修饰符

  > | `修饰对象`           | `访问权限` | 类内 | 包内 | 子类（包内） | 子类（包外） | 其他包 |
  > | -------------------- | ---------- | ---- | ---- | ------------ | ------------ | ------ |
  > | 类、接口、对象、变量 | public     | Y    | Y    | Y            | Y            | Y      |
  > | 类、接口、对象、变量 | default    | Y    | Y    | Y            | N            | N      |
  > | 对象、变量           | protecte   | Y    | Y    | Y            | Y/N          | N      |
  > | 对象、变量           | private    | Y    | N    | N            | N            | N      |

- 非访问修饰符

  > |       | 类         | 方法                 | 成员变量 | 引用变量                   |
  > | ----- | ---------- | -------------------- | -------- | -------------------------- |
  > | final | 不能被继承 | 能被继承，不能被重写 | 不能修改 | 引用不能改，变量内容可以改 |

- 接口

  > - 接口可以有多个直接父接口，但接口只能继承接口，不能继承类；
  >
  > - 接口里定义的是多个类共同的公共行为规范，因此**所有成员都为public访问权限**；
  >
  > - 接口与抽象类
  >
  >   - 都不可被实例化，都可以包含抽象方法
  >   - **抽象类可以包含普通方法，而接口不能**
  >   - **抽象类可以定义普通成员变量，而接口不能**
  >   - 接口不包含构造器，而抽象类可以（**不用于创建对象，而是让子类调用，实现抽象类的初始化**）
  >   - 接口不包含初始化块，而抽象类可以。
  >   - 一个类只能继承一个类，而一个类可以实现多个接口。
  >
  > - https://www.zhihu.com/question/297328937/answer/524450829在java 8以后，如果你需要以下两点，你就用类或者抽象类。
  >
  >   1. 需要构造函数
  >
  >   2. 需要保持状态 （你可以理解为这个class里有属性，比如说int a这样的）
  >
  >   对于不需要构造函数和保持状态的功能抽象，你就尽量用interface。

- 重载和重写

- 基本数据类型有哪些，为什么Java要保留这些基本数据类型

  > 效率更快

- 泛型

  > - [x] https://www.bilibili.com/video/BV1T7411M7x1?p=36
  > - 通用自定义数据类型
  > - 容器的数据太杂，不便于整理。则给容器贴一个标签，规范容器内的数据类型。
  >
  > - 容器<数据类型>，
  >
  >   `List<String> strList=new ArrayList<String>();`
  >
  >   `strList.add(123)//报错`
  >
  >   `strList.get(1)//第二个`
  >
  > - Set和List的泛型相同，而Map的泛型有key和balue：`Map<String,String> map=new HashMap<String,String>();`

  

#### 2. String

- String的一些函数

  - 字符串是不可变的。
  - indexOf，split，replace，substring，trim，

- String,StringBuilder,StringBuffer的区别

  > | String | StringBuilder | StringBuffer               |
  > | ------ | ------------- | -------------------------- |
  > | 不可变 |               |                            |
  > |        | 希望共享      | synchronized，`不希望共享` |
  >
  > - StringBuilder可以append，insert，toString。StringBuffer也一样。

- 有没有用过String的 intern()方法

  > https://www.cnblogs.com/yanspecial/p/5296321.html，
  >
  > 当intern()被调用时，如果常量池中存在和该String对象equal的对象（由equals方法决定），则返回常量池中已有的String对象，若不存在，则将该对象加入常量池，并返回该对象的引用。

#### 3. HashMap

- HashMap操作

  > - map.put(eky,value);  //相当于dict，Hashmap不排序。TreeMap则根据key排序
  >
  > - remove(key)，size()，containsKey()，put相同的key则会覆盖，get(key)返回value，

- 与HashTable的区别

  > | HashMap                          | HashTable                                        |
  > | -------------------------------- | ------------------------------------------------ |
  > | `允许null键值`                   | 不允许                                           |
  > | `非线程安全`                     | Synchronize                                      |
  > | 有containsvalue和containsKey方法 | 有contains方法方法                               |
  > | Hashtable 继承于Dictionary 类    | HashMap 是Java1.2 引进的Map interface 的一个实现 |
  > | HashMap是Hashtable的轻量级实现   | Hashtable 比HashMap 要旧                         |

- hashMap中hash冲突是用什么方法解决的？

  > https://zhuanlan.zhihu.com/p/93913279
  >
  > 链表法和开放地址法。



#### 4. JDK

- jdk和jre有什么了解

  > 

- JDK1.8的新特性有哪些

  > 

### 二、多线程

#### 1. 线程

> - [x] 和进程的区别

- 调用start()启动一个线程，main是主线程，mt.run()不是启动线程

  ```java
  MyThread mt=new MyThread();
  mt.start();//启动一个线程——子线程——自动调用mt.run()
  mt.run();//没有启动子线程，不能同时跑
  ```

- 实现Runnable接口，实现run方法

  ```java
  public class MyRunnable implements Runnable{
      @Override
      public void run(){
          //...
      }
  }
  ```

  ```java
  Runnable r=new MyRunnable();//创建Runnable对象
  Thread t=new Thread(r);//创建线程对象，指向我的Runnable
  t.start();
  ```

  run()线程执行的时候执行的代码

- 用匿名内部类实现：

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210518111230.png)

- jdk8用lambda实现：前提是只有一个方法【依然是匿名内部类】

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210518111509.png)

- 相关方法

  > - setPriority(10)设置优先级。优先级不代表独占CPU。但不同操作系统也会不同。
  >
  > - sleep(毫秒)，每隔时间执行一个操作，比如检查服务器连接情况。
  >
  >   `Thread.sleep(millis:1000);`
  >
  > - join()让主线程等待这个子线程执行完毕
  >
  > - yield()高风亮节，让出CPU。`i%10==0`，`Thread.yield()`
  >
  > - interrupt()打断正在睡眠的线程

- 线程有哪几个生命周期？

  > 如图，好像两个人的沟通
  >
  > ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210517235045.png)

- sleep（）和wait（）的区别

  > https://zhuanlan.zhihu.com/p/86717279
  >
  > 1. sleep是线程中的方法，但是wait是Object中的方法。
  > 2. `sleep方法不会释放lock，但是wait会释放`，而且会加入到等待队列中。
  > 3. sleep方法不依赖于同步器synchronized，但是wait需要依赖synchronized关键字。
  > 4. `sleep不需要被唤醒（休眠之后推出阻塞），但是wait需要`（不指定时间需要被别人中断）。

- 线程私有的代表每一个都会创建一个新的是吗?

  > https://www.zhihu.com/question/268356000/answer/336271343，https://zhuanlan.zhihu.com/p/154428176
  >
  > pthread_key_create，一键多值，key数组





#### 2. 锁

- 死锁

  > - 杠上了，很危险
  >
  >   <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210517234008.png" style="zoom:50%;" />
  >
  > - 死锁代码实现：以下代码乘2，
  >
  > ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210517234445.png)
  >
  > - 避免死锁：使用synchronized时，有没有互相调用的方法被锁定，慎用synchronized

- 线程同步

  > 多个线程同时访问一个资源，某个线程访问资源时，加锁。等线程结束后，释放锁。让线程更安全【synchronized就是加锁的，对一段“代码”加锁后，当代码在执行时，其他线程就不能同时运行代码】
  >
  > - 在方法声明中添加synchronized关键字，`一旦进入方法，瞬间锁定`。不是每一个地方都要加，如果全加，就不是多线程了。
  >
  > - 在方法内部使用synchronized(){}语句块`对特定的对象上锁`。
  >
  >   ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210517161913.png)
  >
  > - 手动上锁，用的最少，会忘记解锁

- 如何实现doubleCheck的单例模式

- synchronized 和 voliate【这就是我的强项了】

  > 





#### 3. 线程池

> 帮助调度和使用线程

- 四种线程池

  > - cached，无限个子线程
  >
  >   ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210518115344.png)
  >
  > - fixed，一次线程数限制。四个执行完才执行其他的【常用】
  >
  >   ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210518115616.png)
  >
  > - scheduled，调度，延迟，轮巡
  >
  >   ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210518115943.png)
  >
  > - Single，一个子线程出错了，不影响继续执行
  >
  >   ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210518120244.png)
  >
  >   

- 线程池的参数

  > - 参数详解
  >
  >   - corepoolsize：核心线程数大小：不管它们创建以后是不是空闲的。线程池需要保持 corePoolSize 数量的线程。
  >
  >   - maxpoolsize：线程池中最多允许创建 maximumPoolSize 个线程
  >   - workQueue：
  >
  > - 线程执行流程：
  >
  >   ![图片](https://mmbiz.qpic.cn/mmbiz_png/lnCqjsQ6QHfDaFImrDpIwlHlmJVPdZU8K3x0j16tUTlUiaeqeQY9vKog5aUaYZSicofQMTkE38M39zTn07qbcEDw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
  >
  > - 

- 线程池的默认拒绝策略

  > - 触发拒绝
  >   1. 当接收到了 30 个比较耗时的任务时，10 个核心线程数都在工作，剩下的 20 个去队列里面排队。这个时候和最大线程数是没有关系的，所以和线程存活时间也就没有关系。
  >   2. 其实你知道这个线程池最多能接受多少任务，你就知道这个题的答案是什么了，上面的线程池中最多接受 1000（队列长度） + 30（最大线程数） = 1030 个任务。所以当已经接收了30个任务的情况下，如果再来 1000 个比较耗时的任务，这个时候队列也满了，最大线程数的线程也都在工作，这个时候线程池满载了。因此，在前面 30 个比较耗时的任务还没执行完成的情况下，再来 1001 个任务，第 1001 个任务就会触发线程池的拒绝策略了。
  >
  > - 四个策略https://blog.csdn.net/qq_33323054/article/details/106923732，https://www.cnblogs.com/eric-fang/p/11584142.html
  >   - `AbortPolicy：默认策略`；新任务提交时直接抛出未检查的异常RejectedExecutionException，该异常可由调用者捕获。`必须处理好抛出的异常，否则会打断当前的执行流程，影响后续的任务执行`。
  >   - CallerRunsPolicy：既不抛弃任务也不抛出异常，使用调用者所在线程运行新的任务。
  >   - DiscardPolicy：丢弃新的任务，且不抛出异常。
  >   - DiscardOldestPolicy：调用poll方法丢弃workQueue队头的任务，然后尝试提交新任务

- 有参数可以把核心线程销毁吗？



### 三、JVM

> - Java用自己的虚拟机实现了跨平台，但付出性能的代价。https://www.zhihu.com/question/264786567/answer/285208967

#### 1. 内存结构

> JVM内存结构：堆、栈、方法区

> https://mp.weixin.qq.com/s/NvR2pXh6Euhtuln1OIfdpA，https://zhuanlan.zhihu.com/p/73628158，https://zhuanlan.zhihu.com/p/38348646
>
> ![图片](https://mmbiz.qpic.cn/mmbiz_png/sMmr4XOCBzFk37aZWWbDhe8J23U1aWMAiaPWQKDpic5Cs0jo0OakWnrPibkKJ3zxbYS1raxicyC7qfl2HJwtVxA5xg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
>
> JVM包含两个子系统和两个组件，分别为
>
> - Class loader(类装载)：根据给定的全限定名类名(如：java.lang.Object)来装载class文件到运行时数据区的方法区中。
> - Execution engine（执行引擎）：执行class的指令。
> - Native Interface(本地接口)：与native lib交互，是其它编程语言交互的接口。
> - Runtime data area(运行时数据区域)：即我们常说的JVM的内存。
>   - Java 堆（Java Heap）是JVM所管理的内存中最大的一块，堆又是垃圾收集器管理的主要区域。
>     - 堆的作用是存放对象实例和数组。从结构上来分，可以分为新生代和老年代，其中年轻代又分 Eden 区和 Survivor 区，其中 Survivor 区又分 From 和 To 2个区
>   - 方法区和堆一样，是各个线程共享的内存区域，它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译后的代码等数据。很多人愿意把方法区称为“永久代”（PermanentGeneration），本质上两者并不等价，
>   - 方法栈（JVM Stack）：线程私有。存储局部变量表、操作栈、动态链接、方法出口，对象指针。
>
> 首先通过编译器把 Java源代码转换成字节码，Class loader(类装载)再把字节码加载到内存中，将其放在运行时数据区的方法区内，而字节码文件只是 JVM 的一套指令集规范，并不能直接交给底层操作系统去执行，因此需要特定的命令解析器执行引擎（Execution Engine），将字节码翻译成底层系统指令，再交由 CPU 去执行，而这个过程中需要调用其他语言的本地库接口（Native Interface）来实现整个程序的功能。

> - [ ] 常见内存溢出错误







#### 2. 垃圾回收

##### 1. 概念

> 垃圾回收的亮件事：哪些是垃圾？怎么回收垃圾？

> https://www.cnblogs.com/qianguyihao/p/4744233.html，
>
> - Java中，**GC的对象是Java堆和方法区**（即永久区）
> - Stop the World：对象移动时，确保对象引用更新的正确性，暂停所有用户进程。

##### 2. GC算法

> https://www.cnblogs.com/qianguyihao/p/4744233.html，https://zhuanlan.zhihu.com/p/73628158，
>
> - 垃圾定义算法
>   - 引用计数法（无法解决循环引用的问题，不被java采纳）
>   - 根搜索算法
>     - 四种可以做GC Root的对象
>       - `栈`（栈帧中的本地变量表）中`引用的对象`。
>       - `方法区中的静态成员`。
>       - 方法区中的常量引用的对象（全局变量）
>       - 本地方法栈中JNI（一般说的Native方法）引用的对象。
> - 垃圾搜集算法
>   - 标记-清除：首先通过根节点，标记所有从根节点开始的可达对象。然后，在清除阶段，清除所有未被标记的对象。
>   - 复制算法（新生代）
>   - 标记-整理（老年代）
> - [ ] 分代收集
>   - [ ] Minor的意思
>   - [x] From和To切换的具体过程https://mp.weixin.qq.com/s/mlYLHTTch504ZZ4gOLYrCQ



##### 3. GC收集器

- [ ] 



#### 3. 调优参数

> https://mp.weixin.qq.com/s/NvR2pXh6Euhtuln1OIfdpA

- 什么情况下会触发full GC？



### 四、内存模型JMM

> https://www.cnblogs.com/karrya/p/10960112.html，
>
> - [ ] https://zhuanlan.zhihu.com/p/38348646
>
> Java内存模型（JMM）：即多线程相关的。定义了一个线程对另一个线程可见，共享变量放在主内存中，每一个线程又有自己的本地内存，当每一个线程访问共享变量时，可能本地内存数据没能及时的刷线到主内存中去，因此产生的线程不安全的问题。





### 五、MySQL

- SQL的执行顺序？

  > 

#### 1. 索引

> 创建索引的原则
>
> 覆盖索引，还说了一下索引下推

##### 1. 索引结构

- B-和B+树

  > https://mp.weixin.qq.com/s/FXOEq-T7pDSlbwccW_2l_w，
  >
  > - B-树：![图片](https://mmbiz.qpic.cn/mmbiz_png/sMmr4XOCBzEK1LibhR8zQXiaxCiaaVYkDLZEiaQiaI8Bb8NFb7Wp0AlM8SqVAjJJOWN5Lreg0csHTibpJTYbovysia2sA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
  >
  > - B+树![图片](https://mmbiz.qpic.cn/mmbiz_png/sMmr4XOCBzEK1LibhR8zQXiaxCiaaVYkDLZWuloYEthOeMFqC3BHVHbiaF4iaJG3ptBCY5R6VDjRvlrXhvb55uKU0qg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
  >
  > - 区别
  >
  >   |            |                                      |          |                            |          |
  >   | ---------- | ------------------------------------ | -------- | -------------------------- | -------- |
  >   | B-         | 内部节点和叶子结点都存储数据         |          | 查询不稳定                 | 不可重复 |
  >   | B+         | 仅叶子结点存储数据，内部节点存储索引 | 有序链表 | 查询性能稳定，范围查找更快 | 可重复   |
  >   | 平衡二叉树 | 索引值+磁盘地址+左右节点的引用       |          |                            |          |
  >
  >   

- InnoDB一颗B+树可以存放多少数据

  > 假设B+树的高度为2的话，即有一个根结点和若干个叶子结点。这棵B+树的存放总记录数为=根结点指针数*单个叶子节点记录行数。
  >
  > - 如果一行记录的数据大小为1k，那么单个叶子节点可以存的记录数 =16k/1k =16.
  > - 非叶子节点内存放多少指针呢？我们假设主键ID为bigint类型，长度为8字节，而指针大小在InnoDB源码中设置为6字节，所以就是8+6=14字节，16k/14B =16*1024B/14B = 1170
  >
  > 因此，一棵高度为2的B+树，能存放1170 * 16=18720条这样的数据记录。同理一棵高度为3的B+树，能存放1170 *1170 *16 =21902400，也就是说，可以存放两千万左右的记录。B+树高度一般为1-3层，已经满足千万级别的数据存储。

- 为什么不用二叉树（如AVL）

  > 节点存储：索引值+磁盘地址+左右节点的引用<<<16KB，浪费大量空间。且数据很多时会瘦高，IO次数变多。







##### 2. MyISAM索引

- 主键索引和普通索引

  > https://mp.weixin.qq.com/s/FUXPXKfKyjxAvMUFHZm9UQ，
  >
  > MyISAM的索引与行记录是分开存储的，叫做**非聚集索引**（UnClustered Index）。
  >
  > 其主键索引与普通索引没有本质差异：
  >
  > - 有连续聚集的区域单独存储行记录
  > - 主键索引的叶子节点，存储主键，与对应行记录的指针
  > - 普通索引的叶子结点，存储索引列，与对应行记录的指针
  >
  > *画外音：MyISAM的表可以没有主键。*
  >
  > 主键索引与普通索引是两棵独立的索引B+树，通过索引列查找时，先定位到B+树的叶子节点，再通过指针定位到行记录。
  >
  > ![图片](https://mmbiz.qpic.cn/mmbiz_png/YrezxckhYOzaFEbhaCuVRlaia4wNntsw1dyQHl745gn5v8R0MyPUtW9mzMuYkobiaF0I0S8Lvca0O3ZicRXn3sGTg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)



##### 3. Innodb索引

- 主键索引

  > https://mp.weixin.qq.com/s/FUXPXKfKyjxAvMUFHZm9UQ
  >
  > InnoDB的**主键索引与**行记录是存储在一起的，故叫做**聚集索引**（Clustered Index）：
  >
  > - 没有单独区域存储行记录
  > - 主键索引的叶子节点，存储主键，与对应行记录（而不是指针）
  >
  > *画外音：因此，InnoDB的PK查询是非常快的。*
  >
  > 因为这个特性，InnoDB的表必须要有聚集索引：
  >
  > (1)如果表定义了PK，则PK就是聚集索引；
  >
  > (2)如果表没有定义PK，则第一个非空unique列是聚集索引；
  >
  > (3)否则，InnoDB会创建一个隐藏的row-id作为聚集索引；
  >
  > ![图片](https://mmbiz.qpic.cn/mmbiz_png/YrezxckhYOzaFEbhaCuVRlaia4wNntsw1NMzwVMbyWibBydL5Ev9kbWG5Ria6dcSzLSURMsicwbYfuibTUiaTaCwDqibg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
  >
  > 聚集索引，也只能够有一个，因为数据行在物理磁盘上只能有一份聚集存储。

- 普通索引

  > InnoDB的**普通索引**可以有多个，它与聚集索引是不同的：
  >
  > - 普通索引的叶子节点，存储主键（也不是指针）
  >
  > 对于InnoDB表，这里的启示是：
  >
  > (1)不建议使用较长的列做主键，例如char(64)，因为所有的普通索引都会存储主键，会导致普通索引过于庞大；
  >
  > (2)建议使用趋势递增的key做主键，由于数据行与索引一体，这样不至于插入记录时，有大量索引分裂，行记录移动；
  >
  > 当：select * from t where name=‘lisi’;
  >
  > ![图片](https://mmbiz.qpic.cn/mmbiz_png/YrezxckhYOzaFEbhaCuVRlaia4wNntsw1HOo8ibyGCeL5ZibtCHgxKG5mgP7hUhX67rjr5Xjm20uWic2b6WVUxy6Iw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
  >
  > 会先通过name辅助索引定位到B+树的叶子节点得到id=5，再通过聚集索引定位到行记录。
  >
  > *画外音：所以，其实扫了2遍索引树。*



##### 4. 小结

MyISAM和InnoDB都使用B+树来实现索引：

- MyISAM的索引与数据分开存储
- MyISAM的索引叶子存储指针，主键索引与普通索引无太大区别
- InnoDB的**聚集索引**和数据行统一存储
- InnoDB的聚集索引存储数据行本身，**普通索引**存储主键
- InnoDB一定有且只有一个聚集索引
- InnoDB建议使用趋势递增整数作为PK，而不宜使用较长的列作为PK





#### 2. 事务

##### 1. ACID

- ACID知道吗？解释一下

  > 原子性(Atomicity)、一致性(Consistency)、隔离性(Isolation)、持久性(Durability)。

- 数据库实现ACID

  > https://zhuanlan.zhihu.com/p/65281198
  >
  > 数据库必须要实现AID三大特性，才有可能实现一致性。
  >
  > - 原子性
  >
  >   OK，是利用Innodb的`undo log`。 `undo log名为回滚日志`，是实现原子性的关键，当事务回滚时能够撤销所有已经成功执行的sql语句，他需要记录你要回滚的相应日志信息。 例如
  >
  >   - (1)当你delete一条数据的时候，就需要记录这条数据的信息，回滚的时候，insert这条旧数据
  >   - (2)当你update一条数据的时候，就需要记录之前的旧值，回滚的时候，根据旧值执行update操作
  >   - (3)当年insert一条数据的时候，就需要这条记录的主键，回滚的时候，根据主键执行delete操作
  >
  >   `undo log`记录了这些回滚需要的信息，当事务执行失败或调用了rollback，导致事务需要回滚，便可以利用undo log中的信息将数据回滚到修改之前的样子。
  >
  >   `ps`:具体的undo log日志长啥样，这个可以写一篇文章了。而且写出来，看的人也不多，姑且先这么简单的理解吧。
  >
  > - 持久性
  >
  >   决定采用`redo log`解决上面的问题。当做数据修改的时候，不仅在内存中操作，还会在`redo log`中记录这次操作。当事务提交的时候，会将`redo log`日志进行刷盘(`redo log`一部分在内存中，一部分在磁盘上)。当数据库宕机重启的时候，会将`redo log`中的内容恢复到数据库中，再根据`undo log`和`binlog`内容决定回滚数据还是提交数据。
  >
  > - 隔离性
  >
  >   - 锁
  >
  >     等一个事务commit之后，第二个事务才会继续执行



##### 2. 事务隔离

- 
  
- MySQL的事务隔离机制
  
  - mysql隔离级别
  - 可重复读这个隔离级别解决了什么？没解决什么？
  - mysql的默认隔离级别？有没有解决幻读的问题？面试官说mysql默认级别已经解决了幻读的问题。。。。。
  
- 

- mysql的MVCC？答：为每个修改保存一个版本，版本与事务时间戳关联，读操作只读该事务开始前的数据库的快照。面试官否认我的MVCC并发版本控制

- MyISAM 和 InnoDB的区别

  > https://mp.weixin.qq.com/s/S_w-lzXzO875s9OpvFYpIA
  >
  > |        |        |            |            |        |                              |            |
  > | ------ | ------ | ---------- | ---------- | ------ | ---------------------------- | ---------- |
  > | MyISAM | 全表锁 | 不支持事务 | 不支持外键 | 并发差 | select，insert为主则可以使用 | 保存行数   |
  > | Innodb | 行级锁 | 事务       | 外键       | 并发强 | 空间打，效率低               | 不保存行数 |







### 六、计网

- 七层模型

  > - 应用层（HTTP、FTP、SMTP、POP、DHCP）
  >
  > - 表示层（数据表示、安全、压缩，JPEG）
  >
  > - 会话层（在五层模型里面已经合并到了应用层）





#### 1. 三次握手

https://mp.weixin.qq.com/s/YJcEtrKzCdHv66JnZg8Ocw，

- 3次握手”的作用就是`双方都能明确自己和对方的收、发能力是正常的`

  > ![preview](https://pic3.zhimg.com/v2-2a54823bd63e16674874aa46a67c6c72_r.jpg)

- 为什么不能两次握手？

  > https://zhuanlan.zhihu.com/p/53374516，
  >
  > 发送后都要收到反馈，才能确定自己的发送和接收能力。且双方都要知道都可以接发：
  >
  > ![img](https://pic2.zhimg.com/80/v2-0e041d18bf194379f89222fdedb07d55_720w.png)

  

#### 2. 四次挥手

- 过程

  > https://zhuanlan.zhihu.com/p/86426969，
  >
  > ![preview](https://pic2.zhimg.com/v2-c7d4b5aca66560365593f57385ce9fa9_r.jpg)

- 挥手为什么需要四次，而非三次？

  > 因为当服务端收到客户端的SYN连接请求报文后，可以直接发送SYN+ACK报文。其中ACK报文是用来应答的，SYN报文是用来同步的。但是关闭连接时，当`服务端收到FIN报文时，很可能并不会立即关闭SOCKET`，所以只能先回复一个ACK报文，告诉客户端，“你发的FIN报文我收到了”。`只有等到我服务端所有的报文都发送完了，我才能发送FIN报文`，因此不能一起发送。故需要四次挥手。

- 四次挥手的close_wait的状态是什么时候发生的？

  > 报文段最大生存时间MSL（Maximum Segment Lifetime），它是任何报文段被丢弃前在网络内的最长时间。
  >
  > 当TCP执行一个主动关闭，并发回最后一个ACK，该连接必须在TIME_WAIT状态停留的时间为2倍的MSL，保证客户端发送的最后一个ACK报文段能够到达服务器，即服务器能正常关闭。

- 为什么是2MSL

  > https://www.zhihu.com/question/67013338/answer/248271396
  >
  > 前提：客户端A，服务器B
  >
  > 1. ACK从A到B最多经过1MSL，超过这个时间B会重发FIN
  > 2. B重发的FIN最多经过1MSL到达A
  >
  > `如果B重发了FIN`，且网络没有故障(重发的FIN被丢弃或错误转发)，那么A一定能在2MSL之内收到该FIN，因此A只需要等待2MSL。



#### 3. HTTP

- 对http协议的理解

  > https://zhuanlan.zhihu.com/p/72616216
  >
  > HTTP是一个`基于TCP/IP通信协议`来传递数据的协议，传输的数据类型为HTML 文件,图片文件, 查询结果等。

- 状态码

  > 分类
  >
  > - 1XX- 信息型，服务器收到请求，需要请求者继续操作。
  > - 2XX- 成功型，请求成功收到，理解并处理。
  > - 3XX - 重定向，需要进一步的操作以完成请求。
  > - 4XX - 客户端错误，请求包含语法错误或无法完成请求。
  > - 5XX - 服务器错误，服务器在处理请求的过程中发生了错误。
  >
  > 常见状态码
  >
  > - `200` OK - 客户端请求成功
  > - 301 - 资源（网页等）被永久转移到其它URL
  > - 302 - 临时跳转
  > - 400 Bad Request - 客户端请求有语法错误，不能被服务器所理解
  > - 401 Unauthorized - 请求未经授权，这个状态代码必须和WWW-Authenticate报头域一起使用
  > - `404` - 请求资源不存在，可能是输入了错误的URL
  > - 500 - 服务器内部发生了不可预期的错误
  > - `503 Server Unavailable` - 服务器当前不能处理客户端的请求，一段时间后可能恢复正常。

- http的问题：

  > - 请求信息`明文传输`，容易被窃听截取
  > - 数据的完整性未校验，容易被篡改
  > - 没有验证对方身份，存在冒充危险

#### 4. HTTPS

- 概念

  > https://zhuanlan.zhihu.com/p/72616216
  >
  > HTTPS 协议（HyperText Transfer Protocol over Secure Socket Layer）：一般理解为HTTP+SSL/TLS，通过 SSL证书来验证服务器的身份，并为浏览器和服务器之间的通信进行加密。

- 缺点

  > - HTTPS协议多次握手，导致页面的加载时间延长近50%；
  > - HTTPS连接缓存不如HTTP高效，会增加数据开销和功耗；
  > - 申请SSL证书需要钱，功能越强大的证书费用越高。
  > - SSL涉及到的安全算法会消耗 CPU 资源，对服务器资源消耗较大。

- 区别

  > - HTTPS是HTTP协议的安全版本，HTTP协议的数据传输是明文的，是不安全的，HTTPS使用了SSL/TLS协议进行了加密处理。
  > - http和https使用连接方式不同，默认端口也不一样，http是80，https是443。





### 七、Spring

#### 1. IOC

- 解耦

  > https://zhuanlan.zhihu.com/p/130864540，
  >
  > 在项目中，底层的实现都是由很多个对象组成的，对象之间彼此合作实现项目的业务逻辑。但是，很多很多对象紧密结合在一起，一旦有一方出问题了，必然会对其他对象有所影响，所以才有了解藕的这种设计思想。
  >
  > ![img](https://pic1.zhimg.com/80/v2-14b733c717cbcf90b1c832234efb9144_720w.jpg)![img](https://pic3.zhimg.com/80/v2-d98ac8db0e75c79e9c7c9341bd60db52_720w.jpg)
  >
  > 如上图所示，本来 ABCD 是互相关联在一起的，当加入第三方容器的管理之后，每个对象都和第三方法的 IoC 容器关联，彼此之间不再直接联系在一起了，没有了耦合关系，全部对象都交由容器来控制，降低了这些对象的亲密度，就叫“解藕”。

- Inverse of Control（控制反转）

  > https://zhuanlan.zhihu.com/p/104519509
  >
  > - 在传统的程序设计，我们直接在对象内部通过 new 来创建对象，是程序主动去创建依赖对象；而在 Spring 中有专门的一个容器来创建和管理这些对象，并将对象依赖的其他对象注入到该对象中，这个容器我们一般称为 IoC 容器。
  >
  > - DI（Dependency Injection），即依赖注入，由 Martin Fowler 提出。可以认为 IoC 和 DI 其实是同一个概念的不同角度描述。
  >
  >   通过依赖注入机制，我们只需要通过简单的配置，而无需任何代码就可指定目标需要的资源，完成自身的业务逻辑，而不需要关心具体的资源来自何处，由谁实现。

- bean

  > 官方概念：在 Spring 中，构成应用程序主干并由 Spring IoC 容器管理的对象称为 bean。 bean 是一个由 Spring IoC 容器实例化，组装和管理的对象。
  >
  > 大白话：`bean 可以认为是那些我们想注入到 Spring IoC 容器的 Java 对象实例的抽象。`
  >
  > 我们经常会在 Service 上使用 @Service 注解，然后在要使用该 Service 的类中通过 @Autowire 注解来注入，这个 Service 就是一个 bean。在这个地方，@Service 注解相当于告诉 IoC 容器：这个类你需要帮我创建和管理；而 @Autowire 注解相当于告诉 IoC 容器：我需要依赖这个类，你需要帮我注入进来。

- BeanDefinition

  > 理解了 bean，BeanDefinition 就好理解了。BeanDefinition 是 bean 的定义，用来存储 bean 的所有属性方法定义。

- 容器

  > - BeanFactory：基础类型 IoC 容器，提供完整的 IoC 服务支持。
  >   - 类似HashMap，Key：BeanName，Value：Bean实例
  > - ApplicationContext：BeanFactory 的子接口，在 BeanFactory 的基础上构建，是相对比较高级的 IoC 容器实现。包含 BeanFactory 的所有功能，还提供了其他高级的特性，比如：事件发布、国际化信息支持、统一资源加载策略等。正常情况下，我们都是使用的 ApplicationContext。

#### 2. AOP

- Aspect Oriented Programmming（面向切面编程）

  > 

  



### 八、算法

- 反转链表

  > https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/shi-pin-tu-jie-jian-zhi-offer-24-fan-zhu-oym7/[视频图解]剑指 Offer 24. 反转链表，迭代 + 递归双解法

  ```java
  class Solution {
      public ListNode reverseList(ListNode head) {
          ListNode pre = null, cur = head;
          while(cur != null){
              ListNode nxt = cur.next;
              cur.next = pre;
              pre = cur;
              cur = nxt;
          }
          return pre;
      }
  }
  ```

  

- 两个字符串，在字符串1里找到包含字符串2的最短子串
  
  - 假如字符串2是"AB"，在字符串1中找到包含字符"A"和字符"B"的最短子串
  
- 讲一下快排的思路？快排的时间复杂度？怎么计算的？

  > 分治https://zhuanlan.zhihu.com/p/52884590![preview](https://pic3.zhimg.com/v2-2be156e0fc5be25068224b97d0d03046_r.jpg)
  >
  > 升序实例https://mp.weixin.qq.com/s/ppVtJRUez7emHtCwBdK3lg
  >
  > ![图片](https://mmbiz.qpic.cn/mmbiz_png/qQ1zuvjsChS9OrzydAS8GyCVLCMib5rj1Lg7HyNhKgJssX2wWs1WgmH7sJBlNvDEeA12d15UWh7HR610SJJOBlw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
  >
  > 复杂度https://mp.weixin.qq.com/s/xQKbORsMyGSvaEuNPKaDyQ
  >
  > 如果足够理想，那我们**期望每次都把数组都分成平均的两个部分**，如果按照这样的理想情况分下去，我们最终能得到一个完全二叉树。如果排序n个数字，那么这个树的深度就是$log_2(n+1)$，如果我们将比较n个数的耗时设置为T(n)，那我们可以得到如下的公式[1]：
  >
  > ```python
  > T(n) ≤ 2T(n/2) + n，T(1) = 0  
  > T(n) ≤ 2(2T(n/4)+n/2) + n = 4T(n/4) + 2n  
  > T(n) ≤ 4(2T(n/8)+n/4) + 2n = 8T(n/8) + 3n  
  > ......
  > T(n) ≤ nT(1) + (log2n)×n = O(nlogn) 
  > ```
  >
  > 而在最坏的情况下，这个树是一个完全的斜树，只有左半边或者右半边。这时候我们的比较次数就变为
  > ![图片](https://mmbiz.qpic.cn/mmbiz_png/QtPIxk7nOVdEuPkKZJbxFMpl8Chjye1AWlv62QnibkCQg6hLSh5wzN5Up5XcUyMrsfHnZ7HxT8M3fvNGfOA89Sg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)=`O(n的平方)`



### 其他

#### 反射

- 对反射的理解

#### 网络编程

- 网络编程会不会

- 



####  JUC

- CountDownLatch
- CyclicBarrier
- Phaser
- Semaphore
- LockSupport

#### Redis

- 问了点redis存储过程，怎么使用的
- Redis的基本数据结构
- Redis的缺点有哪些







### 面经

#### 自我介绍

- 为什么投java，我看你简历上都是Python的项目
  - 和同学一起学Java
- 有没有用java开发过项目

#### 1. Java基础

- 数组和链表，的复杂度
- 哈希表的实现方式
- 如果哈希表加了synchronized，效率很低怎么办
- 线程的生命周期
  - 刚开始的状态是什么？
  - 阻塞状态wait？
- 除了synchronized还有了解其他锁吗



#### 2. 计网

- 全同工和半通工
- TCP三次握手
- UDP不可靠吗，完全不可靠吗



### 资料

#### 书单

- 《深入理解Java虚拟机（第2版）》





