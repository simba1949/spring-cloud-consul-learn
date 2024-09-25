package vip.openpark.service.discovery.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author anthony
 * @version 2024-09-25
 * @since 2024-09-25 19:15
 */
@Configuration
public class BeanConfig {
	/**
	 * 引入负载均衡的 RestTemplate
	 * {@link RestTemplate}
	 * {@link org.springframework.web.reactive.function.client.WebClient.Builder}
	 *
	 * @return RestTemplate
	 */
	@Bean
	@LoadBalanced
	public RestTemplate loadbalancedRestTemplate() {
		return new RestTemplate();
	}
}