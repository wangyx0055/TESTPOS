package com.sunyanxiong.testpos.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sunyanxiong.testpos.Users;

/**
 *  ��������
 * */
public class DBinsert {
	
	private SessionFactory sf;
	private DButil db;
	
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public DButil getDb() {
		return db;
	}
	public void setDb(DButil db) {
		this.db = db;
	}
  
	/**
	 * �������
	 * */
	public void insetTable(String tablename,Object obj){
		
	  Session session = sf.openSession();
	  Transaction t = session.beginTransaction();    // ��������
	  if(tablename.equals("pos_users")){
		  Users users = (Users) obj;
		  session.save(users);
	}
	  t.commit();     // �ύ����
	  session.close();    // ���ջػ�
		
	}
	

}
