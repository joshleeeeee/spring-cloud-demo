package xyz.ljosh.order.service.impl;
import java.math.BigDecimal;
import java.util.List;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.ljosh.order.bean.Order;
import xyz.ljosh.order.feign.ProductFeignClient;
import xyz.ljosh.order.service.OrderService;
import xyz.ljosh.product.bean.Product;

/**
 * @author joshlind
 * @date 2025/08/01
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;

    private final ProductFeignClient productFeignClient;


    @Override
    public Order createOrder(Long productId, Long userId) {
        // 根据商品 id 查询商品信息
//        Product product = this.getProductFromRemote(productId);
//        Product product = this.getProductFromRemoteWithLB(productId);
//        Product product = this.getProductFromRemoteWithLBAnnotation(productId);
        Product product = productFeignClient.getProduct(productId);

        Order order = new Order();
        order.setId(1L);
        // 计算商品金额
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("josh");
        order.setAddress("shenzhen");
        // 获取商品列表
        order.setProductList(List.of(product));

        return order;
    }

    private Product getProductFromRemote(Long productId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance serviceInstance = instances.get(0);
        String ip = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://" + ip + ":" + port + "/product/" + productId;
        return restTemplate.getForObject(url, Product.class);
    }

    private Product getProductFromRemoteWithLB(Long productId) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-product");
        String ip = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://" + ip + ":" + port + "/product/" + productId;
        log.info("url: {}", url);
        return restTemplate.getForObject(url, Product.class);
    }

    private Product getProductFromRemoteWithLBAnnotation(Long productId) {
        String url = "http://service-product/product/" + productId;
        return restTemplate.getForObject(url, Product.class);
    }
}
