package vip.openpark.distributed.configuration.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.openpark.distributed.configuration.config.ConsulConfig;

/**
 * @author anthony
 * @version 2024-09-26
 * @since 2024-09-26 13:28
 */
@Slf4j
@RestController
public class ConfigController {
	@Resource
	private ConsulConfig consulConfig;

	@GetMapping("fetchConfig")
	public Object fetchConfig() {
		return consulConfig;
	}
}