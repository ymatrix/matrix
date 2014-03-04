package com.zufe.controller;

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
import com.zufe.service.PermissionService;

@Controller
@RequestMapping("permissionController.do")
public class PermissionController {

	@Autowired
	private PermissionService service;
	
	@RequestMapping(params = "method=menu")   
    public void getPermissionMenu(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){   
		 try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(service.getPermissionMenu());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }
	
	@RequestMapping(params = "method=test")   
    public void add(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){   
		 try {
			response.getWriter().print("[{\"id\":1,\"text\":\"Folder1\",\"children\":[{\"text\":\"File1\",\"checked\":true}]}]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }
}
