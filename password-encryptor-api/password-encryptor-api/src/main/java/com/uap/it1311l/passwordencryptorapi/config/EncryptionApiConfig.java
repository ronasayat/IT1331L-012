package com.uap.it1311l.passwordencryptorapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;

@Configuration
public class EncryptionApiConfig {
	@Bean
	EncryptionApiClient encryptionApi() {
		WebClient webClient = WebClient.builder()
				.baseUrl("https://encryption-api1.p.rapidapi.com/api/Cryptor")
				.defaultHeader("X-RapidAPI-Key","7161ca2de4msh44688cdcd8ed22cp120d63jsnd3609afd3c31")
				.defaultHeader("X-RapidAPI-Host","encryption-api1.p.rapidapi.com")
				.build();
		
		HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(webClient))
				.build();
		return httpServiceProxyFactory.createClient(EncryptionApiClient.class);
	}
}
