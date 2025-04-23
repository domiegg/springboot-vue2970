package com.entity.view;

import com.entity.JiatingyishengOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 医生预约
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiatingyisheng_order")
public class JiatingyishengOrderView extends JiatingyishengOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 预约等级的值
		*/
		private String jiatingyishengOrderValue;



		//级联表 jiatingyisheng
			/**
			* 家庭医生负责人姓名
			*/
			private String jiatingyishengName;
			/**
			* 头像
			*/
			private String jiatingyishengPhoto;
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
				* 科室的值
				*/
				private String keshiValue;
			/**
			* 假删
			*/
			private Integer jiatingyishengDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public JiatingyishengOrderView() {

	}

	public JiatingyishengOrderView(JiatingyishengOrderEntity jiatingyishengOrderEntity) {
		try {
			BeanUtils.copyProperties(this, jiatingyishengOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 预约等级的值
			*/
			public String getJiatingyishengOrderValue() {
				return jiatingyishengOrderValue;
			}
			/**
			* 设置： 预约等级的值
			*/
			public void setJiatingyishengOrderValue(String jiatingyishengOrderValue) {
				this.jiatingyishengOrderValue = jiatingyishengOrderValue;
			}











				//级联表的get和set jiatingyisheng

					/**
					* 获取： 家庭医生负责人姓名
					*/
					public String getJiatingyishengName() {
						return jiatingyishengName;
					}
					/**
					* 设置： 家庭医生负责人姓名
					*/
					public void setJiatingyishengName(String jiatingyishengName) {
						this.jiatingyishengName = jiatingyishengName;
					}

					/**
					* 获取： 头像
					*/
					public String getJiatingyishengPhoto() {
						return jiatingyishengPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setJiatingyishengPhoto(String jiatingyishengPhoto) {
						this.jiatingyishengPhoto = jiatingyishengPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getJiatingyishengPhone() {
						return jiatingyishengPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setJiatingyishengPhone(String jiatingyishengPhone) {
						this.jiatingyishengPhone = jiatingyishengPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getJiatingyishengEmail() {
						return jiatingyishengEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setJiatingyishengEmail(String jiatingyishengEmail) {
						this.jiatingyishengEmail = jiatingyishengEmail;
					}

					/**
					* 获取： 科室
					*/
					public Integer getKeshiTypes() {
						return keshiTypes;
					}
					/**
					* 设置： 科室
					*/
					public void setKeshiTypes(Integer keshiTypes) {
						this.keshiTypes = keshiTypes;
					}


						/**
						* 获取： 科室的值
						*/
						public String getKeshiValue() {
							return keshiValue;
						}
						/**
						* 设置： 科室的值
						*/
						public void setKeshiValue(String keshiValue) {
							this.keshiValue = keshiValue;
						}

					/**
					* 获取： 假删
					*/
					public Integer getJiatingyishengDelete() {
						return jiatingyishengDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setJiatingyishengDelete(Integer jiatingyishengDelete) {
						this.jiatingyishengDelete = jiatingyishengDelete;
					}











				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}




}
