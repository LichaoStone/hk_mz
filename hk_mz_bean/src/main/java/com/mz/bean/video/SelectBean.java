package com.mz.bean.video;

import java.io.Serializable;

import com.mz.util.bean.BaseEntity;
/**
 * 下拉菜单Bean
 * @author lichao
 */
public class SelectBean extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 6993513995528837310L;
	
	/**下拉菜单ID**/
	private String id;
	/**下拉菜单名称**/
	private String name;
	/**类型，传入条件**/
	private String type;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
