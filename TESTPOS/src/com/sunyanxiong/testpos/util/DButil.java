package com.sunyanxiong.testpos.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/* ���ݿ� */
public class DButil {

	private SessionFactory sf;    // �����ػ�����
	
	public SessionFactory getSf(){
		return this.sf;
	}
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	
	/*
	 * ��õ�ǰ��¼��id 
	 */
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
}
