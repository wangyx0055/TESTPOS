package com.sunyanxiong.testpos.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/* ���ݿ⹤���� */
public class DButil {

	private SessionFactory sf;    // �����ػ����� ,����LocalSessionFactoryBean
	
	public SessionFactory getSf(){
		return this.sf;
	}
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	public List<?> getInfo(String hql){
		
		Session session = sf.openSession();   // �����ػ�
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();    // �رջػ�
		return list;
	}
}
