package xyz.ljosh.product.service.impl;
import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.ljosh.product.bean.Product;
import xyz.ljosh.product.service.ProductService;

/**
 * @author joshlind
 * @date 2025/08/01
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProduct(Long id) {
        // 模拟返回一个商品
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("114514"));
        product.setProductName("MacBook Pro " + id);
        product.setNum(2);
        log.info("查询商品：{}", product);
        return product;
    }
}
