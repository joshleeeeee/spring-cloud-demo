package xyz.ljosh.order.bean;

import lombok.Data;
import xyz.ljosh.product.bean.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author joshlind
 * @date 2025/08/01
 */
@Data
public class Order {

    private Long id;

    private BigDecimal totalAmount;

    private Long userId;

    private String nickName;

    private String address;

    private List<Product> productList;

}
