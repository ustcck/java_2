<%--
  Created by IntelliJ IDEA.
  User: ustcck
  Date: 2016/10/9
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>account</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/AccountServlet" method="post">
  转入账户：<input type="text" name="accountin"><br>
  转出账户：<input type="text" name="accountout"><br>
  金额：<input type="text" name="money"><br>
  <input type="submit" value="提交">
</form>

</body>
</html>
