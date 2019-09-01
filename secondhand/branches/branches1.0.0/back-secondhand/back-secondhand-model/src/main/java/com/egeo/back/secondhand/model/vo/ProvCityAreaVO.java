package com.egeo.back.secondhand.model.vo;

import java.io.Serializable;

/**
 * 
 * @author min
 * @date 2017-11-29 15:37:10
 */
public class ProvCityAreaVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 地址名称
	 */
	private String areaname;
	/**
	 * 父类id
	 */
	private Long parentno;
	/**
	 * 邮编
	 */
	private String areacode;
	/**
	 * 类型：1.省、2.市、3.区
	 */
	private Integer arealevel;
	/**
	 * 类型
	 */
	private String typename;

	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id 
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 地址名称
	 * @return 地址名称
	 */
	public String getAreaname() {
		return areaname;
	}

	/**
	 * 地址名称
	 * @param areaname 地址名称
	 */
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}	
	/**
	 * 父类id
	 * @return 父类id
	 */
	public Long getParentno() {
		return parentno;
	}

	/**
	 * 父类id
	 * @param parentno 父类id
	 */
	public void setParentno(Long parentno) {
		this.parentno = parentno;
	}	
	/**
	 * 邮编
	 * @return 邮编
	 */
	public String getAreacode() {
		return areacode;
	}

	/**
	 * 邮编
	 * @param areacode 邮编
	 */
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}	
	/**
	 * 类型：1.省、2.市、3.区
	 * @return 类型：1.省、2.市、3.区
	 */
	public Integer getArealevel() {
		return arealevel;
	}

	/**
	 * 类型：1.省、2.市、3.区
	 * @param arealevel 类型：1.省、2.市、3.区
	 */
	public void setArealevel(Integer arealevel) {
		this.arealevel = arealevel;
	}	
	/**
	 * 类型
	 * @return 类型
	 */
	public String getTypename() {
		return typename;
	}

	/**
	 * 类型
	 * @param typename 类型
	 */
	public void setTypename(String typename) {
		this.typename = typename;
	}	
}
	