package com.sunyanxiong.testpos.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/* ���ݿ⹤���� */
public class DButil {

	private SessionFactory sf;    // �����ػ�����
	
	public SessionFactory getSf(){
		return this.sf;
	}
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	
	/**
	 * ��ǰ��¼��id 
	 **/
	public String getId(String tablename,String columnname){
		
		Session session = sf.openSession();  // �����ػ�
		String hql = "SELECT MAX ("+ columnname +") FROM " + tablename; // hql���
		Query q = session.createQuery(hql);   // ִ�в�ѯ���
		List<String> result = q.list();   // ���صĽ����
		if(result.get(0) == null){
			return "100001";
		}
		
		int id = Integer.parseInt(result.get(0));
		id++;
		return Integer.valueOf(id).toString();
	}
	
	/**
	 * ��ǰ��Ϣ
	 * */
	public List<?> getInfo(String hql){
		
		Session session = sf.openSession();  
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
	
	/**
	 * ĳҳ������
	 * */
	public List<String> getPageContent(String hql,int page,int span){    // @param  span:��ǰҳ����ʾ��������
		List temp = new ArrayList();   // ���ҳ������
		Session session = sf.openSession();
		Query q = session.createQuery(hql);
		List list = q.list();
		int i = 0;   
		while(((page - 1) * span < list.size()) && (i < span)){
			temp.add(list.get((page-1)*span+i));   // ���������ӵ�temp��
			i++;
		}
		session.close();
		return temp;
	}
	
	/**
	 * ��ҳ��
	 * */
	public int getPageTotal(String hql,int span){
		
		Session session = sf.openSession();
		Query q = session.createQuery(hql);
		List<Long> list = q.list();
		int count = (list.get(0)).intValue();   // ����
		int page = ((count%span) == 0)?(count/span):((count/span) + 1);
		session.close();
		return page;
	}
	
	/**
	 * ������Ʒ�����µ�����Ʒ����
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
	 *  ��Ӧ������
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
	 *  ��Ʒ����
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
	 * �ͻ����� 
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
	 * ����Ա����
	 * */
	public List<String> getUsers(){
		Session session = sf.openSession();
		String hql = "SELECT aname FROM pos_users";
		Query q = session.createQuery(hql);
		List<String> name = q.list();
		return name;
	}
	
	/**
	 * ʱ�� 
	 * */
	public Date getDate(String now){
		
		String[] dd = now.split("-");   // ���ַ����ԡ�-�����
		int year = Integer.parseInt(dd[0]) - 1900;
		int mouth = Integer.parseInt(dd[1]) -1;
		int day = Integer.parseInt(dd[2]);
		return new Date(year,mouth,day); 
	}
	
	/**
	 * �����ܼ�(�ɹ�������)
	 * */
	public void updateTotalprice(String name,String id){
		
		Session session = sf.openSession();
		Transaction tsa = session.beginTransaction();    // ��������
		
		tsa.commit();    // �����ύ
		
	}
}
