package vip.openpark.service.discovery.consumer.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author anthony
 * @version 2024-09-25
 * @since 2024-09-25 17:31
 */
@Slf4j
@RestController
@RequestMapping
public class ConsumerHelloController {
	@Resource
	private DiscoveryClient discoveryClient;
	@Resource
	private RestTemplate restTemplate;

	/**
	 * 获取服务
	 *
	 * @return String
	 */
	@GetMapping("/discovery")
	public String discovery() {
		// 获取所有服务名称
		List<String> services = discoveryClient.getServices();
		services.forEach(service -> log.info("service: {}", service));

		services.forEach(serviceName -> {
			// 根据服务名称获取服务实例
			List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
			instances.forEach(instance -> log.info("instance: {}", instance));
		});
		return "SUCCESS";
	}

	/**
	 * 调用服务提供者
	 *
	 * @param name 名称
	 * @return String
	 */
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", required = false) String name) {
		String serviceName = "service-discovery-provider";

		List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
		instances.forEach(instance -> log.info("instance: {}", instance));

		return restTemplate.getForObject("http://" + serviceName + "/hello?name=" + name, String.class);
	}
}