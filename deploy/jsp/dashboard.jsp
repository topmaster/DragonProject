<%--
  Created by IntelliJ IDEA.
  User: gnu
  Date: 13.06.13
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<f:view>
    <head>
        <jsp:include page="tiles/commonHeader.jsp"/>
        <title>${msg.page_title}</title>
    </head>
    <body>
    <div id="page">
        <jsp:include page="tiles/userHeader.jsp"/>
    </div>
    </body>
</f:view>
</html>