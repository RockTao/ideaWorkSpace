package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;


/**
 *
 * 解析的页面分类需要存入数据库
 */
@Data
public class parseHtml  implements Serializable {
    private int id;//编好号
    private  String resource;//来源
    private  String title;//标题
    private  String url;//链接
    private  String category;//自定义的分类
    private Date createtime;//创建时间
}
