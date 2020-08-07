package com.tly.mango.entity;
import lombok.Data;

@Data
public class SysUserRole extends BaseModel {

    private Long userId;

    private Long roleId;


}