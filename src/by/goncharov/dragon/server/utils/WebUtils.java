package by.goncharov.dragon.server.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Description of WebUtils class
 *
 * @author Mikita Hancharou
 * @created 18.06.13 11:55
 */
public class WebUtils {

    private WebUtils() {
    }

    public static String getFormattedProperty(String propFile, String propName, Object... params) {
        String property = getProperty(propFile, propName);
        if (params != null && params.length > 0) {
            MessageFormat messageFormat = new MessageFormat(property);
            StringBuffer buf = new StringBuffer();
            messageFormat.format(params, buf, null);
            String result = buf.toString();
            return result;
        } else {
            return property;
        }
    }

    private static String getProperty(String propFile, String propName) {
        return ResourceBundle.getBundle(propFile, getCurrentLocale()).getString(propName).trim();
    }

    private static Locale getCurrentLocale() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getViewRoot().getLocale();
    }

    public static void sendFacesMessage(String id, String propName, String errDetail, Severity severity) {
        FacesMessage facesMessage = new FacesMessage(severity,
                getProperty(WebConstants.RESOURCE_BUNDLE_UI, propName), errDetail);
        FacesContext.getCurrentInstance().addMessage(id, facesMessage);
    }

    public static boolean isStringEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String trimString(String str) {
        return str == null ? WebConstants.STRING_EMPTY : str.trim();
    }
}
