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
 * Description of GoodsCategory class
 *
 * @author Mikita Hancharou
 * @created 23.05.13 16:00
 */
@Entity
@Table(name = "goods_category")
public class GoodsCategory implements Serializable {

    public GoodsCategory() {
    }

    @Id
    @Column(name = "goods_category_id")
    @GeneratedValue
    private int goodsCatId;

    @Column(unique = true, name = "goods_category_name")
    private String goodsCategoryName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "charges_id", nullable = true)
    private Set<Charges> chargesSet;

    public int getGoodsCatId() {
        return goodsCatId;
    }

    public void setGoodsCatId(int goodsCatId) {
        this.goodsCatId = goodsCatId;
    }

    public String getGoodsCategoryName() {
        return goodsCategoryName;
    }

    public void setGoodsCategoryName(String gcName) {
        this.goodsCategoryName = gcName;
    }

    public Set<Charges> getChargesSet() {
        return chargesSet;
    }

    public void setChargesSet(Set<Charges> chargesSet) {
        this.chargesSet = chargesSet;
    }
}
