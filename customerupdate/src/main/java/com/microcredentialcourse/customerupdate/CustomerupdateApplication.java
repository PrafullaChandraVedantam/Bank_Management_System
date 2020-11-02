package com.microcredentialcourse.customerupdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author javacloudmc449
 *
 */
@EntityScan("com.microcredentialcourse.regdlogin.*")
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableHystrix
public class CustomerupdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerupdateApplication.class, args);
	}

}
