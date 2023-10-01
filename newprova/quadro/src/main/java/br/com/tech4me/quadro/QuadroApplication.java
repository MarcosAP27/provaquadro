package br.com.tech4me.quadro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient

public class QuadroApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuadroApplication.class, args);
	}

}
