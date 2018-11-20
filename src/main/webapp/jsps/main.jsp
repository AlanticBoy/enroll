<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/17
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    /*
    String name= (String) request.getAttribute("name");
    response.getWriter().println(" get Name  "+name);
    */

    Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("map");
    if (map != null) {
        response.getWriter().println(map.get("age"));
        response.getWriter().write((String) map.get("name"));
        response.getWriter().write((String) map.get("gender"));
    }

%>

<a href="${pageContext.request.contextPath}/customServlet">Click Me</a>
</body>
</html>
