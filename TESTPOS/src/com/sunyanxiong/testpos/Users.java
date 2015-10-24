package com.sunyanxiong.testpos;

// 管理员类
public class Users {

	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getAlevel() {
		return alevel;
	}
	public void setAlevel(String alevel) {
		this.alevel = alevel;
	}
	
	private String aname;
	private String apwd;
	private String alevel;
	
	public Users(){}
	public Users(String id,String aname,String apwd,String alevel){
		this.id = id;
		this.aname = aname;
		this.apwd = apwd;
		this.alevel = alevel;
	}
	
	public String toString(){
		return this.aname+"/t"+this.apwd;
	}
}
