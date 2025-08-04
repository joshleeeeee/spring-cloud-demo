package xyz.ljosh.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author joshlind
 * @date 2025/08/01
 */
@Data
public class Product {

    private Long id;

    private BigDecimal price;

    private String productName;

    private int num;

}
