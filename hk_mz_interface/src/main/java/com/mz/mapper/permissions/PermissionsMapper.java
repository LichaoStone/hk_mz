package com.mz.mapper.permissions;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.permissions.Permissions;
import com.mz.bean.permissions.vo.PermissionsVo;
import com.mz.bean.permissions.query.PermissionsVoQuery;
@Mapper
public interface PermissionsMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertPermissions(Permissions bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updatePermissions(Permissions bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deletePermissions(Permissions bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updatePermissionsBySelective(Permissions bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public PermissionsVo getPermissionsVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getPermissionsCountByQuery(PermissionsVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<PermissionsVo> getPermissionsListByQuery(PermissionsVoQuery query);
}