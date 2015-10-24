package com.sunyanxiong.testpos.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/* 数据库工具类 */
public class DButil {

	private SessionFactory sf;    // 创建回话工厂 ,申明LocalSessionFactoryBean
	
	public SessionFactory getSf(){
		return this.sf;
	}
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	public List<?> getInfo(String hql){
		
		Session session = sf.openSession();   // 开启回话
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();    // 关闭回话
		return list;
	}
}
