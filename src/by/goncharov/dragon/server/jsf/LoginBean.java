package by.goncharov.dragon.server.jsf;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import by.goncharov.dragon.server.utils.DragonUtils;
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

    @Autowired
    @Qualifier("authenticationManager")
    protected AuthenticationManager authenticationManager;

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
        } catch (AuthenticationException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.getMessage(), e.getMessage()));
            return null;
        }
        return NavigationConstants.LOGIN_SUCCESS;
    }

    public String doLogout() throws IOException {
        this.username = DragonUtils.STRING_EMPTY;
        this.password = DragonUtils.STRING_EMPTY;

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/j_spring_security_logout");
        FacesContext.getCurrentInstance().responseComplete();

        return NavigationConstants.LOGOUT_SUCCESS;
    }
}
