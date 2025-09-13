package xyz.ljosh.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.ljosh.order.feign.BaiduApi;

/**
 * @author joshlind
 * @date 2025/08/04
 */
@Slf4j
@SpringBootTest
public class OpenFeignTest {

    @Autowired
    BaiduApi baiduApi;

    @Test
    void testBaidu() {
        log.info("baidu: {}", baiduApi.queryBaidu("百度"));
    }

}
