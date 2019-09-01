package com.egeo.basics.secondhand.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-11-15 10:02:29
 */
public class CommodityDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;	

	/**
	 * 商品标题
	 */
	private String commodityName;

	/**
	 * 商品类型：1 转让、2 求购
	 */
	private Integer commodityType;	

	/**
	 * 商品描述
	 */
	private String commodityContent;	

	/**
	 * 1：全新、2：九成新、3：八成新、4：七成新、5：六成新、6：五成新及以下
	 */
	private Integer degree;	

	/**
	 * 价格
	 */
	private BigDecimal price;	
	
	/**
	 * 价格类型 0:面议、1：自定义
	 */
	private Integer priceType;	
	/**
	 * 联系方式
	 */
	private String contactWay;	
	/**
	 * 二手商品状态：0、下架 1、上架
	 */
	private Integer status;	

	/**
	 * 逻辑删除字段 0 正常 1 已删除
	 */
	private Integer isDeleted;

	/**
	 * 收货人国家ID
	 */
	private Long goodReceiverCountryId;	

	/**
	 * 收货人国家
	 */
	private String goodReceiverCountry;	

	/**
	 * 收货人省份ID
	 */
	private Long goodReceiverProvinceId;	

	/**
	 * 收货人省份
	 */
	private String goodReceiverProvince;	

	/**
	 * 收货人城市ID
	 */
	private Long goodReceiverCityId;	

	/**
	 * 收货人城市
	 */
	private String goodReceiverCity;	

	/**
	 * 收货人地区ID
	 */
	private Long goodReceiverCountyId;	

	/**
	 * 收货人地区
	 */
	private String goodReceiverCounty;	

	/**
	 * 收货人四级区域ID
	 */
	private Long goodReceiverAreaId;	

	/**
	 * 收货人四级区域
	 */
	private String goodReceiverArea;	

	/**
	 * 收货人地址
	 */
	private String goodReceiverAddress;	

	/**
	 * 创建时间:创建记录时数据库会自动set值
	 */
	private Date createTime;	

	/**
	 * 修改时间:更新时数据库会自动set值
	 */
	private Date updateTime;	

	/**
	 * 平台id
	 */
	private Long platformId;	
	
	/**
	 * 商品第一张图片（ps：封面图片）
	 */
	private String pictureUrl;

	public Long getId() {
		return id;
	}

	/**
	 * 主键
	 * @param id 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 用户id
	 * @return 用户id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 用户id
	 * @param userId 用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 商品标题
	 * @return 商品标题
	 */
	public String getCommodityName() {
		return commodityName;
	}

	/**
	 * 商品标题
	 * @param commodityName 商品标题
	 */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	/**
	 * 商品类型：1 转让、2 求购
	 * @return 商品类型：1 转让、2 求购
	 */
	public Integer getCommodityType() {
		return commodityType;
	}

	/**
	 * 商品类型：1 转让、2 求购
	 * @param commodityType 商品类型：1 转让、2 求购
	 */
	public void setCommodityType(Integer commodityType) {
		this.commodityType = commodityType;
	}
	/**
	 * 商品描述
	 * @return 商品描述
	 */
	public String getCommodityContent() {
		return commodityContent;
	}

	/**
	 * 商品描述
	 * @param commodityContent 商品描述
	 */
	public void setCommodityContent(String commodityContent) {
		this.commodityContent = commodityContent;
	}
	/**
	 * 1：全新、2：九成新、3：八成新、4：七成新、5：六成新、6：五成新及以下
	 * @return 1：全新、2：九成新、3：八成新、4：七成新、5：六成新、6：五成新及以下
	 */
	public Integer getDegree() {
		return degree;
	}

	/**
	 * 1：全新、2：九成新、3：八成新、4：七成新、5：六成新、6：五成新及以下
	 * @param degree 1：全新、2：九成新、3：八成新、4：七成新、5：六成新、6：五成新及以下
	 */
	public void setDegree(Integer degree) {
		this.degree = degree;
	}
	/**
	 * 价格
	 * @return 价格
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 价格
	 * @param price 价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 收货人国家ID
	 * @return 收货人国家ID
	 */
	public Long getGoodReceiverCountryId() {
		return goodReceiverCountryId;
	}

	/**
	 * 收货人国家ID
	 * @param goodReceiverCountryId 收货人国家ID
	 */
	public void setGoodReceiverCountryId(Long goodReceiverCountryId) {
		this.goodReceiverCountryId = goodReceiverCountryId;
	}
	/**
	 * 收货人国家
	 * @return 收货人国家
	 */
	public String getGoodReceiverCountry() {
		return goodReceiverCountry;
	}

	/**
	 * 收货人国家
	 * @param goodReceiverCountry 收货人国家
	 */
	public void setGoodReceiverCountry(String goodReceiverCountry) {
		this.goodReceiverCountry = goodReceiverCountry;
	}
	/**
	 * 收货人省份ID
	 * @return 收货人省份ID
	 */
	public Long getGoodReceiverProvinceId() {
		return goodReceiverProvinceId;
	}

	/**
	 * 收货人省份ID
	 * @param goodReceiverProvinceId 收货人省份ID
	 */
	public void setGoodReceiverProvinceId(Long goodReceiverProvinceId) {
		this.goodReceiverProvinceId = goodReceiverProvinceId;
	}
	/**
	 * 收货人省份
	 * @return 收货人省份
	 */
	public String getGoodReceiverProvince() {
		return goodReceiverProvince;
	}

	/**
	 * 收货人省份
	 * @param goodReceiverProvince 收货人省份
	 */
	public void setGoodReceiverProvince(String goodReceiverProvince) {
		this.goodReceiverProvince = goodReceiverProvince;
	}
	/**
	 * 收货人城市ID
	 * @return 收货人城市ID
	 */
	public Long getGoodReceiverCityId() {
		return goodReceiverCityId;
	}

	/**
	 * 收货人城市ID
	 * @param goodReceiverCityId 收货人城市ID
	 */
	public void setGoodReceiverCityId(Long goodReceiverCityId) {
		this.goodReceiverCityId = goodReceiverCityId;
	}
	/**
	 * 收货人城市
	 * @return 收货人城市
	 */
	public String getGoodReceiverCity() {
		return goodReceiverCity;
	}

	/**
	 * 收货人城市
	 * @param goodReceiverCity 收货人城市
	 */
	public void setGoodReceiverCity(String goodReceiverCity) {
		this.goodReceiverCity = goodReceiverCity;
	}
	/**
	 * 收货人地区ID
	 * @return 收货人地区ID
	 */
	public Long getGoodReceiverCountyId() {
		return goodReceiverCountyId;
	}

	/**
	 * 收货人地区ID
	 * @param goodReceiverCountyId 收货人地区ID
	 */
	public void setGoodReceiverCountyId(Long goodReceiverCountyId) {
		this.goodReceiverCountyId = goodReceiverCountyId;
	}
	/**
	 * 收货人地区
	 * @return 收货人地区
	 */
	public String getGoodReceiverCounty() {
		return goodReceiverCounty;
	}

	/**
	 * 收货人地区
	 * @param goodReceiverCounty 收货人地区
	 */
	public void setGoodReceiverCounty(String goodReceiverCounty) {
		this.goodReceiverCounty = goodReceiverCounty;
	}
	/**
	 * 收货人四级区域ID
	 * @return 收货人四级区域ID
	 */
	public Long getGoodReceiverAreaId() {
		return goodReceiverAreaId;
	}

	/**
	 * 收货人四级区域ID
	 * @param goodReceiverAreaId 收货人四级区域ID
	 */
	public void setGoodReceiverAreaId(Long goodReceiverAreaId) {
		this.goodReceiverAreaId = goodReceiverAreaId;
	}
	/**
	 * 收货人四级区域
	 * @return 收货人四级区域
	 */
	public String getGoodReceiverArea() {
		return goodReceiverArea;
	}

	/**
	 * 收货人四级区域
	 * @param goodReceiverArea 收货人四级区域
	 */
	public void setGoodReceiverArea(String goodReceiverArea) {
		this.goodReceiverArea = goodReceiverArea;
	}
	/**
	 * 收货人地址
	 * @return 收货人地址
	 */
	public String getGoodReceiverAddress() {
		return goodReceiverAddress;
	}

	/**
	 * 收货人地址
	 * @param goodReceiverAddress 收货人地址
	 */
	public void setGoodReceiverAddress(String goodReceiverAddress) {
		this.goodReceiverAddress = goodReceiverAddress;
	}
	/**
	 * 创建时间:创建记录时数据库会自动set值
	 * @return 创建时间:创建记录时数据库会自动set值
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间:创建记录时数据库会自动set值
	 * @param createTime 创建时间:创建记录时数据库会自动set值
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 修改时间:更新时数据库会自动set值
	 * @return 修改时间:更新时数据库会自动set值
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 修改时间:更新时数据库会自动set值
	 * @param updateTime 修改时间:更新时数据库会自动set值
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 平台id
	 * @return 平台id
	 */
	public Long getPlatformId() {
		return platformId;
	}

	/**
	 * 平台id
	 * @param platformId 平台id
	 */
	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Integer getPriceType() {
		return priceType;
	}

	public void setPriceType(Integer priceType) {
		this.priceType = priceType;
	}

	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
	