package com.mz.mapper.menu;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.menu.Menu;
import com.mz.bean.menu.vo.MenuVo;
import com.mz.bean.menu.query.MenuVoQuery;
@Mapper
public interface MenuMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertMenu(Menu bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateMenu(Menu bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteMenu(Menu bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateMenuBySelective(Menu bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public MenuVo getMenuVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getMenuCountByQuery(MenuVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<MenuVo> getMenuListByQuery(MenuVoQuery query);
}