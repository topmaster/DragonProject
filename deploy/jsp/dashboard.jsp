<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gnu
  Date: 13.06.13
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<f:view>
    <head>
        <jsp:include page="tiles/commonHeader.jsp"/>
        <title>Dragon Project</title>
    </head>
    <body>
    <div id="page">
        <div class="header">
            <div class="logo"><a href="#"><img src="img/logo.gif" alt="" title="" border="0"/></a></div>

            <div class="right_header">Welcome Admin |
                <a href="#" class="messages">(3) Messages</a> | <a href="#" class="logout">Logout</a>
            </div>
        </div>

    </div>
    </body>
</f:view>
</html>