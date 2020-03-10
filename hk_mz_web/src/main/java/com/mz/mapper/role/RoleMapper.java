package com.mz.mapper.role;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.role.Role;
import com.mz.bean.role.vo.RoleVo;
import com.mz.bean.role.query.RoleVoQuery;
@Mapper
public interface RoleMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertRole(Role bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateRole(Role bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteRole(Role bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateRoleBySelective(Role bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public RoleVo getRoleVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getRoleCountByQuery(RoleVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<RoleVo> getRoleListByQuery(RoleVoQuery query);
	/**
	 * 检查角色名称是否存在
	 * @param roleVo
	 * @return
	 */
	public List<RoleVo> checkRoleName(RoleVo roleVo);
	
}