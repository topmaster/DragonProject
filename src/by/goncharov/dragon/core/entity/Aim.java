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
 * Description of Aim class
 *
 * @author Mikita Hancharou
 * @created 28.05.13 15:23
 */
@Entity
@Table(name = "aim")
public class Aim implements Serializable {

    @Id
    @Column(name = "aim_id")
    @GeneratedValue
    private Long aimId;

    @Column(name = "aim_name")
    private String aimName;

    @Column(name = "short_descr")
    private String shortDescription;

    @Column(name = "long_descr", length = 1024)
    private String longDescription;

    @Column(name = "plane_date")
    private Date planeDate;

    @Column(name = "red_line")
    private Date redLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_aim_category_id", nullable = false)
    private AimCategory aimCategory;

    public Long getAimId() {
        return aimId;
    }

    public void setAimId(Long aimId) {
        this.aimId = aimId;
    }

    public String getAimName() {
        return aimName;
    }

    public void setAimName(String aimName) {
        this.aimName = aimName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Date getPlaneDate() {
        return planeDate;
    }

    public void setPlaneDate(Date planeDate) {
        this.planeDate = planeDate;
    }

    public Date getRedLine() {
        return redLine;
    }

    public void setRedLine(Date redLine) {
        this.redLine = redLine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AimCategory getAimCategory() {
        return aimCategory;
    }

    public void setAimCategory(AimCategory aimCategory) {
        this.aimCategory = aimCategory;
    }
}
