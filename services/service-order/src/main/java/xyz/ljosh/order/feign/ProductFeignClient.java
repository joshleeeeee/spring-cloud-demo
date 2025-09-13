package xyz.ljosh.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.ljosh.product.bean.Product;

/**
 * @author joshlind
 * @date 2025/08/04
 */
@FeignClient(value = "service-product", path = "product") // 服务名
public interface ProductFeignClient {

    @GetMapping("/{id}")
    Product getProduct(@PathVariable Long id);

}
