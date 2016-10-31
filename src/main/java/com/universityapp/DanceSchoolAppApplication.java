package com.universityapp;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.universityapp")
public class DanceSchoolAppApplication {
	private final Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(DanceSchoolAppApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner initializeDb(ClientService service){
//		return (args) -> {
//			service.deleteAll();
//			//Insert some random clients
//			for(int i = 0; i < 20; i++) {
//				service.save(new ClientEntity(faker.lorem().word(), faker.lorem().word()));
//			}
//		};
//	}
}
