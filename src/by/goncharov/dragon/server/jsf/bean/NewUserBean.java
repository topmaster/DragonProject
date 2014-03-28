package by.goncharov.dragon.server.jsf.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.hibernate.exception.ConstraintViolationException;

import by.goncharov.dragon.core.entity.Contact;
import by.goncharov.dragon.core.entity.Role;
import by.goncharov.dragon.core.entity.User;
import by.goncharov.dragon.server.utils.FacadeUtils;
import by.goncharov.dragon.server.utils.NavigationConstants;
import by.goncharov.dragon.server.utils.WebConstants;
import by.goncharov.dragon.server.utils.WebUtils;

/**
 * Description of NewUserBean class
 *
 * @author Mikita Hancharou
 * @created 21.06.13 16:22
 */
@ManagedBean(name = "newUserBean")
@RequestScoped
public class NewUserBean {

    private static final String PASSWORD_INVALID_LENGTH_PROP_KEY = "registration_page_password_invalid_length";
    private static final String PASSWORD_INVALID_PATTERN_PROP_KEY = "registration_page_password_invalid_pattern";
    private static final String PASSWORD_INVALID_CONFIRM_PROP_KEY = "registration_page_password_invalid_confirm";
    private static final String REG_FORM_PASSWORD_ID = "reg_form:password";
    private static final String REG_FORM_LOGIN_ID = "reg_form:login";
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

    public HtmlInputSecret getPasswordBind() {
        return passwordBind;
    }

    public void setPasswordBind(HtmlInputSecret passwordBind) {
        this.passwordBind = passwordBind;
    }

    public String addNewUser() {
        try {
            FacadeUtils.getUserService().saveNewUser(prepareNewUserEntity(), prepareNewUserInfo());
            return NavigationConstants.REGISTRATION_SUCCESS;
        } catch (ConstraintViolationException cvEx) {
            WebUtils.sendFacesMessage(REG_FORM_LOGIN_ID, "registration_page_login_constrain_invalid", null, FacesMessage.SEVERITY_ERROR);
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void validatePassword(FacesContext facesContext, UIComponent uIComponent, Object value)
            throws ValidatorException {
        String password = value.toString();
        if (password.length() < 5) {
            WebUtils.sendFacesMessage(REG_FORM_PASSWORD_ID, PASSWORD_INVALID_LENGTH_PROP_KEY, null, FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(new FacesMessage(WebUtils.getFormattedProperty(WebConstants.RESOURCE_BUNDLE_UI, PASSWORD_INVALID_LENGTH_PROP_KEY)));
        }
        boolean matches = Pattern.matches(PASSWORD_PATTERN, password);
        if (!matches) {
            WebUtils.sendFacesMessage(REG_FORM_PASSWORD_ID, PASSWORD_INVALID_PATTERN_PROP_KEY, null, FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(new FacesMessage(WebUtils.getFormattedProperty(WebConstants.RESOURCE_BUNDLE_UI, PASSWORD_INVALID_PATTERN_PROP_KEY)));
        }
        if (!WebUtils.isStringEmpty(passwordBind.getSubmittedValue().toString())) {
            validateConfirmPassword(value);
        }
    }
    private void validateConfirmPassword(Object password) throws ValidatorException {
        if (!password.equals(passwordBind.getSubmittedValue())) {
            WebUtils.sendFacesMessage(REG_FORM_PASSWORD_ID, PASSWORD_INVALID_CONFIRM_PROP_KEY, null, FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(new FacesMessage(WebUtils.getFormattedProperty(WebConstants.RESOURCE_BUNDLE_UI, PASSWORD_INVALID_CONFIRM_PROP_KEY)));
        }
    }

    private Contact prepareNewUserInfo() {
        Contact contact = new Contact();
        DateFormat dateFormat = new SimpleDateFormat(WebConstants.BIRTHDATE_PATTERN);
        contact.setFirstname(WebUtils.trimString(firstname));
        contact.setLastname(WebUtils.trimString(lastname));
        contact.setMiddlename(WebUtils.trimString(middlename));
        String birthdateStr = WebConstants.STRING_EMPTY;
        if (birthdate != null) {
            birthdateStr = dateFormat.format(birthdate);
        }//if
        contact.setBirthdate(WebUtils.trimString(birthdateStr));
        contact.setEmail(WebUtils.trimString(email));
        contact.setMobileNumber(WebUtils.trimString(mobileNumber));
        contact.setWorkPhoneNumber(WebUtils.trimString(workPhoneNumber));
        contact.setType(WebConstants.CONTACT_TYPE_OWNER);
        contact.setComments(WebConstants.STRING_EMPTY);
        return contact;
    }

    private User prepareNewUserEntity() {
        User user = new User();
        user.setUsername(WebUtils.trimString(login));
        user.setPassword(WebUtils.trimString(password));
        user.setRole(prepareUserRole());
        return user;
    }

    private Role prepareUserRole() {
        Role role = new Role();
        role.setRoleName(WebConstants.ROLE_USER);
        role.setRoleId(WebConstants.ROLE_USER_ID);
        return role;
    }


}
