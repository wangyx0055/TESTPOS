package com.sunyanxiong.testpos.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/* 数据库工具类 */
public class DButil {

	private SessionFactory sf;    // 创建回话工厂
	
	public SessionFactory getSf(){
		return this.sf;
	}
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	
	/**
	 * 当前记录的id 
	 **/
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
	
	/**
	 * 当前信息
	 * */
	public List<?> getInfo(String hql){
		
		Session session = sf.openSession();  
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
	
	/**
	 * 某页的内容
	 * */
	public List<String> getPageContent(String hql,int page,int span){    // @param  span:当前页面显示的条数。
		List temp = new ArrayList();   // 存放页面内容
		Session session = sf.openSession();
		Query q = session.createQuery(hql);
		List list = q.list();
		int i = 0;   
		while(((page - 1) * span < list.size()) && (i < span)){
			temp.add(list.get((page-1)*span+i));   // 将结果集添加到temp中
			i++;
		}
		session.close();
		return temp;
	}
	
	/**
	 * 总页数
	 * */
	public int getPageTotal(String hql,int span){
		
		Session session = sf.openSession();
		Query q = session.createQuery(hql);
		List<Long> list = q.list();
		int count = (list.get(0)).intValue();   // 总数
		int page = ((count%span) == 0)?(count/span):((count/span) + 1);
		session.close();
		return page;
	}
	
	/**
	 * 各个商品分类下的上商品名称
	 * */
	public List<String> getGoodsClass(){
		
		Session session = sf.openSession();
		String hql = "SELECT gcname FROM pos_category";
		Query q = session.createQuery(hql);
		List<String> name = q.list();
		session.close();
		return name;
	}
	
	/**
	 *  供应商名称
	 * */
	public List<String> getProvider(){
		
		Session session = sf.openSession();
		String hql = "SELECT pname FROM pos_provider";
		Query q = session.createQuery(hql);
		List<String> name = q.list();
		session.close();
		return name;
	}
	/**
	 *  商品名称
	 * */
	public List<String> getGoods(){
		
		Session session = sf.openSession();
		String hql = "SELECT gname FROM pos_goods";
		Query q = session.createQuery(hql);
		List<String> name = q.list();
		session.close();
		return name;
	}
	
	/**
	 * 客户名称 
	 * */
	public List<String> getClient(){
		
		Session session = sf.openSession();
		String hql = "SELECT cname FROM pos_client";
		Query q = session.createQuery(hql);
		List<String> name = q.list();
		session.close();
		return name;
	}
	
	/**
	 * 管理员名称
	 * */
	public List<String> getUsers(){
		Session session = sf.openSession();
		String hql = "SELECT aname FROM pos_users";
		Query q = session.createQuery(hql);
		List<String> name = q.list();
		return name;
	}
	
	/**
	 * 时间 
	 * */
	public Date getDate(String now){
		
		String[] dd = now.split("-");   // 将字符串以“-”拆分
		int year = Integer.parseInt(dd[0]) - 1900;
		int mouth = Integer.parseInt(dd[1]) -1;
		int day = Integer.parseInt(dd[2]);
		return new Date(year,mouth,day); 
	}
	
	/**
	 * 跟新总价(采购和销售)
	 * */
	public void updateTotalprice(String name,String id){
		
		Session session = sf.openSession();
		Transaction tsa = session.beginTransaction();    // 开启事务
		
		tsa.commit();    // 事务提交
		
	}
}
