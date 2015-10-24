package com.sunyanxiong.testpos.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sunyanxiong.testpos.Users;

/**
 * ¸úÐÂÊý¾Ý
 * */
public class DBupdate {
	
	private SessionFactory sf;
	private DButil db;
	
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	public SessionFactory getSf(){
		return this.sf;
	}
	public void setDb(DButil db){
		this.db = db;
	}
	public DButil getDb(){
		return this.db;
	}
	
    public void updateTable(String tablename,Object obj,String id){
    	Session session = sf.openSession();
    	Transaction t = session.beginTransaction();
    	if(tablename.equals("pos_users")){
    		Users users = (Users)session.get(Users.class,id);
    		Users temp = (Users) obj;
    		users.setApwd(temp.getApwd());
    		session.save(users);
    	}
    	t.commit();
    	session.close();
    	
    } 
	
}
