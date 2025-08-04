package xyz.ljosh.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import xyz.ljosh.order.bean.Order;
import xyz.ljosh.order.properties.OrderProperties;
import xyz.ljosh.order.service.OrderService;

/**
 * @author joshlind
 * @date 2025/08/01
 */
@RestController
@RequestMapping("/order")
@RefreshScope
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final OrderProperties orderProperties;

    @GetMapping("/create")
    public Order createOrder(@RequestParam Long productId,@RequestParam Long userId) {
        return orderService.createOrder(productId, userId);
    }

    @GetMapping("/config")
    public String config() {
        return orderProperties.toString();
    }

}
