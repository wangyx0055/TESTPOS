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
		
		HttpSession session = request.getSession();   // ��ȡ�ػ�����
		UsersBean usersBean = (UsersBean) session.getAttribute("usersBean");
		if(usersBean == null){
			usersBean = new UsersBean();
		}
		
		WebApplicationContext wec = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  // ��ȡӦ��������
		DButil db = (DButil) wec.getBean("DButil");   // �õ����ݲ�����
	    DBinsert dbin = (DBinsert) wec.getBean("DBinsert");
	    DBupdate dbup = (DBupdate) wec.getBean("DBupdate");
	    DBdelete dbde = (DBdelete) wec.getBean("DBdelete");  
		
		String action = request.getParameter("action").trim();  // �õ�������
		if(action.equals("login")){
			String username = request.getParameter("username").trim();   // �û���
			String password = request.getParameter("password").trim();   // ����
			username = new String(username.getBytes(),"ISO-8859-1");   // �û���ת��
			password = new String(password.getBytes(),"ISO-8859-1");   // ����ת��
			String hql = "FROM pos_users AS p" + "WHERE p.aname ='"+username+"'AND p.apwd ='"+password+"'";  // ��ѯ����Ա�û���������
			List<Users> list = (List<Users>) db.getInfo(hql);
			String url = "";
			if(!list.isEmpty()){
				Users users = list.get(0);
			    url = "/index.jsp";
			    session.setAttribute("admin",username);    //  ������Ա����ػ�
			    session.setAttribute("alevel",users.getAlevel());   //  ������Ա�������ػ�
			} else{
				String msg = "�Բ���,��¼ʧ�ܣ�";
				request.setAttribute("msg",msg);
				url = "/info.jsp";
			}
			ServletContext sc = getServletContext();   // �õ�������
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request, response);   // ҳ����ת
		}
		else if(action.equals("logout")){
			request.getSession(true).invalidate();   //   �ǻػ�ʧЧ
			response.sendRedirect("adminlogin.jsp");
		}
	}

}
