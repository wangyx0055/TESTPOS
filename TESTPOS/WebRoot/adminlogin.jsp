<%@ page contentType="text/html;charset=utf-8" %>
<! DOCTYPE html>
<html>
<head>
<title>登录页面</title>
<link rel=stylesheet href="css/style.css" type="text/css">
<script language="javascript" src="script/trim.js"></script>
<script language="javascript">

    // 用户名和密码验证
   function checkName(){
      var username = document.all.username.value;
      var password = document.all.password.value;
      
      if(username.trim() == ""){
         alert("用户名为空！请重新输入...");
         window.ManageServlet.username.focus();    //   将光标切换到输入框
         return false;
      } 
      if(password.trim() == ""){
         alert("密码为空！请重新输入...");
         window.ManageServlet.password.focus();
         return false;
      }
      return true;
   }

</script>

</head>

<body>
<div class="out">
   <div class="login_style"">
       <center style="width: 1058px; height: 251px">
       <form action="ManageServlet" method="post" id="mf" target="bottom" style="height: 204px; ">
         <input type="hidden" name="action" value="login">
         <table style="height: 195px; ">
            <tr>
              <td>用户名：</td>
              <td><input type="text" id="username" name="username" value="sunyanxiong"/></td>
            </tr>
            <tr>
              <td>密&nbsp;&nbsp;&nbsp;码：</td>
              <td><input type="password" id="password" name="password" value="sunyanxiong" style="width: 156px; "/></td>
            </tr>
             <tr>
	        <td colspan="2" align="center">
	        <img border="0" src="img/ddl.gif" id="lg"
          	  style="cursor:hand"
          	  onmouseover=""
          	  onmouseout=""
          	  onmouseup=""        	
          	  onmousedown=""/>
	        <img border="0" src="img/cz.gif" id="cz" 
          	  style="cursor:hand"
          	  onmouseover=""
          	  onmouseout=""
          	  onmouseup=""        	
          	  onmousedown=""/></td>
	      </tr>
         </table>
       </form>
       </center>
   </div>
</div>
</body>
</html>