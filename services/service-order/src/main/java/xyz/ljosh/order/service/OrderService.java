package xyz.ljosh.order.service;

import xyz.ljosh.order.bean.Order;

/**
 * @author joshlind
 * @date 2025/08/01
 */
public interface OrderService {
    Order createOrder(Long productId, Long userId);

}
