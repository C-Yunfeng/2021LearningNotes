#### 1. 定义前言

- [x] A/B test的定义

  > 追踪是什么因素影响了指标的变动，并根据试验结果作出决策

- [x] 为什么要做A/B test

  <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319134137.png" style="zoom:50%;" />

- [x] 什么时候做A/B test

  <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/image-20210319135452178.png" style="zoom:50%;" />

  <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319135518.png" style="zoom:50%;" />



- [ ] 准备工作：
  - [x] 调查清楚所有流量渠道，为了确保之后的抽样不会有很大的错误





#### 2. 十个步骤

<img src="C:\Users\18810\AppData\Roaming\Typora\typora-user-images\image-20210319140324531.png" alt="image-20210319140324531" style="zoom:50%;" />

1. 原假设和备择假设反了吧？？？<img src="C:\Users\18810\AppData\Roaming\Typora\typora-user-images\image-20210319141111204.png" alt="image-20210319141111204" style="zoom:50%;" />

2. 红绿

3. 留存率算是kpi吗？还是只能算中间指标？<img src="C:\Users\18810\AppData\Roaming\Typora\typora-user-images\image-20210319141225749.png" alt="image-20210319141225749" style="zoom:50%;" />

4. 一般用手机号，而非用户id吧，尤其是中国移动APP<img src="C:\Users\18810\AppData\Roaming\Typora\typora-user-images\image-20210319141600394.png" alt="image-20210319141600394" style="zoom:50%;" />

5. 是否有干扰？？？

6. 确定ES，即**直接指标**变化了多少。商业分析、产品分析中常规的标准为10%，其他行业可能用更高的25%左右。10%其实是公司来定的。

7. 用户比例

   简单情况，各50%，但公司CEO会说，如果效果更差了，我们承担不了这样的风险。

   那比如，可以原方案占90%，新方案占10%。【当然还可以用正交抽样之类的】

8. α和β是和其他同事一起讨论的结果。

   > 混淆矩阵：
   >
   > |      | 接受      | 拒绝       |
   > | ---- | --------- | ---------- |
   > | 真   | TP        | FP，α=0.05 |
   > | 假   | FN，β=0.2 | TN         |

   用R语言计算：

   <img src="C:\Users\18810\AppData\Roaming\Typora\typora-user-images\image-20210319142737143.png" alt="image-20210319142737143" style="zoom:50%;" />

9. 试验跑多久【用用户样本量计算理想时长】

   - 根据样本量计算具体时间

     > 在重复抽样或无限总体抽样条件下，$z_{\alpha/2}$的值和样本量n共同确定了估计误差E的大小。因此，给定$z_{\alpha/2}$和总体标准差$\sigma$，可以确定任一允许估计误差所需要的样本量。

     <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319143243.png" style="zoom:50%;" />

   - 试验错误【不是误差，是错误】：

     注意：用不同的device可能是不同的方案，比如用手机没有login，是红色；但用电脑登录之后会是绿色。【不一样的方案，而且接受每一个方案的概率是不一样的】【解决办法：1.把这部分分开算，或者直接排除，或者用一个其他方法？？？】

     <img src="C:\Users\18810\AppData\Roaming\Typora\typora-user-images\image-20210319143347476.png" alt="image-20210319143347476" style="zoom:50%;" />

     <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319143714.png" style="zoom:50%;" />

     <img src="C:\Users\18810\AppData\Roaming\Typora\typora-user-images\image-20210319143734626.png" alt="image-20210319143734626" style="zoom:50%;" />

     或者可以参考这篇文章：[how long run an abtest](https://www.abtasty.com/blog/how-long-run-ab-test/)，文中说到样本必须具有代表性，比如流量来源覆盖必须完整、需要持续1/2个业务周期以让互联网用户充分感受。

   

   10. <img src="C:\Users\18810\AppData\Roaming\Typora\typora-user-images\image-20210319143848306.png" alt="image-20210319143848306" style="zoom:50%;" />

10. 小结

    <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/image-20210319144050154.png" style="zoom:50%;" />

#### 3. 什么情况适合做abtest

<img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319144110.png" style="zoom:50%;" />

- ABtest的使用条件

  > 1. abtest以此只能测一个因素的影响，
  > 2. 变量必须是可控的，比如背景颜色，而不能是是否充会员。
  > 3. 是否发布新产品/新功能的时候，或者计算产品/功能的影响



#### 4. [什么时候可以停止](https://www.kameleoon.com/en/blog/stopping-ab-tests-too-early)

​	[参考2](https://www.abtasty.com/blog/how-long-run-ab-test/)，

- 您的显着性水平是否等于或高于95％？

- 您的样本足够大，并且可以代表您的总体受众构成和比例吗？

  > 样本量可以通过公式计算，但具体抽样的时候：抽样要具有代表性，同时避免偏差

- 您是否在适当的时间长度内进行了测试？

  > 建议1/2个业务周期

- 您的显着性水平和转化率曲线是否平坦？

  > 曲线波动主要有两个原因：
  >
  > - **The novelty effect:** When people react to your change just because it’s new. It will fade with time.如下图所示，用户刚开始感到新鲜，但之后就回到原来的水平了
  >
  >   <img src="https://mk0abtastybwtpirqi5t.kinstacdn.com/wp-content/uploads/img_548ac53ee02a4.png" alt="How long to run an A/B test" style="zoom:50%;" />
  >
  > - **Regression to the mean:** The more data you record , the more you approach the “true value”. This is why your tests fluctuate so much at first, as outliers have an outsized impact.如下图
  >
  >   ![变异性结果检验](https://www.kameleoon.com/sites/default/files/inline-images/variability-results-ab-test.png)
  >
  >   这也是为什么α本身不够的原因。在测试期间，您可能多次达到95％才能真正停止测试。**在结束测试之前，请确保您的显着性曲线变平。**相同的原则适用于变量的转化率-考虑到情况和当前的变化率，直到波动可以忽略不计。
  >
  > 随着收集更多数据，您的置信区间将变得更加精确。因此，无论您做什么，都不要在测试真正结束之前报告测试结果。为了抵制停止测试的诱惑，通常最好不要在结束之前查看结果。如果不确定，最好让它运行更长的时间。

  



#### 5. 电商case

1. 做假设

   <img src="C:\Users\18810\AppData\Roaming\Typora\typora-user-images\image-20210319144455616.png" alt="image-20210319144455616" style="zoom:50%;" />

2. 确定实验组和对照组

   - 错误的方案设计：至少有两个因素是不一样的，每次test的时候只改变一个。<img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319144535.png" style="zoom:50%;" />

   - 正确的方案设计：分成3个

     <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319144633.png" style="zoom:50%;" />

3. kpi，收集数据，确保有数据在数据库里

​    6 . <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319144921.png" style="zoom:50%;" />

8. 所需样本量太大：

   <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319145106.png" style="zoom:50%;" />

   - 那么可以把α调高：

     <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319145147.png" style="zoom:50%;" />

9. 时长

   <img src="https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20210319145220.png" style="zoom:50%;" />

