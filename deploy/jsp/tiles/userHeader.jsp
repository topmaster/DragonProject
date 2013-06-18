<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<div class="header">
    <div class="logo"><a href="#"><img src="img/logo.gif" alt="" title="" border="0"/></a></div>
    <h:form>
        <div class="right_header"><h:outputText value="#{msg.common_header_label_welcome}"/> Admin |
            <a href="#" class="messages">(3) <h:outputText value="#{msg.common_header_label_messages}"/></a> |
            <h:commandLink styleClass="logout" type="submit" value="#{msg.common_header_link_logout}" action="#{loginBean.doLogout}"/>
        </div>
    </h:form>
</div>
