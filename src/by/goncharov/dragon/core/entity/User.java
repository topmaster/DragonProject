package by.goncharov.dragon.core.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Description of User class
 *
 * @author Mikita Hancharou
 * @created 23.05.13 12:47
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    public User() {
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private int userId;

    @Column(unique = true, name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_role_id", nullable = false)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "charges_id", nullable = true)
    private Set<Charges> chargesSet;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = true)
    private Set<Contact> contactSet;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "aim_id", nullable = true)
    private Set<Aim> aimSet;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Charges> getChargesSet() {
        return chargesSet;
    }

    public void setChargesSet(Set<Charges> chargesSet) {
        this.chargesSet = chargesSet;
    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {
        this.contactSet = contactSet;
    }

    public Set<Aim> getAimSet() {
        return aimSet;
    }

    public void setAimSet(Set<Aim> aimSet) {
        this.aimSet = aimSet;
    }
}
