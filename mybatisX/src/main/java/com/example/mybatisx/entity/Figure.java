package com.example.mybatisx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName figure
 */
@TableName(value ="figure")
@Data
public class Figure implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Object id;

    /**
     * 
     */
    @TableField(value = "height")
    private Double height;

    /**
     * 
     */
    @TableField(value = "weight")
    private Double weight;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}