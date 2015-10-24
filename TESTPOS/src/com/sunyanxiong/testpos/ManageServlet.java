package com.sunyanxiong.testpos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sunyanxiong.testpos.util.DBdelete;
import com.sunyanxiong.testpos.util.DBinsert;
import com.sunyanxiong.testpos.util.DBupdate;
import com.sunyanxiong.testpos.util.DButil;

public class ManageServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8s");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();   // 获取回话对象
		UsersBean usersBean = (UsersBean) session.getAttribute("usersBean");
		if(usersBean == null){
			usersBean = new UsersBean();
		}
		
		WebApplicationContext wec = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  // 获取应用上下文
		DButil db = (DButil) wec.getBean("DButil");   // 得到数据操作类
	    DBinsert dbin = (DBinsert) wec.getBean("DBinsert");
	    DBupdate dbup = (DBupdate) wec.getBean("DBupdate");
	    DBdelete dbde = (DBdelete) wec.getBean("DBdelete");  
		
		String action = request.getParameter("action").trim();  // 得到请求动作
		if(action.equals("login")){
			String username = request.getParameter("username").trim();   // 用户名
			String password = request.getParameter("password").trim();   // 密码
			username = new String(username.getBytes(),"ISO-8859-1");   // 用户名转码
			password = new String(password.getBytes(),"ISO-8859-1");   // 密码转码
			String hql = "FROM pos_users AS p" + "WHERE p.aname ='"+username+"'AND p.apwd ='"+password+"'";  // 查询管理员用户名和密码
			List<Users> list = (List<Users>) db.getInfo(hql);
			String url = "";
			if(!list.isEmpty()){
				Users users = list.get(0);
			    url = "/index.jsp";
			    session.setAttribute("admin",username);    //  将管理员存入回话
			    session.setAttribute("alevel",users.getAlevel());   //  将管理员级别存入回话
			} else{
				String msg = "对不起,登录失败！";
				request.setAttribute("msg",msg);
				url = "/info.jsp";
			}
			ServletContext sc = getServletContext();   // 得到上下文
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request, response);   // 页面跳转
		}
		else if(action.equals("logout")){
			request.getSession(true).invalidate();   //   是回话失效
			response.sendRedirect("adminlogin.jsp");
		}
	}

}
