package top.qingchen.basicweb.entity.bean;

import org.springframework.context.annotation.Bean;

/**
 * @author qingchen
 * @date 27/10/2023 上午 9:23
 */

public class ServerEndpointExporter {
    /**
     \* WebSocket的支持
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
