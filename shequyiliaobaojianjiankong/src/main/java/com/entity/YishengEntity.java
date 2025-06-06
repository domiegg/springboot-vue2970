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
 * 医生
 *
 * @author 
 * @email
 */
@TableName("yisheng")
public class YishengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YishengEntity() {

	}

	public YishengEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 医生姓名
     */
    @TableField(value = "yisheng_name")

    private String yishengName;


    /**
     * 头像
     */
    @TableField(value = "yisheng_photo")

    private String yishengPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 联系方式
     */
    @TableField(value = "yisheng_phone")

    private String yishengPhone;


    /**
     * 邮箱
     */
    @TableField(value = "yisheng_email")

    private String yishengEmail;


    /**
     * 科室
     */
    @TableField(value = "keshi_types")

    private Integer keshiTypes;


    /**
     * 医生简介
     */
    @TableField(value = "yisheng_content")

    private String yishengContent;


    /**
     * 假删
     */
    @TableField(value = "yisheng_delete")

    private Integer yishengDelete;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：医生姓名
	 */
    public String getYishengName() {
        return yishengName;
    }
    /**
	 * 获取：医生姓名
	 */

    public void setYishengName(String yishengName) {
        this.yishengName = yishengName;
    }
    /**
	 * 设置：头像
	 */
    public String getYishengPhoto() {
        return yishengPhoto;
    }
    /**
	 * 获取：头像
	 */

    public void setYishengPhoto(String yishengPhoto) {
        this.yishengPhoto = yishengPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getYishengPhone() {
        return yishengPhone;
    }
    /**
	 * 获取：联系方式
	 */

    public void setYishengPhone(String yishengPhone) {
        this.yishengPhone = yishengPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getYishengEmail() {
        return yishengEmail;
    }
    /**
	 * 获取：邮箱
	 */

    public void setYishengEmail(String yishengEmail) {
        this.yishengEmail = yishengEmail;
    }
    /**
	 * 设置：科室
	 */
    public Integer getKeshiTypes() {
        return keshiTypes;
    }
    /**
	 * 获取：科室
	 */

    public void setKeshiTypes(Integer keshiTypes) {
        this.keshiTypes = keshiTypes;
    }
    /**
	 * 设置：医生简介
	 */
    public String getYishengContent() {
        return yishengContent;
    }
    /**
	 * 获取：医生简介
	 */

    public void setYishengContent(String yishengContent) {
        this.yishengContent = yishengContent;
    }
    /**
	 * 设置：假删
	 */
    public Integer getYishengDelete() {
        return yishengDelete;
    }
    /**
	 * 获取：假删
	 */

    public void setYishengDelete(Integer yishengDelete) {
        this.yishengDelete = yishengDelete;
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
        return "Yisheng{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", yishengName=" + yishengName +
            ", yishengPhoto=" + yishengPhoto +
            ", sexTypes=" + sexTypes +
            ", yishengPhone=" + yishengPhone +
            ", yishengEmail=" + yishengEmail +
            ", keshiTypes=" + keshiTypes +
            ", yishengContent=" + yishengContent +
            ", yishengDelete=" + yishengDelete +
            ", createTime=" + createTime +
        "}";
    }
}
