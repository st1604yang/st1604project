package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Emp;
import com.dao.EmpDap;

@Service
@Transactional
public class Empservice {

		@Autowired
		private EmpDap ed;
		
		
		public void save(Emp emp){
			this.ed.save(emp);
		}
		
		public List<Emp> listAll(){
			return this.ed.listApp();
		}
		
		public Emp getByid(int id ){
			return this.ed.getByid(id);
		}
		
		public void update(Emp emp){
			this.ed.update(emp);
			
		}
		
		public void delete(int id){
			Emp emp=ed.getByid(id);
			this.ed.delete(emp);
		}
}
