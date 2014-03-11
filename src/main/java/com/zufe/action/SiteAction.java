package com.zufe.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zufe.pojo.Msg;
import com.zufe.pojo.Site;
import com.zufe.service.SiteService;

@Controller
@RequestMapping("SiteAction")
public class SiteAction {

	@Autowired
	private SiteService service;
	
	@RequestMapping(value="save.do") 
	public void saveOrUpdate(Site site,HttpServletResponse response){
		
		boolean flag = service.save(site);
		
		try {
			response.setCharacterEncoding("utf-8");
			Msg msg = new Msg();
			msg.setSuccess(flag);
			if(flag==true){
				msg.setMsg("操作成功！");
			}else{
				msg.setMsg("操作失败!");
			}
			response.getWriter().print(msg.toJson());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="getlist.do") 
	public void getList(int page,int rows,HttpServletResponse response){
		String json = service.getList(page, rows);
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
}
