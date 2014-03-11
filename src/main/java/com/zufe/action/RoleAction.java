package com.zufe.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zufe.pojo.Msg;
import com.zufe.pojo.Role;
import com.zufe.service.RoleService;

@Controller
@RequestMapping("RoleAction")
public class RoleAction {

	@Autowired
	private RoleService service;
	
	@RequestMapping(value="save.do") 
	public void saveOrUpdate(Role role,HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session= request.getSession();
		String userid = (String) session.getAttribute("userid");
		role.setUserid(userid);
		if(role.getCreateDate()==null){
			role.setCreateDate(new Date());
		}
		boolean flag = service.save(role);
		
		try {
			response.setCharacterEncoding("utf-8");
			Msg msg = new Msg();
			msg.setSuccess(flag);
			if(flag==true){
				msg.setMsg("更新成功！");
			}else{
				msg.setMsg("更新失败!");
			}
			response.getWriter().print(msg.toJson());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="getlist.do") 
	public void getList(int page,int rows,HttpServletRequest request,HttpServletResponse response){
		HttpSession session= request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		String json = service.getList(userid,page, rows);
		
		System.out.println(json);
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="delete.do") 
	public void delete(String id,HttpServletResponse response){
		Msg msg = new Msg();
		msg.setSuccess(service.deleteById(id));
		if(msg.getSuccess()==true){
			msg.setMsg("删除成功！");
		}else{
			msg.setMsg("删除失败!");
		}
		try {
			response.getWriter().print(msg.toJson());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="changeStatus.do") 
	public void changeStatus(String id,HttpServletResponse response){
		service.changeStatus(id);
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print("{\"success\":\"true\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
