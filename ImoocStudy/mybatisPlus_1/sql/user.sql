#创建数据库
#使用查看全文
create table user (  id BIGINT(20) PRIMARY key not null comment '主键',
name varchar(30) default null comment '姓名',
age int(11) default null comment '年龄',
email varchar(50) default null comment '邮箱',
manager_id BIGINT(20) default null comment '直属上级id',
create_time DATETIME default null comment '创建时间',
CONSTRAINT manager_fk foreign key (manager_id)
REFERENCES user (id)) ENGINE=INNODB CHARSET=UTF8;

#数据初始化
INSERT INTO user (id,name,age,email,manager_id,create_time)
VALUES
(1087982257332887553, '大boss', 40, 'boss@baomidou.com', NULL,'2019-01-11 14:20:20'),
(1088248166370832385,'王天风',25,'wtf@baomidou.com', 1087982257332887553,'2019-02-05 11:12:22'),
(1088250446457389058,'李艺伟',28,'lyw@baomidou.com', 1088248166370832385,'2019-02-14 08:31:16'),
(1094590409767661570,'张雨琪',31,'zyq@baomidou.com', 1088248166370832385,'2019-01-14 09:15:15'),
(1094592041087729666,'刘红雨',32,'lhm@baomidou.com', 1088248166370832385,'2019-01-14 09:48:16');