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
    1、性能分析实现
        在MybatisPlusConfigure中performanceInterceptor方法
    2、参数设置

sql注入器
1、创建定义方法的类
2、创建注入器
3、在mapper中加入自定义的方法