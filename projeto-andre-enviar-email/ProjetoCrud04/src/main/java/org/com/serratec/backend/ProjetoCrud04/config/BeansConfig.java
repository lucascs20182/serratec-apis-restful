package org.com.serratec.backend.ProjetoCrud04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfig {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
