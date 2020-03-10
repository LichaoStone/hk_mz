package com.mz.bean.menu;

import java.io.Serializable;
/**
 *菜单表
 */
public class Menu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2744122348868995653L;
	//菜单id
	private Integer menuId;  
	//菜单名称
	private String menuName;  
	//菜单地址
	private String menuUrl;  
	//菜单图标
	private String menuIcon;  
	//状态：0禁用，1启用
	private Integer status;  
	//排序号
	private Integer orderNum;  
	//菜单级别
	private Integer menuLevel;  
	//父菜单id
	private Integer parentId;  
  	
	public Integer getMenuId(){  
		return menuId;  
	}  
	public void setMenuId(Integer menuId){  
		this.menuId = menuId;  
	}  
	public String getMenuName(){  
		return menuName;  
	}  
	public void setMenuName(String menuName){  
		this.menuName = menuName;  
	}  
	public String getMenuUrl(){  
		return menuUrl;  
	}  
	public void setMenuUrl(String menuUrl){  
		this.menuUrl = menuUrl;  
	}  
	public String getMenuIcon(){  
		return menuIcon;  
	}  
	public void setMenuIcon(String menuIcon){  
		this.menuIcon = menuIcon;  
	}  
	public Integer getStatus(){  
		return status;  
	}  
	public void setStatus(Integer status){  
		this.status = status;  
	}  
	public Integer getOrderNum(){  
		return orderNum;  
	}  
	public void setOrderNum(Integer orderNum){  
		this.orderNum = orderNum;  
	}  
	public Integer getMenuLevel(){  
		return menuLevel;  
	}  
	public void setMenuLevel(Integer menuLevel){  
		this.menuLevel = menuLevel;  
	}  
	public Integer getParentId(){  
		return parentId;  
	}  
	public void setParentId(Integer parentId){  
		this.parentId = parentId;  
	}  
}
