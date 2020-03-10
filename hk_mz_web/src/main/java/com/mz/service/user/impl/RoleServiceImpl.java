package com.mz.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mz.bean.permissions.Permissions;
import com.mz.bean.role.Role;
import com.mz.bean.role.query.RoleVoQuery;
import com.mz.bean.role.vo.RoleVo;
import com.mz.mapper.permissions.PermissionsMapper;
import com.mz.mapper.role.RoleMapper;
import com.mz.service.user.RoleServiceApi;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;
@Service
public class RoleServiceImpl implements RoleServiceApi{
	
	@Resource
	private RoleMapper roleMapper ;
	@Resource
	private PermissionsMapper permissionsMapper ;

	@Override
	public ServiceResult<PageVo<RoleVo>> getRolePageByQuery(RoleVoQuery query) {
		
		ServiceResult<PageVo<RoleVo>> serviceResult = new ServiceResult<PageVo<RoleVo>>(true);
		
		PageHelper.offsetPage(query.getOffset(), query.getPageSize());
		
		List<RoleVo> list = roleMapper.getRoleListByQuery(query);
		
		PageVo<RoleVo> pageVo = new PageVo<RoleVo>((Page<RoleVo>) list);
		
		serviceResult.setData(pageVo);
		
		return serviceResult;
	}

	@Override
	public ServiceResult<List<RoleVo>> getRoleListByQuery(RoleVoQuery query) {
		ServiceResult<List<RoleVo>> serviceResult = new ServiceResult<List<RoleVo>>(true);
		List<RoleVo> list = roleMapper.getRoleListByQuery(query);
		if (list == null) {
			list = new ArrayList<RoleVo>();
		}
		return serviceResult;
	}

	@Override
	@Transactional
	public ServiceResult<RoleVo> saveRole(RoleVo roleVo) {
		ServiceResult<RoleVo> serviceResult = new ServiceResult<RoleVo>(false);
		List<RoleVo> list = roleMapper.checkRoleName(roleVo);
		if (list != null && list.size() > 0) {
			serviceResult.setComment("角色名称已存在");
			return serviceResult ;
		}
		int count = 0 ;
		if (roleVo.getRoleId() == null) {
			count = roleMapper.insertRole(roleVo);
		}else {
			count = roleMapper.updateRoleBySelective(roleVo);
		}
		if (count > 0) {
			serviceResult.setOk(true);
			serviceResult.setComment("保存成功");
			serviceResult.setData(roleVo);
			return serviceResult ;
		}
		serviceResult.setComment("保存失败");
		return serviceResult;
	}

	@Override
	@Transactional
	public ServiceResult<Boolean> deleteRoleById(Integer roleId) {
		ServiceResult<Boolean> serviceResult = new ServiceResult<Boolean>();
		Role role = new Role();
		role.setRoleId(roleId);
		permissionsMapper.deletePermissionsByRoleId(roleId);
		int count = roleMapper.deleteRole(role);
		if (count > 0) {
			serviceResult.setOk(true);
			serviceResult.setData(true);
			serviceResult.setComment("删除成功");
			return serviceResult ;
		}
		serviceResult.setOk(false);
		serviceResult.setData(false);
		serviceResult.setComment("删除失败");
		return serviceResult;
	}

	@Override
	@Transactional
	public ServiceResult<Boolean> saveRolePermission(Integer roleId, List<Permissions> permissions) {
		ServiceResult<Boolean> serviceResult = new ServiceResult<Boolean>(false);
		permissionsMapper.deletePermissionsByRoleId(roleId);
		int count = permissionsMapper.batchInsertPermissions(permissions);
		if (count == permissions.size()) {
			serviceResult.setOk(true);
			serviceResult.setData(true);
			serviceResult.setComment("操作成功");
			return serviceResult ;
		}
		serviceResult.setOk(false);
		serviceResult.setData(false);
		serviceResult.setComment("操作失败");
		return serviceResult;
	}

}
