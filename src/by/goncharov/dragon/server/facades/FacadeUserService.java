package by.goncharov.dragon.server.facades;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import by.goncharov.dragon.core.common.UserService;

/**
 * Description of FacadeUserService class
 *
 * @author Mikita Hancharou
 * @created 25.06.13 12:45
 */
@ManagedBean(name = "FacadeUserService")
@ApplicationScoped
public class FacadeUserService {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
