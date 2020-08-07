package com.tly.mango.entity;
import lombok.Data;

@Data
public class SysLoginLog extends BaseModel {

    private String userName;

    private String status;

    private String ip;



}