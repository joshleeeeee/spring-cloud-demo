package xyz.ljosh.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author joshlind
 * @date 2025/08/01
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ProductMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductMainApplication.class, args);
    }

}
