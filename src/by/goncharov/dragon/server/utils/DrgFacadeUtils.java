package by.goncharov.dragon.server.utils;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import by.goncharov.dragon.core.common.UserService;
import by.goncharov.dragon.server.facades.FacadeUserService;

/**
 * Description of DrgFacadeUtils class
 *
 * @author Mikita Hancharou
 * @created 25.06.13 15:29
 */
public class DrgFacadeUtils {

    public static UserService getUserService(){
        return getFacadeBean("FacadeUserService", FacadeUserService.class).getUserService();
    }

    private static <T> T getFacadeBean(final String beanName, final Class<T> clazz) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        return (T) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, beanName);
    }
}
