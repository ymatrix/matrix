package com.zufe.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zufe.pojo.User;
import com.zufe.service.PermissionService;
import com.zufe.service.UserService;
import com.zufe.utils.MD5Util;

/**
 * 管理员登陆验证类
 * 
 * @author matrix 2014年3月6日
 */
@Controller
@RequestMapping("AdminAction")
public class AdminAction {

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login.do") 
	public void validateLogin(HttpServletRequest request,HttpServletResponse response,String username,String password,String randcode) throws IOException{

		User user = this.userService.getByName(username);
		HttpSession session= request.getSession();
		
		response.setCharacterEncoding("utf-8");
//		// 获得超级管理员账号
//		if (user == null) {
//			user = this.getSuperAdministrator();
//			user.setUserId("71BF30CB-83B8-4C37-8AE2-0865E42825EB");
//			user.setUsername("admin");
//		}
		if(user==null){
			response.getWriter().write("{success:false,msg:'该用户不存在！'}");
		}else if (!randcode.equalsIgnoreCase((String) session.getAttribute("validateCode"))) {
			response.getWriter().write("{success:false,msg:'验证码不正确！'}");
		}else if (!password.equals(user.getPassword())) {
			response.getWriter().write("{success:false,msg:'密码不正确！'}");
		} else {
			session.setAttribute("loginName", username);
			session.setAttribute("userid", user.getId());
			// session半小时后失效
			session.setMaxInactiveInterval(1800);
			response.getWriter().write("{success:true}");
		}
	}

	// 获得超级管理员账号
	public User getSuperAdministrator() {
		User superAdmin = new User();
		superAdmin.setUsername("administrator");
		superAdmin.setPassword(MD5Util.md5("administrator_2011"));
		return superAdmin;
	}
}
