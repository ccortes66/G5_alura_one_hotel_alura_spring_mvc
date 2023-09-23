package com.alura.hotelalura.springboottres;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class HotelaluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelaluraApplication.class, args);
	}


}
