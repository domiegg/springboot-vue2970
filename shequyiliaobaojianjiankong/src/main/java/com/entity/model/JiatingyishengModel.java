package com.entity.model;

import com.entity.JiatingyishengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 家庭医生
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiatingyishengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 家庭医生负责人姓名
     */
    private String jiatingyishengName;


    /**
     * 头像
     */
    private String jiatingyishengPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 联系方式
     */
    private String jiatingyishengPhone;


    /**
     * 邮箱
     */
    private String jiatingyishengEmail;


    /**
     * 科室
     */
    private Integer keshiTypes;


    /**
     * 假删
     */
    private Integer jiatingyishengDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：家庭医生负责人姓名
	 */
    public String getJiatingyishengName() {
        return jiatingyishengName;
    }


    /**
	 * 设置：家庭医生负责人姓名
	 */
    public void setJiatingyishengName(String jiatingyishengName) {
        this.jiatingyishengName = jiatingyishengName;
    }
    /**
	 * 获取：头像
	 */
    public String getJiatingyishengPhoto() {
        return jiatingyishengPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setJiatingyishengPhoto(String jiatingyishengPhoto) {
        this.jiatingyishengPhoto = jiatingyishengPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getJiatingyishengPhone() {
        return jiatingyishengPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setJiatingyishengPhone(String jiatingyishengPhone) {
        this.jiatingyishengPhone = jiatingyishengPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getJiatingyishengEmail() {
        return jiatingyishengEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setJiatingyishengEmail(String jiatingyishengEmail) {
        this.jiatingyishengEmail = jiatingyishengEmail;
    }
    /**
	 * 获取：科室
	 */
    public Integer getKeshiTypes() {
        return keshiTypes;
    }


    /**
	 * 设置：科室
	 */
    public void setKeshiTypes(Integer keshiTypes) {
        this.keshiTypes = keshiTypes;
    }
    /**
	 * 获取：假删
	 */
    public Integer getJiatingyishengDelete() {
        return jiatingyishengDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setJiatingyishengDelete(Integer jiatingyishengDelete) {
        this.jiatingyishengDelete = jiatingyishengDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
