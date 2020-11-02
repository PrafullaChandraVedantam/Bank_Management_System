package com.microcredentialcourse.regdlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 
 * @author javacloudmc449
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class RegdloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegdloginApplication.class, args);
	}

}
