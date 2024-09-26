package vip.openpark.distributed.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * {@link RefreshScope} 表示自动刷新配置
 *
 * @author anthony
 * @version 2024-09-26
 * @since 2024-09-26 10:27
 */
@RefreshScope
@SpringBootApplication
public class DistributedConfigurationApplication {
	public static void main(String[] args) {
		SpringApplication.run(DistributedConfigurationApplication.class, args);
	}
}