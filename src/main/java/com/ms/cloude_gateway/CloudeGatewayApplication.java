package com.ms.cloude_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.config.HttpClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;


@SpringBootApplication
public class CloudeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudeGatewayApplication.class, args);
	}


	@Bean
	public HttpClientCustomizer httpClientCustomizer() {
		return (httpClientBuilder) -> {
			// Customize the HTTP client here
			return httpClientBuilder
					.tcpConfiguration(tcpClient -> {
						// Customize TCP client configuration if needed
						return tcpClient;
					});
		};
	}

	@Bean
	public ClientHttpConnector clientHttpConnector(HttpClient httpClient) {
		return new ReactorClientHttpConnector(httpClient);
	}
}
