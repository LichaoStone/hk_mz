package com.mz.bean.permissions;

import java.io.Serializable;
/**
 *权限表
 */
public class Permissions implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2216706015581292450L;
	//id
	private Integer permissionsId;  
	//角色id
	private Integer roleId;  
	//权限类型：menu菜单，operation操作
	private String permissionsType;  
	//所属菜单或者操作id
	private Integer sourceId;  
  	
	public Integer getPermissionsId(){  
		return permissionsId;  
	}  
	public void setPermissionsId(Integer permissionsId){  
		this.permissionsId = permissionsId;  
	}  
	public Integer getRoleId(){  
		return roleId;  
	}  
	public void setRoleId(Integer roleId){  
		this.roleId = roleId;  
	}  
	public String getPermissionsType(){  
		return permissionsType;  
	}  
	public void setPermissionsType(String permissionsType){  
		this.permissionsType = permissionsType;  
	}  
	public Integer getSourceId(){  
		return sourceId;  
	}  
	public void setSourceId(Integer sourceId){  
		this.sourceId = sourceId;  
	}  
}
