package io.monodon.sofastack.sofacloud.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SofaCloudApigwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofaCloudApigwApplication.class, args);
	}

}
