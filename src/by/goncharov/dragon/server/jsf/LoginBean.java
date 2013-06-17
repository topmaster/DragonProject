package by.goncharov.dragon.server.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Component;

import by.goncharov.dragon.server.utils.NavigationConstants;

/**
 * Description of LoginBean class
 *
 * @author Mikita Hancharou
 * @created 13.06.13 15:05
 */
@Component
@ManagedBean
@RequestScoped
public class LoginBean {

    /** The login. */
   	private String login;

   	/** The password. */
   	private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        return NavigationConstants.LOGIN_SUCCESS;
    }
}
