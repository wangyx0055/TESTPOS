<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<title>pos系统后台管理主页</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />

</head>

<body background="#EBF5FD">
	<jsp:useBean id="userBean" class="com.sunyanxiong.testpos.UsersBean"
		scope="session"></jsp:useBean>
	<center>
		<br /> <br /> <br /> <br />
		<table width="80%" height="60%">
			<tr align="center" height="100">

				<td><div class="block">
						<img src="img/spzl.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mainFrame"><font>商品分类</font></a>
					</div></td>

				<td><div class="block">
						<img src="img/splb.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mainFrame"><font>商品分类</font></a>
					</div></td>

				<td><div class="block">
						<img src="img/khzl.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mianFrame"><font>客户资料</font></a>
					</div></td>

				<td><div class="block">
						<img src="img/khzl.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mainFrame"><font>供应商资料</font></a>
					</div></td>
			</tr>

			<tr align="center" height="100">

				<td><div class="block">
						<img src="img/cgxx.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mainFrame"><font>采购信息</font></a>
					</div></td>

				<td><div class="block">
						<img src="img/cgth.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mainFrame"><font>采购退货</font></a>
					</div></td>

				<td><div class="block">
						<img src="img/xsxx.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mainFrame"><font>销售信息</font></a>
					</div></td>

				<td><div class="block">
						<img src="img/xsth.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mainFrame"><font>销售退货</font></a>
					</div></td>
			</tr>

			<tr align="center" height="100">

				<td><div class="block">
						<img src="img/kctj.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mainFrame"><font>库存统计</font></a>
					</div></td>

				<td><div class="block">
						<img src="img/xtwh.gif" onmouseover="border='1'"
							onmouseout="border='0'" />
						<p />
						<a href="" target="mainFrame"><font>系统维护</font></a>
					</div></td>
			</tr>

		</table>

	</center>

</body>

</html>