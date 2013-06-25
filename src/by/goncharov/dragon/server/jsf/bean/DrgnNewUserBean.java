package by.goncharov.dragon.server.jsf.bean;

import java.util.Date;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import by.goncharov.dragon.server.utils.DrgnWebConstants;
import by.goncharov.dragon.server.utils.DrgnWebUtils;

/**
 * Description of DrgnNewUserBean class
 *
 * @author Mikita Hancharou
 * @created 21.06.13 16:22
 */
@ManagedBean(name = "newUserBean")
@RequestScoped
public class DrgnNewUserBean {

    private static final Logger LOGGER = Logger.getLogger(DrgnLoginBean.class);

    private static final String PASSWORD_INVALID_LENGTH_PROP_KEY = "registration_page_password_invalid_length";
    private static final String PASSWORD_INVALID_PATTERN_PROP_KEY = "registration_page_password_invalid_pattern";
    private static final String PASSWORD_INVALID_CONFIRM_PROP_KEY = "registration_page_password_invalid_confirm";
    private static final String REG_FORM_PASSWORD_ID = "reg_form:password";
    private static final String PASSWORD_PATTERN = "[a-zA-Z0-9]{5,255}";

    private HtmlInputSecret passwordBind;

    private String firstname;
    private String lastname;
    private String middlename;
    private Date birthdate;
    private String email;
    private String mobileNumber;
    private String workPhoneNumber;
    private String login;
    private String password;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public HtmlInputSecret getPasswordBind() {
        return passwordBind;
    }

    public void setPasswordBind(HtmlInputSecret passwordBind) {
        this.passwordBind = passwordBind;
    }

    public void validatePassword(FacesContext facesContext, UIComponent uIComponent, Object value)
            throws ValidatorException {
        String password = value.toString();
        if (password.length() < 5) {
            LOGGER.error(DrgnWebUtils.getFormattedProperty(DrgnWebConstants.RESOURCE_BUNDLE_UI,
                    PASSWORD_INVALID_LENGTH_PROP_KEY));
            DrgnWebUtils.sendFacesMessage(REG_FORM_PASSWORD_ID, PASSWORD_INVALID_LENGTH_PROP_KEY, null,
                    FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(new FacesMessage(DrgnWebUtils
                    .getFormattedProperty(DrgnWebConstants.RESOURCE_BUNDLE_UI, PASSWORD_INVALID_LENGTH_PROP_KEY)));
        }
        boolean matches = Pattern.matches(PASSWORD_PATTERN, password);
        if (!matches) {
            LOGGER.error(DrgnWebUtils.getFormattedProperty(DrgnWebConstants.RESOURCE_BUNDLE_UI,
                    PASSWORD_INVALID_PATTERN_PROP_KEY));
            DrgnWebUtils.sendFacesMessage(REG_FORM_PASSWORD_ID, PASSWORD_INVALID_PATTERN_PROP_KEY, null,
                    FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(new FacesMessage(DrgnWebUtils
                    .getFormattedProperty(DrgnWebConstants.RESOURCE_BUNDLE_UI, PASSWORD_INVALID_PATTERN_PROP_KEY)));
        }
        if (!DrgnWebUtils.isStringEmpty(passwordBind.getSubmittedValue().toString())) {
            validateConfirmPassword(value);
        }
    }

    private void validateConfirmPassword(Object password) throws ValidatorException {
        if (!password.equals(passwordBind.getSubmittedValue())) {
            LOGGER.error(DrgnWebUtils.getFormattedProperty(DrgnWebConstants.RESOURCE_BUNDLE_UI,
                    PASSWORD_INVALID_CONFIRM_PROP_KEY));
            throw new ValidatorException(new FacesMessage(
                    DrgnWebUtils.getFormattedProperty(DrgnWebConstants.RESOURCE_BUNDLE_UI,
                            PASSWORD_INVALID_CONFIRM_PROP_KEY)));
        }
    }
}
