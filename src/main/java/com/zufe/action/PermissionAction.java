package com.zufe.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zufe.pojo.Permission;
import com.zufe.pojo.User;
import com.zufe.service.PermissionService;

@Controller
@RequestMapping("PermissionAction")
public class PermissionAction {

	@Autowired
	private PermissionService service;
	
	@RequestMapping(value = "menu.do")   
    public void getPermissionMenu(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){   
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(service.getPermissionMenu());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }
	
}
