package by.goncharov.dragon.core.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Description of AimCategory class
 *
 * @author Mikita Hancharou
 * @created 28.05.13 15:20
 */
@Entity
@Table(name = "aim_category")
public class AimCategory implements Serializable {

    @Id
    @Column(name = "aim_category_id")
    @GeneratedValue
    private int aimCategoryId;

    @Column(name = "important")
    private Boolean important;

    @Column(name = "urgently")
    private Boolean urgently;

    @Column(name = "long_term")
    private Boolean longTerm;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "aim_id", nullable = true)
    private Set<Aim> aimSet;

    public int getAimCategoryId() {
        return aimCategoryId;
    }

    public void setAimCategoryId(int aimCategoryId) {
        this.aimCategoryId = aimCategoryId;
    }

    public Boolean isImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Boolean isUrgently() {
        return urgently;
    }

    public void setUrgently(Boolean urgently) {
        this.urgently = urgently;
    }

    public Boolean isLongTerm() {
        return longTerm;
    }

    public void setLongTerm(Boolean longTerm) {
        this.longTerm = longTerm;
    }

    public Set<Aim> getAimSet() {
        return aimSet;
    }

    public void setAimSet(Set<Aim> aimSet) {
        this.aimSet = aimSet;
    }
}
