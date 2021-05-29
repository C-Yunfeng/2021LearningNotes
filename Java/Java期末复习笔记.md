---
title: Java期末复习笔记
index_img: https://user-images.githubusercontent.com/49241298/72427667-3b3b8f00-37c7-11ea-8ac3-60c57743dba7.png
excerpt: 继承、重写、抽象类、接口、集合、异常处理、Swing、多线程
tags:
- Java
- 期末笔记
---



参考资料：

- 菜鸟教程
- 《疯狂Java讲义》——李刚

---

#### 一、基础知识

##### 1.类型转换

- 自动类型转换：

  > byte——short——int——long——float——double
  >
  > ​				char ——|
  >
  > 1_bit		2_bit	   4_bit	8_bit	    4_bit	   8_bit
  
  <!-- more-->
  
  ![](https://user-images.githubusercontent.com/49241298/72427656-34148100-37c7-11ea-9163-2c610c6d5062.png)
  
  ![](https://user-images.githubusercontent.com/49241298/72427679-4098d980-37c7-11ea-8509-c49ba6162756.png)
  
  ![](https://user-images.githubusercontent.com/49241298/72427680-41317000-37c7-11ea-906a-f018dfb6014d.png)
  
  ![](https://user-images.githubusercontent.com/49241298/72427681-41317000-37c7-11ea-8a29-5e53242e1f83.png)



- 强制类型转换

  ![](https://user-images.githubusercontent.com/49241298/72427682-42629d00-37c7-11ea-9a28-ca8b69788426.png)



- 表达式类型自动提升
  - char与其他类型变量运算时，自动转化为int类型再参与运算。

![](https://user-images.githubusercontent.com/49241298/72427683-42fb3380-37c7-11ea-97a9-3417bd8c7fdc.png)

- 总结：
  
  - 低类型可以自动转化为高类型。高类型除了int至char/short/byte，其他的都需要强制类型转换。

##### 2.运算符

- &&与&
  
  - &&当第一个条件不成立之后，后面的条件都不执行了，而&则还是继续执行，直到整个条件语句执行完为止
  
- 在Java中%是取余运算符，要求两端操作数为整型（×）∵long，int，float，double都可以。

- ？：：
```java
expression?:s1:s2//二者类型相同
```

##### 3.默认初始化

- 基本数据类型的数组在创建之后，已经赋默认值 0 （或0L、0.0D、0.0F）；引用类型的数组在创建之后，已经赋默认值null(单不能使用)

```java
public class Test{
	static String s;
	public static void main(String[] args) {
		String s2;
		//System.out.println(s2); //不能用
		System.out.println(s);	//类变量，加载时初始化了，null
	}
}

String[] sa=new String [3];
out.println(sa[0]);//null

//String[] sa=new String[] {};
//out.println(sa[0]); //Error
```


##### 4.流程控制

- switch中只能整型、short、byte、字符型char

##### 5.基本类型

“宝宝出生if打雷”“宝宝出生if大佬”

| |                |         |           |        |                                          |
| ------------------------- | -------------- | ------- | --------- | ------ | ---------------------------------------- |
| 序号                      | 数据类型       | 字节 | 封装类    | 默认值 | 可表示数据范围                           |
| 1                         | byte(位)       | 1      | Byte      | 0      | -128~127                                 |
| 2                         | short(短整数)  | 2     | Short     | 0      | -32768~32767                             |
| 3                         | int(整数)      | 4     | Integer   | 0      | -2147483648~2147483647                   |
| 4                         | long(长整数)   | 8     | Long      | 0      | -9223372036854775808~9223372036854775807 |
| 5                         | float(单精度)  | 4      | Float     | 0.0    | 1.4E-45~3.4028235E38                     |
| 6                         | double(双精度) | 8      | Double    | 0.0    | 4.9E-324~1.7976931348623157E308          |
| 7                         | char(字符)     | 2      | Character | 空     | 0~65535                                  |
| 8                         | boolean        | 1       | Boolean   | flase  | true或false                              |



#### 二、类与对象

##### 1.修饰符

1. 访问修饰符

   - 简介：
     > **default** (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
     >
     > **private** : 在同一类内可见。使用对象：变量、方法。 **注意：不能修饰类（外部类）**
     >
     > **public** : 对所有类可见。使用对象：`类`、接口、变量、方法
     >**protected** : 对同一包内的类和所有子类可见。使用对象：变量、方法。 **注意：不能修饰类（外部类）**。
     >
     >![](https://user-images.githubusercontent.com/49241298/72427667-3b3b8f00-37c7-11ea-8ac3-60c57743dba7.png)
     
   - default：
   - private：
   
     - 被声明为 **private** 的方法、变量和构造方法只能被所属类访问，并且类和接口不能声明**private**
     - private的方法**不能被子类重写**，因为private修饰的方法对子类是隐藏的，即子类无法访问该方法。
   
   - protected：
   
     - **子类与基类在同一包中**：被声明为 protected 的变量、方法和构造器能被同一个包中的任何其他类访问；
     - **子类与基类不在同一包中**：那么在子类中，子类实例可以访问其从基类继承而来的 protected 方法，而不能访问基类实例的protected方法。
     - protected 可以修饰数据成员，构造方法，方法成员，**不能修饰类（内部类除外）**。
     - 接口及接口的成员变量和成员方法不能声明为 protected,如图：![](https://www.runoob.com/wp-content/uploads/2013/12/java-protected.gif)
   
   - public：
   
     - 接口里的变量都隐式声明为 **public static final** ,而接口里的方法默认情况下访问权限为 **public**。
2. 非访问修饰符

   - 简介

     > static 修饰符，用来修饰类方法、类变量。
     >
     > final 修饰符，用来修饰类、方法、变量，**final 修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。**
     >
     > abstract 修饰符，用来创建抽象类和抽象方法。
     >
     > synchronized 和 volatile 修饰符，主要用于线程的编程。
     
   - final
   
     - final 表示"最后的、最终的"含义，变量一旦赋值后，不能被重新赋值。被 final 修饰的实例变量必须显式指定初始值。
     - final 修饰符通常和 static 修饰符一起使用来创建类常量。
     - final方法**可以被继承**，**不能被重写**
   
   - abstract
   
     - 抽象类：
       - **抽象类不能用来实例化对象**，声明抽象类的唯一目的是为了将来对该类进行扩充。
       - 一个**类**不能同时被 abstract 和 final 修饰（因为final类不能被继承，就不能在子类中实现，即重写）。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。
         
          - 抽象类可以包含抽象方法和非抽象方法。
       
        - 抽象方法：
              - 抽象方法是一种没有任何实现的方法，该方法的的具体**实现由子类实现（即重写）**。
           
              - 抽象方法**不能被声明成 final（不能继承所以不能重写） 和 static**。（abstract和static可以同时修饰内部类）
           
              - 任何继承抽象类的子类必须实现父类的**所有抽象方法**，**除非该子类也是抽象类**。
           
              - 如果一个类包含若干个抽象方法，那么该类必须声明为抽象类。抽象类**可以不包含**抽象方法。
           
                ```java
                public abstract class SuperClass{
                    abstract void m(); //抽象方法
                }
                class SubClass extends SuperClass{
                    //实现抽象方法
                    void m(){
                        ......
                    }
                }
                ```

   - synchronized
      > synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。
      >
      > ```java
      > public synchronized void showDetails(){
      >        
      > }
      > ```

##### 2.继承

- 简介：

  > 消除臃肿。子类拥有父类**非 private** 的属性、方法。

- 访问控制与继承：
  - 父类中声明为 public 的方法在子类中也必须为 public。
  - 父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
  - 父类中声明为 private 的方法，不能够被继承。

- 接口：

  - 使用 implements 关键字可以变相的使 Java 具有多继承的特性，使用范围为类继承接口的情况，可以同时继承多个接口（接口跟接口之间采用逗号分隔）。
    ```java
    public interface A {
        public void eat();
        public void sleep();
    }
     
    public interface B {
        public void show();
    }
     
    public class C implements A,B {
    }
    ```

  - 

- 构造器

  - 子类是**不继承父类的构造器**（构造方法或者构造函数）的，它只是调用（隐式或显式）。如果父类的构造器带有参数，则必须在子类的构造器中显式地通过 **super** 关键字调用父类的构造器并配以适当的参数列表。

  - 如果父类构造器没有参数，则在子类的构造器中不需要使用 **super** 关键字调用父类构造器，系统会**自动调用父类的无参构造器**。

  - 类可以只有有参构造器，而没有无参构造器。

  - 父类没有无参构造器，且子类构造器中没有显示调用父类构造器时，报错。

    创建子类对象时，先创建父类对象。如果没有super，则调用F()，因为没有，所以报错。

    ```java
    class F{
    	public int i;
    	//F(){	}
    	F(int i){
    		this.i=i;
    	}
    }
    public class Test extends F{
        Test(int i){	//Error，F() not defined  
        	//super(i);	//换成super就可以了。
        	this.i=i;
        }
    	public static void main(String[] args) {
        	Test t = new Test(10);
        	System.out.println(t.i);
        }
    }
    ```

    

- this与super：

  - 构造器不能像其他方法那样直接调用，只能结合new使用。因此**在构造器中**使用this调用构造器时，可以避免创建一个新对象，还可以降低耦合性。
  - 在构造器中，如果使用this/super调用其他的构造器，则该代码应该写在**第一行**。
  - 当子类构造器要给父类中 private 的变量赋值时，就可以**直接使用super**，而非调用赋值函数。
  - 


##### 3.重写

- 重写方法：

  - **方法名**相同、**形参列表**相同、子类中**访问权限**更大。
- 父类的成员方法只能被它的子类重写。
  - **返回类型**与被重写方法的返回类型**可以不相同**，但是必须是父类返回值的派生类（java5 及更早版本返回类型要一样，Java7 及更高版本可以不同）。
  - 如果子类中重写了父类的方法，那子类的对象**无法直接**访问父类被覆盖的方法，而可以在子类的方法中调用该被覆盖的方法。
  - 如果子类中定义了和父类同名的**成员变量**，并不是完全覆盖，只是隐藏，同样可以使用super调用。
  - 如果父类构造器中调用了父类的一个方法，且该方法被子类重写了。当创建子类对象之前创建父类对象时，**调用子类重写之后的方法**。
  - 如果**不能继承**一个方法，**则不能重写**这个方法。因此，private方法不能重写，构造器不能重写。
  - 声明为 **final** 的方法不能被重写。
  - 声明为 **static** 的方法不能被重写，但是能够被再次声明。

#### 三、类与对象的应用

##### 1.对象处理

- ==和equals

  - 如果两个**基本**的**数值**类型变量，（不论数据类型是否相同），只要值相等，就返回true。

  - 如果两个引用型变量，只有指向同一对象时，==才返回true。

  - ==**不可**用于比较类型上**没有继承关系**的两个对象。

    ```java
    out.println("hello"==new Test());//因为String和Test没有继承关系，因此报错
    ```

  - **Object(StringBuffer等许多类)默认提供的equals()只比较对象的地址，因此本质上和==一样。**在实际应用中，常需要重写equals()。

  - 重写equals()的要求：

    - 自反性：x.equals(x)为true
    - 对称性：x.equals(y)为true，则y.euqals(x)也应为true
    - 传递性：x.equals(y)为true，y.equals(z)为true，则x.equals(z)也应该为true
    - 一致性：变量不变时，多少次返回结果应一致。
    - 当x不为null时，应使x.equals(null)返回false。

- 常量池：

  - 常量池保证相同的字符串直接量只有一个，不会产生多个副本。

    ```java
    public class aaa {
    	public static void main(String[] args) {
    		String s1="AstraStar";
    		String s2="Astra";
    		String s3="Star";
    		
    		String s4="Astra"+"Star";//编译时就确定,直接引用常量池中的AstraStar
    		String s5=s2+s3; //编译时没确定,因此不引用常量池的AstraStar
    		String s6=new String("AstraStar");//在堆内存，不引用常量池
    		
    		out.println(
    				"s1:"+System.identityHashCode(s1)+
    				"\ns2:"+System.identityHashCode(s2)+
    				"\ns3:"+System.identityHashCode(s3)+
    				"\ns4:"+System.identityHashCode(s4)+
    				"\ns5:"+System.identityHashCode(s5)+
    				"\ns6:"+System.identityHashCode(s6)
    				);
    		out.println((s1==s4)+" "+(s1==s5)+" "+(s4==s5)+" "+(s1==s6));
    	}
    }
    ```

    ![](https://user-images.githubusercontent.com/49241298/72427669-3c6cbc00-37c7-11ea-9060-d19c3f9b70a5.png)

##### 2.final修饰符

- final成员变量

  - final修饰的成员变量必须**显示地初始化**。

- final基本类型变量与final引用类型变量

  - 对于final修饰的引用类型变量，只能使引用的**地址**不被更改，对象完全可以改变。

- 宏替换

  - 上文常量池中，我们发现s5=s2+s3不能在编译时确定内容，因此没引用常量池中的s1。而将s2和s3分别用final修饰，则可以使其地址一样：

    ```java
    String str1="AB";
    final String str2="A";
    final String str3="B";
    String str4=str2+str3;
    out.println(str1==str4);//结果为true
    ```

- final方法

  - 可以继承，可以重载，**不可以重写**

- final类

  - 不能继承

##### 3.抽象类

- 抽象方法

  - 抽象方法与空方法：

    ```java
    public void f(){}
    public void f(){};
    //抽象方法必须属于抽象类
    public void g();
    ```

##### 4.接口

- ~~**接口中全是抽象方法**~~，*JDK 1.8 以后，接口里可以有静态方法和方法体了。*

- 接口文件保存在 .java 结尾的文件中，文件名使用接口名；接口的字节码文件保存在 .class 结尾的文件中。

- 接口可以有多个直接父接口，但接口只能继承接口，不能继承类；

- 接口里定义的是多个类共同的公共行为规范，因此**所有成员都为public访问权限**；

- 接口中可以包含的成员：

  - 变量：

    - 接口中的成员变量**只**能是**静态常量**。在接口里声明的成员变量，会自动加上**public static final**，如下，二行代码结果完全一样：

      ```java
      int a=5;
      public static final int a=5;
      //public与final因为共同规范；static因为接口不能实例化，所以static。
      ```

  - 方法：

    - 抽象方法

      ```java
      void f();	//public abstract
      void getName(int id);
      ```

    - 类方法

      ```java
      static g(){		//public static。不能加default
          out.println(" ");
      }	
      ```

    - 默认方法

      ```java
      default l(){	//default。不能加static，因此只能用接口的实现类的实例调用
          out.println(" ");
      }
      ```

  - 内部类：

    - 内部接口
    - 枚举

- 一个类实现一个/多个接口之后，必须**重写**这些接口里的**所有抽象**方法。否则该类也必须定义为抽象类。

- 接口与抽象类：

  - 都不可被实例化，都可以包含抽象方法
  - **抽象类可以包含普通方法，而接口不能**
  - **抽象类可以定义普通成员变量，而接口不能**
  - 接口不包含构造器，而抽象类可以（**不用于创建对象，而是让子类调用，实现抽象类的初始化**）
  - 接口不包含初始化块，而抽象类可以。
  - 一个类只能继承一个类，而一个类可以实现多个接口。

- 接口的使用：

  - 接口的继承：~~获得父接口的所有抽象方法、常量~~

    ```java
    interface ifA{
        int A=5;
        void testA();
    }
    interface ifB{
        int B=5;
        void testB();
    }
    interface ifC extends ifA,ifB{
        int C=10;
    }
    public class Test{
        public static void main(String[] args){
            System.out.println(ifC.C);
        }
    }
    
    ```

  - 类实现

    ```java
    interface ifA{
    	int a=10;
    	int geta();
    }
    public class Test implements ifA{
    	//static int geta() { //static method cannot hide geta() from ifA
    	//int geta() { //cannot reduce the visibility of geta() from ifA
    	public int geta() {
    		return ifA.a;
    	}
    	public static void main(String[] args) {
    		Test t=new Test();
    		ifA ifa=new Test();
    		out.println(t.geta());
    		out.println(ifa.geta());
    	}
    }
    ```


##### 5.内部类

- 内部类提供了更好的封装，可以吧内部类隐藏在外部类之内，不允许同一个包中的其他类访问该类。

- 内部类和外部类

  - 内部类可以多使用三个修饰符：**private、protected、static**
  - 非静态内部类不能拥有静态成员，即**静态成员**只能出现在**静态内部类**中。

- 非静态内部类

  - **非静态内部类里可以直接访问外部类的private的成员，而外部类不能直接访问内部类的变量。**

  - 同名变量：

    ```java
    OuterClass.this.str	//外部类变量
    InnerClass.this.str	//内部类变量，或this.str
    ```

  - 非静态内部类**不**能有**静态成员变量**，**静态方法**，**静态初始化块**。外部类的静态成员不能访问非静态内部类。

- 静态内部类

  - static的作用是将类的成员变为**类相关**，而非实例相关。因此外部类不能用static修饰，而内部类可以。

- (非)静态内部类案例：

  ```java
  public class Cow {
  	private double w;
  	private int i1=2019;
  	private static int i2=2020;
  	
  	public Cow(double w) {	//2
  		this.w=w;
  		}
  	private class CowLeg{	//非静态内部类
  		private double l;
  		//private static double h;	//非静态内部类不能有静态成员变量
  		//public static void train() {}	//非静态内部类不能有静态方法
  		//static {out.print("a");}	//非静态内部类不能有静态代码块
  		public CowLeg(double l) {	//4
  			this.l=l;
  		}
  		public void info() {	//5
  			out.println(w+" "+l);	//非静态内部类的方法可以直接访问外部类的private成员
  			out.println(Cow.this.i1);	//如果外内部类有同名变量，可以用Outer.this访问
  			out.println(this.l);	//等价于out.println(CowLeg.this.l);			
  			//out.println(Cow.this.i2);	//非静态可以访问静态，但不推荐
  		}
  	}
  	
  	private static class StaticClass{	//静态内部类
  		private int i3=2021;
  		private static int i4=2022;
  		public void info_s() {
  			//out.pritnln(w);	//静态内部类的方法不能访问外部类的非静态成员
  			out.println(i2);	//静态内部类的方法可以访问外部类的静态成员
  		}
  	}
  	
  	public void test() {	//3
          out.println(new CowLeg(1.2).l);	//外部类中，可以用new显式创建对象来访问内部类成员
          CowLeg cl=new CowLeg(1.1);	//外部类的非静态方法可以访问非静态内部类
  		cl.info();
  	}
  	public void test_s() {
  		out.println(StaticClass.i4);	//外部类用静态内部类的类名访问其类成员
  		//out.println(StaticClass.i3);  //外部类的方法不能用静态内部类的类名访问其非静态成员↓
  		out.println(new StaticClass().i3);	//但可以用实例来访问
  	}
  	public static void main(String[] args) {	//1
  		//CowLeg cl2=new CowLeg(1.2);	//外部类的静态方法不能访问非静态内部类
  		Cow cow=new Cow(370);
  		cow.test();
  	}
  }
  ```

  - 逻辑图

    ![](https://user-images.githubusercontent.com/49241298/72427672-3e367f80-37c7-11ea-996d-91d176b5cbe4.png)

- 内部类的应用

  - 创建静态内部类对象时，不用创建外部类对象。

  - 在外部类以外的地方创建静态内部类对象的语句：

    ```java
    OutClass.InnerClass oi=new OuterClass.InnerClass();
    ```

- 局部内部类？匿名内部类？

##### 6.修饰符总结

|      |  外部类/接口    | 成员变量 | 方法 | 构造器 |初始化块|内部类|局部成员|
| ---- | ---- | ---- |---|---|---|---|---|
| public | √ | √ | √ | √ |	|√||
| protected |      | √ |√|**√**||√||
| 包访问控制符 | √ | √ |√|**√**|o|√|o|
| private      |      | √ |√|**√**||√||
| abstract     | √ |      |√|||**√**||
| final | √ | √ |√|||**√**|√|
| static | √ | √ |√||√|√||
| synchronized |      |      |√|||||
| default |      |      |**√**|||||

- ![11](https://user-images.githubusercontent.com/49241298/72427674-3ecf1600-37c7-11ea-9150-aedf2ad4d176.png)
- synchronized也可以修饰代码块

#### 四、Java集合

##### 1. Array

- 一维

  ```java
  public static void main(String[] args) {
      // 静态初始化：只能指定数组元素的初始值，不能指定长度
      int[] arr1 = new int[] { 1, 2, 3, 4 };
      int[] arr2 = { 1, 2, 3, 4 };	// 简化写法
      int[] arr3 = { 3, 4, 5, 6 };
      int[] arr4 = { 3, 4, 5, 6 };
      // Arrays类函数
      out.println("arr1.equals(arr2): " + Arrays.equals(arr1, arr2));
      out.println("arr1 == arr2: "+(arr1==arr4));
      out.println("arr1.equals(arr3): " + Arrays.equals(arr1, arr3));
      out.println("arr1 == arr3: "+(arr1==arr3));
      out.println("arr3.equals(arr4): " + Arrays.equals(arr3, arr4));
      out.println("arr3 == arr4: "+(arr3==arr4));	//new省略了，所以实际上创建了另一个对象
      //输出数组
      out.println("arr1:" + Arrays.toString(arr1)+"\n");
  
      // 动态初始化：只能指定长度，系统根据类型不同设置不同的初始值
      int[] a1 = new int[2];// byte、short、int、long初始值为0
      float[] a2 = new float[2];// float、double初始值为0.0
      char[] a3 = new char[2];// 初始值为'\u0000'
      boolean[] a4 = new boolean[2];// 初始值为false
      out.println("a1[0]:" + a1[0]);
      out.println("a2[0]:" + a2[0]);
      out.println("a3[0]:" + a3[0]);	//显示为空
      out.println("a3[0] == '\u0000':"+(a3[0] == '\u0000'));
      out.println("a4[0]:" + a4[0]);
  }
  ```

- 二维

  ```java
  public static void main(String[] args) {
      //block1
      int [][]a;
      a=new int[4][];
      for(int i=0,len=a.length;i<len;i++) {
          out.println(a[i]);
      }
      a[0]=new int[2];
      a[0][1]=6;
      for(int i=0,len=a[0].length;i<len;i++) {
          out.println(a[0][i]);
      }
      Arrays.sort(a[0]);
      out.println(Arrays.toString(a[0]));
  
      //block2
      String[][] str1= {
          //3, 会报错：cannot convert from int to String[]
          new String[3],
          new String[]{"hello"}
      };
      int [][] arr= {
          new int [] {1,2},
          new int [2]
      };
  }
  ```

  

#### 五、异常处理

- try块与if不同，try后面的{}不能省略，即使只有一行代码。catch也不能省略。

- try里声明的变量是代码块内的局部变量，catch不能访问。

  ```java
  public class myException {
  	public static void main(String[] args) {
  		try {
  			int a=Integer.parseInt(args[0]);
  			int b=Integer.parseInt(args[1]);
  			int c=a/b;
  			out.println("c:"+c);
  			
  		}
  		//catch (RuntimeException re){} //后面会unreachable，应该先小后大
  		catch(IndexOutOfBoundsException ie) {
  			out.println("数组越界，输入的参数不够");
  		}
  		//catch(IndexOutOfBoundsException ie) {// already handled by last
  		//java7之后一个catch可以捕获多种异常
  		catch (NumberFormatException|ArithmeticException ne) {
  			out.println("数字格式异常/算术异常");
  			//捕获多异常时，异常变量默认有final修饰，因此下列错误：
  			//ne =new ArithmeticException("test");
  		}
  		catch(Exception e) {
  			out.println("未知异常");
  			//捕获一种异常时，final修饰
  			e=new Exception("test");
  		}
  		//不管try是否异常、执行了哪一个catch、甚至try/catch里执行了return，finally总会执行
  		finally {
  			out.println("finally总是被执行");
  			//不要在finally里使用return/throw这些强制终止方法的语句;
  		}
  	}
  }
  ```

- throws

  ```java
  public class myThrows {
  	public static void main(String[] args) throws Exception{
  		test();//因为test声明跑出IO异常，因此调用test的方法要么在try-catch中，
  				//要么在另一个声明throws的方法中
  	}
  	public static void test() throws IOException{
  		//FIS的构造器声明抛出IO异常，因此调用FIS的代码在try-catch或throws中
  		FileInputStream fis=new FileInputStream("a.txt");
  	}
  }
  class Sub extends myThrows{
  	//public void test() throws Exception{}//子类不能声明比父类更大的异常	
  }
  ```

  

- throw

- catch+throw

#### 六、Swing

- ![12](https://user-images.githubusercontent.com/49241298/72427675-3f67ac80-37c7-11ea-9657-30cb5f39a94c.png)

  ```java
  //Component类提供了几个常用方法，见P_383
  setLocation(int x,int y);
  setSize(int width,int height);
  setBounds(int x,int y,int w,int h);
  setVisvle(Boolean b);
  Component add(Component comp);
  int getComponentCount();
  Component[] getComponents();
  ```

  

- \1.     Applet是一种特殊的Panel，它是Java Applet程序的最外层容器。

- \1.     panel（含applet）的默认布局是流式布局，window（frame和dialog）是边界布局

- \1.     java Applet 程序必须在浏览器中执行

- 

##### 1. ActionListener:

```java
final String COMMAND_OK = "OK";
final String COMMAND_CANCEL = "Cancel";

JButton okBtn = new JButton("OK");
okBtn.setActionCommand(COMMAND_OK);             // 按钮绑定动作命令

JButton cancelBtn = new JButton("Cancel");
cancelBtn.setActionCommand(COMMAND_CANCEL);     // 按钮绑定动作命令

// 创建一个动作监听器实例
ActionListener listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取事件源，即触发事件的组件（按钮）本身
        // e.getSource();
    
        // 获取动作命令
        String command = e.getActionCommand();
        
        // 根据动作命令区分被点击的按钮
        if (COMMAND_OK.equals(command)) {
            System.out.println("OK 按钮被点击");
            
        } else if (COMMAND_CANCEL.equals(command)) {
            System.out.println("Cancel 按钮被点击");
        }
    }
};

// 设置两个按钮的动作监听器（使用同一个监听器实例）
okBtn.addActionListener(listener);
cancelBtn.addActionListener(listener);
```

##### 2. JButton

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Test {
    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(200, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        // 创建一个按钮
        final JButton btn = new JButton("测试按钮");
        // 添加按钮的点击事件监听器
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取到的事件源就是按钮本身
                // JButton btn = (JButton) e.getSource();
                System.out.println("按钮被点击");
            }
        });
        panel.add(btn);
        jf.setContentPane(panel);
        jf.setVisible(true);
    }
}
```



#### 七、多线程

- 创建线程类

  - 继承Thread类：多个线程不能共享线程类的实例变量

    ```java
    public class FirstThread extends Thread{
    	private int i;
    	public void run() {
    		for(;i<10;i++) {
    			System.out.println(getName()+" "+i);	
    			//System.out.println(this.getName()+""+i);	
    		}
    	}
    	public static void main(String[] args) {
    		for (int i=0;i<10;i++) {
    			System.out.println(Thread.currentThread().getName()+" "+i);
    			if(i==4) {
    				new FirstThread().start();
    				new FirstThread().start();
    			}
    		}
    	}
    }
    ```

    ![13](https://user-images.githubusercontent.com/49241298/72427676-4098d980-37c7-11ea-8593-557851f20737.png)

    

  - 继承Runnable类

- 线程的生命周期

  新状态：线程已被创建但尚未执行（）。

  可执行状态(就绪)：线程可以执行，虽然不一定正在执行。CPU 时间随时可能被分配给该线程，从而使得它执行(调用start方法后)

  死亡状态：正常情况下 run() 返回使得线程死亡。调用 stop()或 destroy() 亦有同样效果，但是不被推荐，前者会产生异常，后者是强制终止，不会释放锁。

  阻塞状态：线程不会被分配 CPU 时间，无法执行。

  运行状态 获得调度，执行线程的run方法

- 启动线程应该用start，而非run；

- 线程死亡

  - 线程结束后就处于死亡状态，结束方式：
    - run()或call()执行完成，线程正常结束
    - 线程抛出未捕获的异常/Error
    - 调用线程的stop()

- 控制线程

  - join
  - 后台
  - sleep
  - 让步yield

#### 八、输入输出

#### 九、JDBC

- JDBC是java 数据库连接API，它能完成3 件事，即与一个数据库建立连接、向数据库发送SQL 语句、处理数据库返回的结果。

#### N+1

- Java 具有简单、面向对象、稳定、与平台无关、解释型、多线程、动态等特点。

- jdb.exe是Java调试器，如果编译器返回程序代码的错误，可以用它对程序进行调试；java.exe运行Java程序；javac.exe编译Java程序

  ```java
  javac Hello.java
  java Hello
  ```

  

- 序列化

  ```java
  public class Employee implements java.io.Serializable
  {
     public String name;
     public String address;
     public transient int SSN;
     public int number;
     public void mailCheck()
     {
        System.out.println("Mailing a check to " + name
                             + " " + address);
     }
  }
  //请注意，一个类的对象要想序列化成功，必须满足两个条件：
  //该类必须实现 java.io.Serializable 接口。
  //该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的。
  
  ```

  