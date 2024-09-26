package vip.openpark.distributed.configuration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author anthony
 * @version 2024-09-26
 * @since 2024-09-26 10:27
 */
@Data
@Component
@ConfigurationProperties(prefix = "vip.openpark")
public class ConsulConfig {
	private String name;
	private Long version;
	@DateTimeFormat(pattern = "uuuu-MM-dd HH:mm:ss")
	private LocalDateTime gmtCreate;
	private List<String> tags;
	private Map<String, Object> properties;
}