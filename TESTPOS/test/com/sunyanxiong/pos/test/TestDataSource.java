package com.sunyanxiong.pos.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 测试数据源  **/
public class TestDataSource {

	@Test
    public void getConnection() throws Exception{
  
		System.out.println("1");
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("2");
		DataSource ds = (DataSource)ac.getBean("dataSource");
		System.out.println(ds.getConnection());
		System.out.println("测试成功！");
		
    }	
}
