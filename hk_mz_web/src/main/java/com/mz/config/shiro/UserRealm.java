package com.mz.config.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.mz.bean.user.vo.UserVo;
import com.mz.service.user.UserServiceApi;
import com.mz.util.bean.ServiceResult;


/**
 * 验证用户登录
 * 
 * @author Administrator
 */
public class UserRealm extends AuthorizingRealm {
	
	@Resource
	private UserServiceApi userServiceImpl ;
	
	/**
	 * 权限资源角色
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//add Permission Resources
		Subject subject = SecurityUtils.getSubject();
		List<String> urls = null ;
		if (subject == null || 
				subject.getSession() == null || 
				subject.getSession().getAttribute("userInfo") == null) {
			urls = new ArrayList<String>();
			info.addStringPermissions(urls);
			return info ;
		}
//		UserBeanVo userInfo = (UserBeanVo)subject.getSession().getAttribute("userInfo");
//		urls = userInfo.getPermissionUrlList();
//		if (urls == null) {
//			urls = new ArrayList<>();
//		}
		info.addStringPermissions(urls);
		
		return info;
	}
	
	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String loginName = upt.getUsername();
		ServiceResult<UserVo> serviceResult = userServiceImpl.getUserByLoginName(loginName);
		if (!serviceResult.isOk() || serviceResult.getData() == null) {
			throw new AccountException("帐号或密码不正确！");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(serviceResult.getData().getLoginName(), serviceResult.getData().getPassword(), getName());
		return info;
	}
}