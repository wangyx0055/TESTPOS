package com.sunyanxiong.testpos.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/* 数据库 */
public class DButil {

	private SessionFactory sf;    // 创建回话工厂
	
	public SessionFactory getSf(){
		return this.sf;
	}
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	
	/*
	 * 获得当前记录的id 
	 */
	public String getId(String tablename,String columnname){
		
		Session session = sf.openSession();  // 开启回话
		String hql = "SELECT MAX ("+ columnname +") FROM " + tablename; // hql语句
		Query q = session.createQuery(hql);   // 执行查询语句
		List<String> result = q.list();   // 返回的结果集
		if(result.get(0) == null){
			return "100001";
		}
		
		int id = Integer.parseInt(result.get(0));
		id++;
		return Integer.valueOf(id).toString();
	}
}
