package by.goncharov.dragon.core.dao;

import by.goncharov.dragon.core.entity.GoodsCategory;

/**
 * Description of GoodsCategoryDAO class
 *
 * @author Mikita Hancharou
 * @created 24.05.13 10:20
 */
public interface GoodsCategoryDAO {

    int save(GoodsCategory goodsCategory);

    void update(GoodsCategory goodsCategory);

    void delete(GoodsCategory goodsCategory);

    GoodsCategory findByGoodsCategoryId(int goodsCategoryId);
}
