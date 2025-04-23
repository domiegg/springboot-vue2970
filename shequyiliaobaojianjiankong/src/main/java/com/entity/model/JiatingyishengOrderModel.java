package com.entity.model;

import com.entity.JiatingyishengOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医生预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiatingyishengOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 医生
     */
    private Integer jiatingyishengId;


    /**
     * 预约等级
     */
    private Integer jiatingyishengOrderTypes;


    /**
     * 预约详情
     */
    private String jiatingyishengOrderText;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：医生
	 */
    public Integer getJiatingyishengId() {
        return jiatingyishengId;
    }


    /**
	 * 设置：医生
	 */
    public void setJiatingyishengId(Integer jiatingyishengId) {
        this.jiatingyishengId = jiatingyishengId;
    }
    /**
	 * 获取：预约等级
	 */
    public Integer getJiatingyishengOrderTypes() {
        return jiatingyishengOrderTypes;
    }


    /**
	 * 设置：预约等级
	 */
    public void setJiatingyishengOrderTypes(Integer jiatingyishengOrderTypes) {
        this.jiatingyishengOrderTypes = jiatingyishengOrderTypes;
    }
    /**
	 * 获取：预约详情
	 */
    public String getJiatingyishengOrderText() {
        return jiatingyishengOrderText;
    }


    /**
	 * 设置：预约详情
	 */
    public void setJiatingyishengOrderText(String jiatingyishengOrderText) {
        this.jiatingyishengOrderText = jiatingyishengOrderText;
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
