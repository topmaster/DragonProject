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
        <title>${msg.login_page_title}</title>
    </head>
    <body>
    <div id="page">
        <div class="header_login">
            <div class="logo"><a href="#"><img src="img/Dragon.png" alt="" title="" border="0"/></a></div>
        </div>


        <div class="login_form">

            <h3><h:outputText value="#{msg.login_page_header}"/></h3>

            <h:outputLink styleClass="forgot_pass" value="">
                <h:outputText value="#{msg.login_page_link_forgot_password}"/>
            </h:outputLink>

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
                        <td colspan="2">
                            <rich:message for="usnm" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.login_page_label_login}"/>
                        </td>
                        <td colspan="2">
                            <h:inputText id="usnm"
                                         styleClass="inputText inputBig"
                                         required="true"
                                         requiredMessage="#{msg.login_page_login_required}"
                                         value="#{loginBean.login}"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <rich:message for="psw" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.login_page_label_password}"/>
                        </td>
                        <td colspan="2">
                            <h:inputSecret id="psw"
                                           styleClass="inputText inputBig"
                                           required="true"
                                           requiredMessage="#{msg.login_page_password_required}"
                                           value="#{loginBean.password}"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <h:selectBooleanCheckbox immediate="true"/>
                            <h:outputLabel styleClass="rememberMe" value="#{msg.login_page_label_check_box_remember_me}"/>
                        </td>
                        <td>
                            <h:outputLink styleClass="registration" value="">
                                <h:outputText value="#{msg.login_page_link_registration}"/>
                            </h:outputLink>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <h:commandLink styleClass="button" value="#{msg.login_page_button_enter}" action="#{loginBean.login}"/>
                        </td>
                    </tr>
                </table>
            </h:form>

        </div>

    </div>
    </body>
</f:view>
</html>