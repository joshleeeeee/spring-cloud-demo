package xyz.ljosh.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author joshlind
 * @date 2025/08/04
 */
@FeignClient(value = "baidu-api", url = "baidu.com")
public interface BaiduApi {


    @GetMapping("/s?wd={query}")
    String queryBaidu(@PathVariable String query);

}
