package com.mp.entiry;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user_heigh")
public class User {
    private Long id; //住建
    private String name;//姓名
    private Integer age;//年龄
    private String email;//邮箱
    private Long managerId;//上级id
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 创建时间
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime; //修改时间
    @Version //乐观锁使用的
    private Integer version; //版本
    @TableLogic //
    @TableField(select = false)  //查询的时候不显示
    private Integer deleted; //逻辑删除标识(0.未删除,1.已删除)',
}
