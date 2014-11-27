package by.goncharov.dragon.core.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Description of Role class
 *
 * @author Mikita Hancharou
 * @created 18.05.13 15:12
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    public Role() {
    }

    @Id
    @Column(name = "role_id")
    @GeneratedValue
    private Long roleId;

    @Column(unique = true, name = "role_name")
    private String roleName;

    @Column(name = "contact_type")
    private Integer type;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private Set<User> userSet;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public RoleType getContactType() {
        return RoleType.getEnum(type);
    }
}
