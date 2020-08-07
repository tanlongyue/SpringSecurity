package com.tly.mango.entity;

import java.util.List;
import lombok.Data;

@Data
public class SysDept extends BaseModel {

    private String name;
    
    private Long parentId;

    private Integer orderNum;

    private Byte delFlag;
    // 非数据库字段
    private List<SysDept> children;
    // 非数据库字段
    private String parentName;
    // 非数据库字段
    private Integer level;

    
}