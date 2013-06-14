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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Description of Charges class
 *
 * @author Mikita Hancharou
 * @created 23.05.13 16:07
 */
@Entity
@Table(name = "charges")
public class Charges implements Serializable {

    public Charges() {
    }

    @Id
    @Column(name = "charges_id")
    @GeneratedValue
    private int chargesId;

    @Column(name = "charges_article")
    private String chargesArticle;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @PrePersist
    protected void onCreate() {
        paymentDate = new Date();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_goods_category_id", nullable = false)
    private GoodsCategory goodsCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", nullable = false)
    private User user;

    public int getChargesId() {
        return chargesId;
    }

    public void setChargesId(int chargesId) {
        this.chargesId = chargesId;
    }

    public String getChargesArticle() {
        return chargesArticle;
    }

    public void setChargesArticle(String chargesArticle) {
        this.chargesArticle = chargesArticle;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public GoodsCategory getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(GoodsCategory goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
