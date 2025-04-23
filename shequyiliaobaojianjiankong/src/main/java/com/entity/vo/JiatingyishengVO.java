package com.entity.vo;

import com.entity.JiatingyishengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 家庭医生
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiatingyisheng")
public class JiatingyishengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 家庭医生负责人姓名
     */

    @TableField(value = "jiatingyisheng_name")
    private String jiatingyishengName;


    /**
     * 头像
     */

    @TableField(value = "jiatingyisheng_photo")
    private String jiatingyishengPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 联系方式
     */

    @TableField(value = "jiatingyisheng_phone")
    private String jiatingyishengPhone;


    /**
     * 邮箱
     */

    @TableField(value = "jiatingyisheng_email")
    private String jiatingyishengEmail;


    /**
     * 科室
     */

    @TableField(value = "keshi_types")
    private Integer keshiTypes;


    /**
     * 假删
     */

    @TableField(value = "jiatingyisheng_delete")
    private Integer jiatingyishengDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：家庭医生负责人姓名
	 */
    public String getJiatingyishengName() {
        return jiatingyishengName;
    }


    /**
	 * 获取：家庭医生负责人姓名
	 */

    public void setJiatingyishengName(String jiatingyishengName) {
        this.jiatingyishengName = jiatingyishengName;
    }
    /**
	 * 设置：头像
	 */
    public String getJiatingyishengPhoto() {
        return jiatingyishengPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setJiatingyishengPhoto(String jiatingyishengPhoto) {
        this.jiatingyishengPhoto = jiatingyishengPhoto;
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
    public String getJiatingyishengPhone() {
        return jiatingyishengPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setJiatingyishengPhone(String jiatingyishengPhone) {
        this.jiatingyishengPhone = jiatingyishengPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getJiatingyishengEmail() {
        return jiatingyishengEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setJiatingyishengEmail(String jiatingyishengEmail) {
        this.jiatingyishengEmail = jiatingyishengEmail;
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
	 * 设置：假删
	 */
    public Integer getJiatingyishengDelete() {
        return jiatingyishengDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setJiatingyishengDelete(Integer jiatingyishengDelete) {
        this.jiatingyishengDelete = jiatingyishengDelete;
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

}
