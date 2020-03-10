package com.mz.service.user;

import java.util.List;

import com.mz.bean.permissions.Permissions;
import com.mz.bean.role.query.RoleVoQuery;
import com.mz.bean.role.vo.RoleVo;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

public interface RoleServiceApi {

	/**
	 * 分页获得角色列表
	 * @param query
	 * @return
	 */
	ServiceResult<PageVo<RoleVo>> getRolePageByQuery(RoleVoQuery query);
	/**
	 * 获得角色列表
	 * @param query
	 * @return
	 */
	ServiceResult<List<RoleVo>> getRoleListByQuery(RoleVoQuery query);
	/**
	 * 保存用户角色
	 * @param roleVo
	 * @return
	 */
	ServiceResult<RoleVo> saveRole(RoleVo roleVo);
	/**
	 * 删除用户角色
	 * @param roleId
	 * @return
	 */
	ServiceResult<Boolean> deleteRoleById(Integer roleId);
	/**
	 * 保存角色权限
	 * @param permissionsVos
	 * @return
	 */
	ServiceResult<Boolean> saveRolePermission(Integer roleId,List<Permissions> permissions);
	
}
