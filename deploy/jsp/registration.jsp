<%--
  Created by IntelliJ IDEA.
  User: gnu
  Date: 19.06.13
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>

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
                                         maxlength="255"
                                         requiredMessage="#{msg.registration_page_firstname_required}"
                                         validatorMessage="#{msg.registration_page_firstname_invalid_pattern}"
                                         value="#{newUserBean.firstname}">
                                <f:validateRegex pattern="[a-zA-Z]{2,255}"/>
                            </h:inputText>
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
                                         maxlength="255"
                                         requiredMessage="#{msg.registration_page_lastname_required}"
                                         validatorMessage="#{msg.registration_page_lastname_invalid_pattern}"
                                         value="#{newUserBean.lastname}">
                                <f:validateRegex pattern="[a-zA-Z]{2,255}"/>
                            </h:inputText>
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
                                         maxlength="255"
                                         validatorMessage="#{msg.registration_page_middlename_invalid_pattern}"
                                         value="#{newUserBean.middlename}">
                                <f:validateRegex pattern="[a-zA-Z]{2,255}"/>
                            </h:inputText>
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
                            <rich:calendar value="#{newUserBean.birthdate}"
                                           locale="en/US"
                                           popup="true"
                                           datePattern="dd/MM/yyyy"
                                           showApplyButton="false"
                                           cellWidth="24px"
                                           cellHeight="22px"
                                           style="width:200px"/>
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
                                         maxlength="255"
                                         requiredMessage="#{msg.registration_page_email_required}"
                                         validatorMessage="#{msg.registration_page_email_invalid_pattern}"
                                         value="#{newUserBean.email}">
                                <f:validateRegex pattern="[0-9A-Za-z._%+-]+@[0-9A-Za-z.-]+\.[A-Za-z]{2,4}"/>
                            </h:inputText>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="mobile_phone" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_mobile_phone}"/>
                        </td>
                        <td>
                            <h:inputText id="mobile_phone"
                                         styleClass="inputText inputBig"
                                         maxlength="55"
                                         validatorMessage="#{msg.registration_page_mobile_invalid_pattern}"
                                         value="#{newUserBean.mobileNumber}">
                                <f:validateRegex pattern="8[0-9]{3}[0-9]{3}[0-9]{2}[0-9]{2}|\+[0-9]{3}[0-9]{2}[0-9]{3}[0-9]{2}[0-9]{2}"/>
                            </h:inputText>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <rich:message for="work_phone" styleClass="error_main"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h:outputLabel value="#{msg.registration_page_label_work_phone}"/>
                        </td>
                        <td>
                            <h:inputText id="work_phone"
                                         styleClass="inputText inputBig"
                                         maxlength="55"
                                         validatorMessage="#{msg.registration_page_work_phone_invalid_pattern}"
                                         value="#{newUserBean.workPhoneNumber}">
                                <f:validateRegex pattern="8[0-9]{3}[0-9]{3}[0-9]{2}[0-9]{2}|\+[0-9]{3}[0-9]{2}[0-9]{3}[0-9]{2}[0-9]{2}"/>
                            </h:inputText>
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
                                         maxlength="255"
                                         requiredMessage="#{msg.registration_page_login_required}"
                                         validatorMessage="#{msg.registration_page_login_invalid_pattern}"
                                         value="#{newUserBean.login}">
                                <f:validateRegex pattern="[a-zA-Z0-9_]{5,255}"/>
                            </h:inputText>
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
                                           maxlength="255"
                                           requiredMessage="#{msg.registration_page_password_required}"
                                           value="#{newUserBean.password}"
                                           validator="#{newUserBean.validatePassword}"/>
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
                                           maxlength="255"
                                           requiredMessage="#{msg.registration_page_password_confirm_required}"
                                           binding="#{newUserBean.passwordBind}"/>
                        </td>
                    </tr>
                    <tr>
                         <td>
                            <h:commandLink id="doReg"
                                           styleClass="button"
                                           type="submit"
                                           value="#{msg.registration_page_button_enter}"
                                           action="#{newUserBean.addNewUser}"/>
                        </td>
                        <td>
                            <h:commandLink styleClass="button"
                                           type="submit"
                                           value="#{msg.registration_page_button_cancel}"
                                           immediate="true"
                                           action="login.faces"/>
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