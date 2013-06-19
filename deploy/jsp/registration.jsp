<%--
  Created by IntelliJ IDEA.
  User: gnu
  Date: 19.06.13
  Time: 9:58
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
        <title>${msg.page_title}</title>
    </head>
    <body>
    <div id="page">
        <div class="reg_form">
            <h3><h:outputText value="#{msg.registration_page_header}"/></h3>
            <h:outputText styleClass="requiredHead" value="#{msg.registration_page_required_label}"/>
            <h:form id="reg_form">
                <table class="info">
                    <tr style="height: 20px"></tr>
                    <tr>
                        <td></td>
                        <td>
                            <rich:message styleClass="error_main" for="doReg"/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="firstname" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_firstname}"/>
                            <h:outputLabel styleClass="error_main" value="#{msg.registration_page_label_asterisk}"/>
                        </td>
                        <td>
                            <h:inputText id="firstname"
                                         styleClass="inputText inputBig"
                                         required="true"
                                         requiredMessage="#{msg.registration_page_firstname_required}"
                                         value=""/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="lastname" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_lastname}"/>
                            <h:outputLabel styleClass="error_main" value="#{msg.registration_page_label_asterisk}"/>
                        </td>
                        <td>
                            <h:inputText id="lastname"
                                         styleClass="inputText inputBig"
                                         required="true"
                                         requiredMessage="#{msg.registration_page_lastname_required}"
                                         value=""/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="middlename" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_middlename}"/>
                        </td>
                        <td>
                            <h:inputText id="middlename"
                                         styleClass="inputText inputBig"
                                         value=""/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="birthdate" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_birthdate}"/>
                        </td>
                        <td>
                            <h:inputText id="birthdate"
                                         styleClass="inputText inputBig"
                                         value=""/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="email" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_email}"/>
                            <h:outputLabel styleClass="error_main" value="#{msg.registration_page_label_asterisk}"/>
                        </td>
                        <td>
                            <h:inputText id="email"
                                         styleClass="inputText inputBig"
                                         required="true"
                                         requiredMessage="#{msg.registration_page_email_required}"
                                         value=""/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="phone" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_phone}"/>
                        </td>
                        <td>
                            <h:inputText id="phone"
                                         styleClass="inputText inputBig"
                                         value=""/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="login" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_login}"/>
                            <h:outputLabel styleClass="error_main" value="#{msg.registration_page_label_asterisk}"/>
                        </td>
                        <td>
                            <h:inputText id="login"
                                         styleClass="inputText inputBig"
                                         required="true"
                                         requiredMessage="#{msg.registration_page_login_required}"
                                         value=""/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="password" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_password}"/>
                            <h:outputLabel styleClass="error_main" value="#{msg.registration_page_label_asterisk}"/>
                        </td>
                        <td>
                            <h:inputSecret id="password"
                                         styleClass="inputText inputBig"
                                         required="true"
                                         requiredMessage="#{msg.registration_page_password_required}"
                                         value=""/>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="conf_password" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_password_confirm}"/>
                            <h:outputLabel styleClass="error_main" value="#{msg.registration_page_label_asterisk}"/>
                        </td>
                        <td>
                            <h:inputSecret id="conf_password"
                                         styleClass="inputText inputBig"
                                         required="true"
                                         requiredMessage="#{msg.registration_page_password_confirm_required}"
                                         value=""/>
                        </td>
                    </tr>
                    <tr>
                         <td>
                            <h:commandLink id="doReg" styleClass="button" type="submit" value="#{msg.registration_page_button_enter}"/>
                        </td>
                        <td>
                            <h:commandLink styleClass="button" type="submit" value="#{msg.registration_page_button_cancel}" immediate="true" action="login.faces"/>
                        </td>
                    </tr>
                    <tr style="height: 20px"></tr>
                </table>

            </h:form>

        </div>
    </div>
    </body>
</f:view>
</html>