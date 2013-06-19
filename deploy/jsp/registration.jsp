<%--
  Created by IntelliJ IDEA.
  User: gnu
  Date: 19.06.13
  Time: 9:58
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
        <div class="reg_form">
            <h3><h:outputText value="#{msg.registration_page_header}"/></h3>
            <h:outputText styleClass="requiredHead" value="#{msg.registration_page_required_label}"/>

        </div>
    </div>
    </body>
</f:view>
</html>