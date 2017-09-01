package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Emp;
import com.service.Empservice;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private Empservice es;
	
	@RequestMapping("/save")
	@ResponseBody
	public boolean saveEmp(Emp emp,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		boolean flag=true;
		try {
			this.es.save(emp);
			System.out.println("emp:"+emp.getEname()+emp.getAge());
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Emp> findAll(HttpServletResponse response){
		System.out.println("emp find all");
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Emp> list=this.es.listAll();
		System.out.println("list:"+list.size());
		return list;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public  boolean Empudpate(Emp emp,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		boolean flag=true;
		try {
			this.es.update(emp);
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
	
	@RequestMapping("/delete/{eid}")
	@ResponseBody
	public boolean Empdelete(@PathVariable("eid")int eid,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		boolean flag=true;
		try {
			this.es.delete(eid);
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
}
