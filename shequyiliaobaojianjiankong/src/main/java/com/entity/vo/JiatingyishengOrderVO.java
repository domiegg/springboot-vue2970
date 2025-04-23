package com.entity.vo;

import com.entity.JiatingyishengOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医生预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiatingyisheng_order")
public class JiatingyishengOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
