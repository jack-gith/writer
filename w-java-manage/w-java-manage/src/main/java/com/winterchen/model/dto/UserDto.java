package com.winterchen.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String code;

    private String name;

    private String team;
    private String orderNumber;
}
