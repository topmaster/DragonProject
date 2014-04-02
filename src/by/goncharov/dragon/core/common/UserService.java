package by.goncharov.dragon.core.common;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import by.goncharov.dragon.core.dao.ContactDAO;
import by.goncharov.dragon.core.dao.UserDAO;
import by.goncharov.dragon.core.entity.Contact;
import by.goncharov.dragon.core.entity.User;

/**
 * Description of UserService class
 *
 * @author Mikita Hancharou
 * @created 25.06.13 12:22
 */
@Service
public class UserService {

    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ContactDAO contactDAO;

    public void loginService(String username, String password) throws AuthenticationException {
        Authentication request = new UsernamePasswordAuthenticationToken(username, password);
        Authentication result = authenticationManager.authenticate(request);
        SecurityContextHolder.getContext().setAuthentication(result);
    }

    public void logoutService() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/j_spring_security_logout");
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void saveNewUser(User user, Contact contact) {
        userDAO.save(user);
        contact.setUser(user);
        contactDAO.save(contact);
    }

}
