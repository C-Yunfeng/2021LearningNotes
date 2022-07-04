## 202204

- Spring体系架构

- Spring程序开发

  ![](https://blogjallery.oss-cn-beijing.aliyuncs.com/img/20211230225145.png)




## 202207

### 01

#### Spring配置文件

- attribute
  - **id**
  - **class**
  - scope
  - **property**

### 02

#### Spring配置文件

- life_cycle
  - init_method
  - destroy_method
- initialize_method
  - deafult
  - StaticFactory
  - DynamicFactory
- DependencyInjection
  - Ways
    - **Property**
    - ConstructorArg[第三方框架整合]
  - DataType
    - basic
    - **point**
    - array
      - map: key, value-ref
      - properties
- 分模块开发
  - import resource

#### SpringAPI

- 加载IOC容器

  - ClassPathXmlAC

  - FileSystemXmlAC
    - 不常用

  - AnnotationConfigAC

#### Spring配置数据源

- DataSource
  - bean
    - driver
    - jdbc
    - user
    - password
  - properties
    - context
    - location
    - system-properties-mode



#### Spring注解开发

- 定义bean

  - @Component

    > 让实体类变成Bean！

  - context:component-scan

    > 在xml文件配置了<context:component-scan>标签后，spring容器可以自动去扫描base-pack所指定的包或其子包下面的java类文件，如果扫描到有@Component、@Controller、@Service 、@Repository等注解修饰的Java类，则将这些类注册为spring容器中的bean。

  - @Controller

  - @Service

  - @Repository

  

#### Spring纯注解开发

- @Configuration
- @ComponentScan("com.itheima")
- AnnotationConfigApplicationContext new(SpringConfig.class)

### 03

#### bean管理

- LifeCycle

  - @Scope

  - @PostConstruct

  - @PreDestroy

- DI

  - @Autowired

  - @Qualifier

  - @Value

  - @Property

- 使用独立的配置类管理第三方bean

  - @ComponentScan()+@Configuration

    > 不推荐

  - @Import(xxx.class)

  - @Bean

    > 引用型依赖注入

#### 总结

![image-20220703222006262](assets/JavaSSM/image-20220703222006262.png)











 
