package com.mz.bean.menu.vo;

import java.util.List;

import com.mz.bean.menu.Menu;

/**
 *菜单表
 */
public class MenuVo extends Menu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3252006344385423506L;
	
	private Integer roleId ;
	
	private List<MenuVo> childrenMenuList ;

	public List<MenuVo> getChildrenMenuList() {
		return childrenMenuList;
	}

	public void setChildrenMenuList(List<MenuVo> childrenMenuList) {
		this.childrenMenuList = childrenMenuList;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
}
