package by.goncharov.dragon.core.common;

import java.io.IOException;

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
import org.springframework.stereotype.Service;

/**
 * Description of UserService class
 *
 * @author Mikita Hancharou
 * @created 25.06.13 12:22
 */
@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @Autowired
    @Qualifier("authenticationManager")
    protected AuthenticationManager authenticationManager;

    public void loginService(String username, String password)
            throws AuthenticationServiceException, AuthenticationException {
        Authentication request = new UsernamePasswordAuthenticationToken(username, password);
        Authentication result = authenticationManager.authenticate(request);
        SecurityContextHolder.getContext().setAuthentication(result);
    }

    public void logoutService() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/j_spring_security_logout");
        FacesContext.getCurrentInstance().responseComplete();
    }

}
