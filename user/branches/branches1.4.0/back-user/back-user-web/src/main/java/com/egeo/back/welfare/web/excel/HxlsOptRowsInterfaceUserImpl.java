package com.egeo.back.welfare.web.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.egeo.back.user.business.DepartmentManage;
import com.egeo.back.user.business.UserExtendManage;
import com.egeo.back.user.facade.UserFacade;
import com.egeo.basics.user.model.dto.DepartmentDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.utils.EmptyUtil;
import com.egeo.utils.excel.HxlsOptRowsInterface;
import com.egeo.utils.str.StringUtils;

/**
 * 测试导入数据接口
 * @author Thinkpad
 *
 */
public class HxlsOptRowsInterfaceUserImpl implements HxlsOptRowsInterface {

	@Resource(name = "userExtend")
	private UserExtendManage userExtendManage;
	
	@Resource(name="department")
	private DepartmentManage departmentManage;
	
	@Resource(name="userFacade")
	private UserFacade userFacade;
	
	private Long companyId;
	
	@Override
	public String optRows(int sheetIndex, int curRow, List<String> rowlist)
			throws Exception {
			SimpleDateFormat sdf =   new SimpleDateFormat( "yyyyMMdd" );
			String name = rowlist.get(0);
			String sex = rowlist.get(1);
			if(EmptyUtil.isNotEmpty(sex)){
				if(!StringUtils.isNotFigure(sex)){
					return "性别输入值不对，请输入0：男,1：女";
				}
			}
			String birthday = rowlist.get(2);
			Long birthdayDate = null;
			if(EmptyUtil.isNotEmpty(birthday)){
				try {
					
					
				    Date date=sdf.parse(birthday);
				    birthdayDate = date.getTime();
				} catch (Exception e) {
					return "出生日期输入值不对，请输入如20171207";
				}
			}
			
			String entryTime = rowlist.get(3);
			Long entryTimeDate = null;
			if(EmptyUtil.isNotEmpty(entryTime)){
				try {
					Date date=sdf.parse(entryTime);
					entryTimeDate =date.getTime();
				} catch (Exception e) {
					return "入职日期输入值不对，请输入如20171207";
				}
			}
			
			String mail = rowlist.get(4);
			if(EmptyUtil.isNotEmpty(mail)){
				if(!mail.contains("@")){
					return "邮箱输入值不对，请输入如aaa@egeo.com.cn";
				}
				UserDTO userDTO = userFacade.userByMail(mail);
				if(EmptyUtil.isNotEmpty(userDTO)){
					return "邮箱以存在";
				}
			}else{
				return "邮箱不能为空";
			}
			
			String departmentName = rowlist.get(5);
			Long departmentId = null;
			if(EmptyUtil.isNotEmpty(departmentName)){
				//根据部门名称查询部门信息
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartmentName(departmentName);
				departmentDTO.setCompanyId(companyId);
				List<DepartmentDTO> list = departmentManage.findDepartmentAll(departmentDTO);
				if(list.size() != 0){
					departmentId = list.get(0).getId();
				}else{
					return "部门输入值不对，请输入正确的部门信息";
				}
			}
			
			userExtendManage.saveUserBackground(mail,null, name, companyId ,departmentId, Integer.valueOf(sex), birthdayDate,
					entryTimeDate);
		
		return "success";
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	
	
}
