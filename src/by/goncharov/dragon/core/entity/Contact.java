package by.goncharov.dragon.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Description of Contact class
 *
 * @author Mikita Hancharou
 * @created 28.05.13 12:34
 */
@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    public Contact() {
    }

    @Id
    @Column(name = "contact_id")
    @GeneratedValue
    private int cintactId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "comments", length = 1024)
    private String comments;

    @Column(name = "contact_type")
    private int type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", nullable = false)
    private User user;

    public int getCintactId() {
        return cintactId;
    }

    public void setCintactId(int cintactId) {
        this.cintactId = cintactId;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getType() {
        return type;
    }

    public void setType(int contactType) {
        this.type = contactType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ContactType getContactType() {
        return ContactType.getEnum(type);
    }
}
