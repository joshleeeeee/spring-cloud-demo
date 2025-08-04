package xyz.ljosh.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author joshlind
 * @date 2025/08/02
 */
@ConfigurationProperties(prefix = "order") // 配置批量绑定在 nacos 下，可以无需@RefreshScope就能实现自动刷新
@Configuration
@Data
public class OrderProperties {

    private String timeout;

    private String autoConfirm;

}
