package com.mz.bean.user.vo;

import java.util.List;

import com.mz.bean.menu.vo.MenuVo;
import com.mz.bean.user.User;

/**
 *用户表
 */
public class UserVo extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1271207357143016800L;
	//登录用户推流权限
	private byte isPush  ;
	//用户所属平台名称
	private String platformName ;
	
	private List<MenuVo> menuVos ;
	
	private List<String> oprationUrls ;

	public byte getIsPush() {
		return isPush;
	}

	public void setIsPush(byte isPush) {
		this.isPush = isPush;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public List<MenuVo> getMenuVos() {
		return menuVos;
	}

	public void setMenuVos(List<MenuVo> menuVos) {
		this.menuVos = menuVos;
	}

	public List<String> getOprationUrls() {
		return oprationUrls;
	}

	public void setOprationUrls(List<String> oprationUrls) {
		this.oprationUrls = oprationUrls;
	}
	
	
	
}
