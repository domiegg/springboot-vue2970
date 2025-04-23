package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 医生预约
 *
 * @author 
 * @email
 */
@TableName("jiatingyisheng_order")
public class JiatingyishengOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiatingyishengOrderEntity() {

	}

	public JiatingyishengOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 医生
     */
    @TableField(value = "jiatingyisheng_id")

    private Integer jiatingyishengId;


    /**
     * 预约等级
     */
    @TableField(value = "jiatingyisheng_order_types")

    private Integer jiatingyishengOrderTypes;


    /**
     * 预约详情
     */
    @TableField(value = "jiatingyisheng_order_text")

    private String jiatingyishengOrderText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：医生
	 */
    public Integer getJiatingyishengId() {
        return jiatingyishengId;
    }
    /**
	 * 获取：医生
	 */

    public void setJiatingyishengId(Integer jiatingyishengId) {
        this.jiatingyishengId = jiatingyishengId;
    }
    /**
	 * 设置：预约等级
	 */
    public Integer getJiatingyishengOrderTypes() {
        return jiatingyishengOrderTypes;
    }
    /**
	 * 获取：预约等级
	 */

    public void setJiatingyishengOrderTypes(Integer jiatingyishengOrderTypes) {
        this.jiatingyishengOrderTypes = jiatingyishengOrderTypes;
    }
    /**
	 * 设置：预约详情
	 */
    public String getJiatingyishengOrderText() {
        return jiatingyishengOrderText;
    }
    /**
	 * 获取：预约详情
	 */

    public void setJiatingyishengOrderText(String jiatingyishengOrderText) {
        this.jiatingyishengOrderText = jiatingyishengOrderText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "JiatingyishengOrder{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", jiatingyishengId=" + jiatingyishengId +
            ", jiatingyishengOrderTypes=" + jiatingyishengOrderTypes +
            ", jiatingyishengOrderText=" + jiatingyishengOrderText +
            ", createTime=" + createTime +
        "}";
    }
}
