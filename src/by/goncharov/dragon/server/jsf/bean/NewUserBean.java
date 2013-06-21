package by.goncharov.dragon.server.jsf.bean;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import by.goncharov.dragon.server.utils.DragonWebConstants;
import by.goncharov.dragon.server.utils.DragonWebUtils;

/**
 * Description of NewUserBean class
 *
 * @author Mikita Hancharou
 * @created 21.06.13 16:22
 */
@ManagedBean(name = "newUserBean")
@RequestScoped
public class NewUserBean {

    private static final String PASSWORD_PATTERN = "[^A-Za-z0-9\\.\\@_\\-~#]+";

    private String firstname;
    private String lastname;
    private String middlename;
    private String birthdate;
    private String email;
    private String mobileNumber;
    private String workPhoneNumber;
    private String login;
    private UIInput password;
    private String confirmPassword;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UIInput getPassword() {
        return password;
    }

    public void setPassword(UIInput password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void validateConfirmPassword(FacesContext facesContext, UIComponent uIComponent, Object value) throws
                ValidatorException {

        boolean b = Pattern.matches(PASSWORD_PATTERN, value.toString());
        if (!b) {
            DragonWebUtils.sendFacesMessage("reg_form:password", "registration_page_password_invalid_pattern", null,
                                FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(new FacesMessage(DragonWebUtils.getFormattedProperty(
                    DragonWebConstants.RESOURCE_BUNDLE_UI, "registration_page_password_invalid_pattern")));
        }
        if (!value.equals(password.getLocalValue().toString())) {
            DragonWebUtils.sendFacesMessage("reg_form:password", "registration_page_password_invalid_confirm", null,
                                FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(new FacesMessage(DragonWebUtils.getFormattedProperty(
                    DragonWebConstants.RESOURCE_BUNDLE_UI, "registration_page_password_invalid_confirm")));
        }
        if (value.toString().length() > 5) {
            DragonWebUtils.sendFacesMessage("reg_form:password", "registration_page_password_invalid_length", null,
                    FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(new FacesMessage(DragonWebUtils.getFormattedProperty(
                    DragonWebConstants.RESOURCE_BUNDLE_UI, "registration_page_password_invalid_length")));
        }
    }
}
