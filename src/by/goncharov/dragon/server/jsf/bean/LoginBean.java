package by.goncharov.dragon.server.jsf.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import by.goncharov.dragon.server.utils.DragonWebConstants;
import by.goncharov.dragon.server.utils.DragonWebUtils;
import by.goncharov.dragon.server.utils.NavigationConstants;

/**
 * Description of LoginBean class
 *
 * @author Mikita Hancharou
 * @created 13.06.13 15:05
 */
@ManagedBean(name = "loginBean")
@RequestScoped
@Component
public class LoginBean {

    private Logger logger = Logger.getLogger(LoginBean.class);

    @Autowired
    @Qualifier("authenticationManager")
    protected AuthenticationManager authenticationManager;

    private static final String LOGIN_FORM_DO_LOGIN = "loginForm:doLogin";

    private String username;

    private String password;

    public LoginBean() {
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
            Authentication request = new UsernamePasswordAuthenticationToken(this.username, this.password);
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            return NavigationConstants.LOGIN_SUCCESS;
        } catch (AuthenticationServiceException e) {
            logger.error(DragonWebUtils.getFormattedProperty(DragonWebConstants.RESOURCE_BUNDLE_UI,
                    "login_page_jdbc_error", e.getMessage()));
            DragonWebUtils.sendFacesMessage(LOGIN_FORM_DO_LOGIN, "login_page_jdbc_error_ui", null,
                    FacesMessage.SEVERITY_ERROR);
            return null;
        } catch (AuthenticationException e) {
            logger.error(DragonWebUtils.getFormattedProperty(DragonWebConstants.RESOURCE_BUNDLE_UI,
                    "login_page_authentication_error", this.username, this.password, e.getMessage()));
            DragonWebUtils.sendFacesMessage(LOGIN_FORM_DO_LOGIN, "login_page_authentication_error_ui", null,
                    FacesMessage.SEVERITY_ERROR);
            return null;
        }
    }

    public String doLogout() throws IOException {
        this.username = DragonWebConstants.STRING_EMPTY;
        this.password = DragonWebConstants.STRING_EMPTY;

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/j_spring_security_logout");
        FacesContext.getCurrentInstance().responseComplete();

        return NavigationConstants.LOGOUT_SUCCESS;
    }
}
