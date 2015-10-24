package com.sunyanxiong.testpos.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sunyanxiong.testpos.Users;

/**
 * É¾³ýÊý¾Ý
 * */
public class DBdelete {
	
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

	public void deleteTable(String tablename,String id){
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		if(tablename.equals("pos_users")){
			Users users = (Users) session.get(Users.class,id);
			if(users != null){
				session.delete(users);
			}
		}
		
		t.commit();
		session.close();
		
	}

}
