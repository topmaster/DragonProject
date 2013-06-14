<%--
  Created by IntelliJ IDEA.
  User: gnu
  Date: 11.06.13
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="rich" uri="http://java.sun.com/jsf/html" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<f:view>
    <head>
        <jsp:include page="tiles/commonHeader.jsp"/>
        <title>Dragon Project</title>
    </head>
    <body>
    <div id="page">
        <div class="header_login">
            <div class="logo"><a href="#"><img src="img/Dragon.png" alt="" title="" border="0"/></a></div>

        </div>


        <div class="login_form">

            <h3><h:outputText value="Dragon Project"/></h3>

<%--
            <h:outputLink styleClass="forgot_pass" value="">
                <h:outputText value="Forgot password"/>
            </h:outputLink>
--%>

            <h:form>
                <table border="0" cellpadding="5" cellspacing="0">
                    <tr style="height: 40px"></tr>
                    <tr>
                        <td colspan="2">
                            <h:outputText styleClass="error_main" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="usnm" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="Login:"/>
                        </td>
                        <td>
                            <h:inputText id="usnm"
                                         styleClass="inputText inputBig"
                                         required="true"
                                         requiredMessage="Enter login"
                                         value="#{loginBean.login}"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="psw" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="Password:"/>
                        </td>
                        <td>
                            <h:inputSecret id="psw"
                                           styleClass="inputText inputBig"
                                           required="true"
                                           requiredMessage="Enter password"/>
                        </td>
                    </tr>
<%--                    <tr>
                        <td></td>
                        <td>
                            <h:selectBooleanCheckbox title="Remember me" immediate="true"/>
                            <h:outputLabel styleClass="rememberMe" value="Remember me"/>
                        </td>
                    </tr>--%>
                    <tr>
                        <td></td>
                        <td>
                            <h:commandLink styleClass="button" value="Enter"/>
                        </td>
                    </tr>
                </table>
            </h:form>

        </div>

    </div>
    </body>
</f:view>
</html>