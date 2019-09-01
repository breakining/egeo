package com.egeo.basics.secondhand.condition;

import com.egeo.basics.secondhand.po.CommodityPO;

/**
 * 
 * @author min
 * @date 2017-11-22 15:10:30
 */
public class CommodityCondition extends CommodityPO {
	private static final long serialVersionUID = 1L;
	/**
	 * 二手商品封面图片
	 */
	private String pictureUrl;

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	

}
	