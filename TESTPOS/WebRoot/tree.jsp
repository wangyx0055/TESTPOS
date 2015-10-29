<%@ page contentType="text/html;charset=gbk"  %>
<html>
  <head>
    <title>树形列表</title>
    <link rel=stylesheet href="css/style.css" type="text/css">
  </head>
  <body bgcolor="#EBF5FD">
    <jsp:useBean id="userBean" class="com.sunyanxiong.testpos.UsersBean" scope="session"/>
    <table border="0">
      <tr><td>
       	<a id="A" href="#" onclick=""><img border="0" src="img/pkg-open.gif"/></a><a href="#"><font>POS信息管理系统</font></a>
      </td></tr>
      
      <tr><td>        
        <table id="AA" border="0" style="display:black">
           <!-- 基本信息-->
          <tr><td>
          	&nbsp;&nbsp;
            <a id="B" href="#" onclick=""><img border="0" src="img/pkg-open.gif"/></a><a href="#"><font>基本信息</font></a>
          </td></tr>
          <tr><td>
          	<table id="BB" border="0" style="display:black">
          	  <tr><td>
          	  &nbsp;&nbsp;&nbsp;&nbsp;
          	  <img border="0" src="img/fav.gif"/><a href="" target="mainFrame"><font>商品资料</font></a>
          	  </td></tr>
          	  <tr><td>
          	  &nbsp;&nbsp;&nbsp;&nbsp;
          	  <img border="0" src="img/fav.gif"/><a href="" target="mainFrame"><font>商品类别</font></a>
          	  </td></tr>
          	  <tr><td>
          	  &nbsp;&nbsp;&nbsp;&nbsp;
          	  <img border="0" src="img/fav.gif"/><a href="" target="mainFrame"><font>客户资料</font></a>
          	  </td></tr>
          	  <tr><td>
          	  &nbsp;&nbsp;&nbsp;&nbsp;
          	  <img border="0" src="img/fav.gif"/><a href="" target="mainFrame"><font>供应商资料</font></a>
          	  </td></tr>
          	</table>
          </td></tr>
          
          <!-- 业务处理 -->
          <tr><td>
          	&nbsp;&nbsp;
            <a id="C" href="#" onclick=""><img border="0" src="img/pkg-open.gif"/></a><a href="#"><font>业务处理</font></a>
          </td></tr>
          <tr><td>
            <table id="CC" border="0" style="display:black">
          	  <tr><td>
          	  &nbsp;&nbsp;&nbsp;&nbsp;
          	  <a id="E" href="#" onclick=""><img border="0" src="img/pkg-open.gif"/></a><a href="#"><font>商品采购</font></a>
          	  </td></tr>
          	  <tr><td>
          	    <table id="EE" border="0" style="display:black">
          	  	  <tr><td>
          	  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          	  		<img border="0" src="img/fav.gif"/><a href="" target="mainFrame"><font>采购信息</font></a>
          	  	  </td></tr> 
           	  	  <tr><td>
          	  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          	  		<img border="0" src="img/fav.gif"/><a href="" target="mainFrame"><font>采购退货</font></a>
          	  	  </td></tr> 	  
          	    </table>
          	  </td></tr>
          	  
          	  
          	  <tr><td>
          	  &nbsp;&nbsp;&nbsp;&nbsp;
          	  <a id="F" href="#" onclick=""><img border="0" src="img/pkg-open.gif"/></a><a href="#"><font>商品销售</font></a>
          	  </td></tr>
          	  <tr><td>
          	    <table id="FF" border="0" style="display:black">
          	  	  <tr><td>
          	  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          	  		<img border="0" src="img/fav.gif"/><a href="" target="mainFrame"><font>销售信息</font></a>
          	  	  </td></tr> 
           	  	  <tr><td>
          	  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          	  		<img border="0" src="img/fav.gif"/><a href="" target="mainFrame"><font>销售退货</font></a>
          	  	  </td></tr>   	  	  
          	    </table>          	  
          	  </td></tr>
            </table>
          </td></tr>
          
           <!-- 业务统计 -->
          <tr><td>
          	&nbsp;&nbsp;
            <a id="D" href="#" onclick=""><img border="0" src="img/pkg-open.gif"/></a><a href="#"><font>业务统计</font></a>
          </td></tr>
          <tr><td>
            <table id="DD" border="0" style="display:black">
          	  <tr><td>
          	  &nbsp;&nbsp;&nbsp;&nbsp;
          	  <img border="0" src="img/fav.gif"/><a href="statistic.jsp" target="mainFrame"><font>库存统计</font></a>
          	  </td></tr>
            </table>
          </td></tr>
          <tr><td>
            <table border="0">
              <tr><td>
                &nbsp;&nbsp;&nbsp;&nbsp; 
            	<img border="0" src="img/fav.gif"/><a href="" target="mainFrame"><font>系统维护</font></a>
              </td></tr>
            </table>
          </td></tr>
        </table>
      </td></tr>
    </table>
  </body>
</html>