package vip.openpark.service.discovery.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anthony
 * @version 2024-09-25
 * @since 2024-09-25 17:26
 */
@Slf4j
@RestController
@RequestMapping
public class RemoteHelloController {
	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false) String name) {
		return "hello " + name;
	}
}