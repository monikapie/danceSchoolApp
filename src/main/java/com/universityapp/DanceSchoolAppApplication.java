package com.universityapp;

import com.github.javafaker.Faker;
import com.universityapp.enums.PositionType;
import com.universityapp.model.ClientEntity;
import com.universityapp.model.CourseEntity;
import com.universityapp.model.EmployeeEntity;
import com.universityapp.service.ClientService;
import com.universityapp.service.CourseService;
import com.universityapp.service.EmployeeService;
import com.universityapp.terminal.HeadersChooser;
import com.universityapp.terminal.RestTemplateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "com.universityapp")
public class DanceSchoolAppApplication {
	private final Faker faker = new Faker();
	public static void main(String[] args) throws IOException, URISyntaxException {
		SpringApplication.run(DanceSchoolAppApplication.class, args);
		//Scanner sc = new Scanner(System.in);
		//HeadersChooser.showMainView(sc);
	}

//	@Bean
//	public CommandLineRunner initializeDb(CourseService service, ClientService serviceEmp) {
////		return (args) -> {
////			service.deleteAll();
////			Long cost = Long.valueOf(40);
////			Long trainerId = Long.valueOf(62);
////			//Insert some random clients
////			for (int i = 0; i < 10; i++) {
////				service.save(new CourseEntity(faker.lorem().word(),cost,trainerId));
////			}
////		};
//		return (args) -> {
//			//Insert some random clients
//			for (int i = 0; i < 10; i++) {
//				serviceEmp.save(new ClientEntity(faker.lorem().word(),faker.lorem().word()));
//			}
//		};
//	}

}

