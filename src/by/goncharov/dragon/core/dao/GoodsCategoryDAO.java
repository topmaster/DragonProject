package by.goncharov.dragon.core.dao;

import by.goncharov.dragon.core.entity.GoodsCategory;

/**
 * Description of GoodsCategoryDAO class
 *
 * @author Mikita Hancharou
 * @created 24.05.13 10:20
 */
public interface GoodsCategoryDAO {

    void save(GoodsCategory goodsCategory);

    void delete(GoodsCategory goodsCategory);

    GoodsCategory find(Long goodsCatId);
}
