package by.goncharov.dragon.core.dao;

import org.springframework.transaction.annotation.Transactional;

import by.goncharov.dragon.core.entity.GoodsCategory;

/**
 * Description of GoodsCategoryDAOImpl class
 *
 * @author Mikita Hancharou
 * @created 24.05.13 10:22
 */
public class GoodsCategoryDAOImpl extends BaseDAO implements GoodsCategoryDAO {

    @Override
    @Transactional(readOnly = false)
    public void save(GoodsCategory goodsCategory) {
        super.save(goodsCategory);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(GoodsCategory goodsCategory) {
        super.delete(goodsCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public GoodsCategory find(Long goodsCatId) {
        return (GoodsCategory) super.find(GoodsCategory.class, goodsCatId);
    }
}
