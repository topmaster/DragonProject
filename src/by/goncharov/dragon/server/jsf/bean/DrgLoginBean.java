package by.goncharov.dragon.server.jsf.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;

import by.goncharov.dragon.server.utils.DrgFacadeUtils;
import by.goncharov.dragon.server.utils.DrgWebConstants;
import by.goncharov.dragon.server.utils.DrgWebUtils;
import by.goncharov.dragon.server.utils.NavigationConstants;

/**
 * Description of DrgLoginBean class
 *
 * @author Mikita Hancharou
 * @created 13.06.13 15:05
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class DrgLoginBean {

    private static final Logger LOGGER = Logger.getLogger(DrgLoginBean.class);

    private static final String LOGIN_FORM_DO_LOGIN = "loginForm:doLogin";

    private String username;

    private String password;

    public DrgLoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String doLogin() throws IOException {
        try {
            DrgFacadeUtils.getUserService().loginService(this.username, this.password);
            return NavigationConstants.LOGIN_SUCCESS;
        } catch (AuthenticationServiceException e) {
            LOGGER.error(DrgWebUtils.getFormattedProperty(DrgWebConstants.RESOURCE_BUNDLE_UI, "login_page_jdbc_error",
                    e.getMessage()));
            DrgWebUtils.sendFacesMessage(LOGIN_FORM_DO_LOGIN, "login_page_jdbc_error_ui", null,
                    FacesMessage.SEVERITY_ERROR);
            return null;
        } catch (AuthenticationException e) {
            LOGGER.error(DrgWebUtils.getFormattedProperty(DrgWebConstants.RESOURCE_BUNDLE_UI,
                    "login_page_authentication_error", this.username, this.password, e.getMessage()));
            DrgWebUtils.sendFacesMessage(LOGIN_FORM_DO_LOGIN, "login_page_authentication_error_ui", null,
                    FacesMessage.SEVERITY_ERROR);
            return null;
        }
    }

    public String doLogout() throws IOException {
        this.username = DrgWebConstants.STRING_EMPTY;
        this.password = DrgWebConstants.STRING_EMPTY;

        DrgFacadeUtils.getUserService().logoutService();

        return NavigationConstants.LOGOUT_SUCCESS;
    }
}
