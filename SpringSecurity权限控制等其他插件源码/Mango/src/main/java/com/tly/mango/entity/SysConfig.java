package com.tly.mango.entity;
import lombok.Data;

@Data
public class SysConfig extends BaseModel {

    private String value;

    private String label;

    private String type;

    private String description;

    private Long sort;

    private String remarks;

    private Byte delFlag;


}