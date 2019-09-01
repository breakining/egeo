package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.back.user.model.vo.CompanyVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author min
 * @date 2017-12-05 12:05:16
 */
public class CompanyConverter {
	
	public static CompanyDTO toDTO(CompanyVO src) {
		if (src == null)
		return null;	
		CompanyDTO tar = new CompanyDTO();
		tar.setId(src.getId());
		tar.setCompanyName(src.getCompanyName());	
		tar.setCompanyCelebrateTime(src.getCompanyCelebrateTime());	
		tar.setCompanyMailSuffix(src.getCompanyMailSuffix());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setPlatformId(src.getPlatformId());	
		return tar;
	}

	public static CompanyVO toVO(CompanyDTO src) {
		if (src == null)
		return null;	
		CompanyVO tar = new CompanyVO();
		tar.setId(src.getId());
		tar.setCompanyName(src.getCompanyName());	
		tar.setCompanyCelebrateTime(src.getCompanyCelebrateTime());	
		tar.setCompanyMailSuffix(src.getCompanyMailSuffix());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setPlatformId(src.getPlatformId());	
		return tar;
	}

	public static List<CompanyDTO> toDTO(List<CompanyVO> srcs) {
		if (srcs == null)
			return null;
		List<CompanyDTO> list = new ArrayList<CompanyDTO>();
		for (CompanyVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<CompanyVO> toVO(List<CompanyDTO> srcs) {
		if (srcs == null)
			return null;
		List<CompanyVO> list = new ArrayList<CompanyVO>();
		for (CompanyDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	