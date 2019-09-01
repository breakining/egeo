package com.egeo.back.user.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.DepartmentManage;
import com.egeo.back.user.converter.DepartmentConverter;
import com.egeo.back.user.facade.DepartmentFacade;
import com.egeo.back.user.facade.DepartmentRelationFacade;
import com.egeo.back.user.facade.UserWelfareFacade;
import com.egeo.back.user.model.vo.DepartmentVO;
import com.egeo.basics.user.model.dto.DepartmentDTO;
import com.egeo.basics.user.model.dto.DepartmentRelationDTO;
import com.egeo.basics.user.model.dto.UserWelfareDTO;
import com.egeo.core.Constant.PlatformKeyConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.utils.EmptyUtil;

@Service("department")
public class DepartmentManageImpl implements DepartmentManage {

	@Resource(name = "departmentFacade")
	private DepartmentFacade departmentFacade;

	@Resource(name = "departmentRelationFacade")
	private DepartmentRelationFacade departmentRelationFacade;

	@Resource(name = "userWelfareFacade")
	private UserWelfareFacade userWelfareFacade;

	@Override
	public Map<String, Object> findDepartmentById(DepartmentDTO dto) {
		DepartmentDTO departmentDTO2 = departmentFacade.findDepartmentById(dto);
		DepartmentDTO departmentDTO = getPId(departmentDTO2, departmentDTO2);
		Map<String, Object> map = new HashMap<>();
		map.put("id", departmentDTO.getId());
		map.put("departmentName", departmentDTO.getDepartmentName());
		map.put("pId", departmentDTO.getPidList());
		map.put("sortValue", departmentDTO.getSortValue());
		map.put("companyId", departmentDTO.getCompanyId());
		return map;
	}

	// 循环获取pid
	public DepartmentDTO getPId(DepartmentDTO departmentDTO, DepartmentDTO department) {
		DepartmentRelationDTO relationDTO = new DepartmentRelationDTO();
		relationDTO.setDepartmentId(departmentDTO.getId());
		List<DepartmentRelationDTO> DepartmentRelationList = departmentRelationFacade
				.findDepartmentRelationAll(relationDTO);
		if (EmptyUtil.isNotEmpty(DepartmentRelationList)) {
			if (!DepartmentRelationList.get(0).getPid().equals(0L)) {
				department.getPidList().add(0, DepartmentRelationList.get(0).getPid());
				DepartmentDTO departmentDTO2 = new DepartmentDTO();
				departmentDTO2.setId(DepartmentRelationList.get(0).getPid());
				getPId(departmentDTO2, department);
			}
		}
		return department;
	}

	@Override
	public PageResult<DepartmentDTO> findDepartmentOfPage(DepartmentDTO dto, Pagination page) {
		return departmentFacade.findDepartmentOfPage(dto, page);
	}

	@Override
	public List<DepartmentDTO> findDepartmentAll(DepartmentDTO dto) {
		return departmentFacade.findDepartmentAll(dto);
	}

	@Override
	public Long insertDepartmentWithTx(DepartmentDTO dto) {
		if (EmptyUtil.isEmpty(dto.getDepartmentName())) {
			throw new BusinessException("机构名称不能为空");
		}
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartmentName(dto.getDepartmentName());
		List<DepartmentDTO> list = departmentFacade.findDepartmentAll(departmentDTO);
		if (EmptyUtil.isNotEmpty(list)) {
			throw new BusinessException("机构名称以存在");
		}
		Long departmentId = departmentFacade.insertDepartmentWithTx(dto);
		// 同步保存部门关系表
		DepartmentRelationDTO departmentRelationDTO = new DepartmentRelationDTO();
		// 上级机构为空则设置默认值
		if (EmptyUtil.isEmpty(dto.getpId())) {
			dto.setpId(0L);
		}
		departmentRelationDTO.setPid(dto.getpId());
		departmentRelationDTO.setDepartmentId(departmentId);
		Long departmentRelationId = departmentRelationFacade.insertDepartmentRelationWithTx(departmentRelationDTO);
		// 如果为空则部门关系添加失败、删除之前添加的部门
		if (EmptyUtil.isEmpty(departmentRelationId)) {
			dto.setId(departmentId);
			departmentFacade.deleteDepartmentWithTx(dto);
		}
		return departmentId;
	}

	@Override
	public int updateDepartmentWithTx(DepartmentDTO dto) {
		if (EmptyUtil.isEmpty(dto.getId())) {
			Long departmentId = insertDepartmentWithTx(dto);
			if (EmptyUtil.isEmpty(departmentId)) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (EmptyUtil.isEmpty(dto.getDepartmentName())) {
				throw new BusinessException("机构名称不能为空");
			}
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartmentName(dto.getDepartmentName());
			List<DepartmentDTO> list = departmentFacade.findDepartmentAll(departmentDTO);
			if (EmptyUtil.isEmpty(list)) {
				throw new BusinessException("机构名称以存在");
			}
			// 上级机构为空则设置默认值
			if (EmptyUtil.isEmpty(dto.getpId())) {
				dto.setpId(0L);
			}
			return departmentFacade.updateDepartmentWithTx(dto);
		}

	}

	@Override
	public int deleteDepartmentWithTx(DepartmentDTO dto) {
		// 判断是否有下级机构
		DepartmentRelationDTO departmentRelation = new DepartmentRelationDTO();
		departmentRelation.setPid(dto.getId());
		List<DepartmentRelationDTO> list = departmentRelationFacade.findDepartmentRelationAll(departmentRelation);
		if (EmptyUtil.isNotEmpty(list)) {
			throw new BusinessException("该机构有下级机构，不允许删除");
		}
		UserWelfareDTO userWelfareDTO = new UserWelfareDTO();
		userWelfareDTO.setDepartmentId(dto.getId());
		List<UserWelfareDTO> findUserWelfareAll = userWelfareFacade.findUserWelfareAll(userWelfareDTO);
		if (EmptyUtil.isNotEmpty(findUserWelfareAll)) {
			throw new BusinessException("该机构下面已有人员信息，不可删除");
		}
		int i = departmentFacade.deleteDepartmentWithTx(dto);
		// 删除部门成功后同步删除部门关系表
		if (i != 0) {
			DepartmentRelationDTO departmentRelationDTO = new DepartmentRelationDTO();
			departmentRelationDTO.setDepartmentId(dto.getId());
			int m = departmentRelationFacade.deleteDepartmentRelationByDepartmentIdWithTx(departmentRelationDTO);
		}
		return i;
	}

	/**
	 * 根据公司id递归查询所有部门信息
	 * 
	 * @param vo
	 * @param req
	 * @return
	 */
	@Override
	public List<DepartmentVO> recursionDepartmentAll(DepartmentDTO dto) {
		List<DepartmentDTO> DepartmentList = departmentFacade.recursionDepartmentAll(dto);
		List<DepartmentVO> list = DepartmentConverter.toVO(DepartmentList);
		List<DepartmentVO> sortList = new ArrayList<DepartmentVO>();
		for (DepartmentVO tree : list) {
			for (DepartmentVO t : list) {
				if (t.getpId().equals(tree.getId())) {
					if (tree.getChildren() == null) {
						List<DepartmentVO> myChildrens = new ArrayList<DepartmentVO>();
						myChildrens.add(t);
						tree.setChildren(myChildrens);
					} else {
						tree.getChildren().add(t);
					}
				}
			}
			if (tree.getpId().equals(PlatformKeyConstant.PRODUCT_PLATFORMID)) {
				sortList.add(tree);
			}
		}
		return sortList;
	}

	/**
	 * 根据公司id机构id查询子部门信息
	 * 
	 * @param vo
	 * @param req
	 * @return
	 */
	@Override
	public List<Map<String, Object>> departmentBydepartmentId(Long companyId, Long departmentId) {
		List<Map<String, Object>> list = new ArrayList<>();
		List<DepartmentDTO> departmentList = departmentFacade.departmentBydepartmentId(companyId, departmentId);
		for (DepartmentDTO departmentDTO : departmentList) {
			Map<String, Object> map = new HashMap<>();
			map.put("departmentId", departmentDTO.getId());
			map.put("departmentName", departmentDTO.getDepartmentName());
			map.put("sortValue", departmentDTO.getSortValue());
			map.put("companyId", departmentDTO.getCompanyId());
			list.add(map);
		}
		return list;
	}

}
