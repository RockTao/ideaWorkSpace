package com.mp.entiry;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

//  对应的test类为insertTest方法
//@Data
//@TableName("mp_user")
//public class User {
//    @TableId// mybatisPlus默认的住建是ID， 用tableId指定住建
//    private long userId; //住建
//    @TableField("name")// 指定数据的对应的字段
//    private String realName;//姓名
//    private int age;//年龄
//    private String email;//邮箱
//    private Long managerId;//上级id
//    private LocalDateTime createTime; // 创建时间\
//    // 排除非表字段
//// 1、transient   2、static 需要get/set方法   3、 @TableField(exist = false  false 表示数据库中不存在  true表示数据库存在
//    @TableField(exist = false)
//    private static   String remark; // 备注
//
////    public static String getRemark() {
////        return remark;
////    }
////
////    public static void setRemark(String remark) {
////        User.remark = remark;
////    }
//}


@Data
public class User { //} extends Model<User> {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ID_WORKER_STR)
    private String id; //住建
    //    @TableField(condition = SqlCondition.LIKE,strategy = FieldStrategy.NOT_EMPTY)     //strategy = FieldStrategy.NOT_EMPTY 为空值时是否忽略处理    // 局部策略优于全局策略
    private String name;//姓名
    @TableField(condition = "%s&lt;#{%s}")
    private int age;//年龄
    private String email;//邮箱
    private Long managerId;//上级id
    private LocalDateTime createTime; // 创建时间
}
