package com.egeo.basics.secondhand.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.secondhand.condition.CommodityCondition;
import com.egeo.basics.secondhand.po.CommodityPO;
import com.egeo.core.orm.BaseReadDAO;
import com.egeo.core.orm.Pagination;

public interface CommodityReadDAO extends BaseReadDAO<CommodityPO>{
	/**
	 * 查询所有二手商品总数
	 * @param page
	 * @return
	 */
	int countOfPageApp(@Param("po")CommodityPO po);
	/**
	 * 分页查询所有二手商品
	 * @param page
	 * @return
	 */
	List<CommodityCondition> commodityOfPageAppById(@Param("po") CommodityPO po, @Param("page") Pagination page);
}
	