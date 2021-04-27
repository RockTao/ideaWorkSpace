2、逻辑删除
    1、配置文件添加mybatis-plus.global-config.db-config.logic-delete-value=1 
    2、配置对应的bean，参考MybatisPlusConfigure   第三十三行
    3、对应的实体中添加注解@TableLogic
 自动填充功能
    在对应的实体类中添加对应的注解     @TableField(fill = FieldFill.INSERT) 
    自动填充功能扩充    MyMetaObjectHandler
乐观锁插件
    乐观锁介绍
        1、取出记录时，获取当前的version
        2、更新时，带上这个version
        3、版本正确更新成功，错误更新失败
    乐观锁使用
        1、MybatisPlusConfigure 开启optimisticLockerInterceptor 
        2、实体类中添加注解@Version
    注意
        @Version注意的数据类型    请看 官网数据 
        
性能分析插件
     pom需要下载插件p6spy
    1、性能分析实现
        在MybatisPlusConfigure中performanceInterceptor方法
    2、参数设置
多租户sql解析器
    1、数据隔离方案
        单用户，单数据库
        共享数据库，独立schema（多个用户）
        共享数据库，共享scheam共享数据表
    2、多租户实现
        依赖分页插件

动态表明sql解析器
    选装件