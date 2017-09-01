package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.Emp;

@Component

public class EmpDap {

	
		@Autowired
		private SessionFactory sf;
		
		public Session getSession(){
			return this.sf.getCurrentSession();
		}
		
		public void save(Emp emp){
			Session session=getSession();
			session.save(emp);
			
		}
		
		public List<Emp> listApp(){
			String hql="from Emp";
			Session session=getSession();
			List<Emp> list=session.createQuery(hql).list();
			return list;
		}
		
		public  Emp getByid(int id){
			Session session=getSession();
			Emp emp=(Emp)session.get(Emp.class, id);
			return emp;
		}
		
		public void update(Emp emp){
			Session session=getSession();
			session.update(emp);
		}
		
		public void delete(Emp emp){
			Session session=getSession();
			session.delete(emp);
		}
}
