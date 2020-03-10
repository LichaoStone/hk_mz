package com.mz.bean.opration;

import java.io.Serializable;
/**
 *操作类型表
 */
public class Opration implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4735008432347614796L;
	//操作类型id
	private Integer operationId;  
	//操作类型名称
	private String operationName;  
	//所属菜单id
	private Integer menuId;  
	//排序号
	private Integer orderNum;  
	//操作的url
	private String operateUrl;  
  	
	public Integer getOperationId(){  
		return operationId;  
	}  
	public void setOperationId(Integer operationId){  
		this.operationId = operationId;  
	}  
	public String getOperationName(){  
		return operationName;  
	}  
	public void setOperationName(String operationName){  
		this.operationName = operationName;  
	}  
	public Integer getMenuId(){  
		return menuId;  
	}  
	public void setMenuId(Integer menuId){  
		this.menuId = menuId;  
	}  
	public Integer getOrderNum(){  
		return orderNum;  
	}  
	public void setOrderNum(Integer orderNum){  
		this.orderNum = orderNum;  
	}  
	public String getOperateUrl(){  
		return operateUrl;  
	}  
	public void setOperateUrl(String operateUrl){  
		this.operateUrl = operateUrl;  
	}  
}
