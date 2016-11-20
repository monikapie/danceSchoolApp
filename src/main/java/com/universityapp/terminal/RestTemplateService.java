package com.universityapp.terminal;

import com.universityapp.model.ClientEntity;
import com.universityapp.model.CourseEntity;
import com.universityapp.model.EmployeeEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Monika on 11/12/2016.
 */
public class RestTemplateService {
    public static void showListOfClients(){
        final String uri = "http://localhost:8080/clients";
        RestTemplate restTemplate = new RestTemplate();
        ClientEntity[] result = restTemplate.getForObject(uri, ClientEntity[].class);
        for (ClientEntity client:result) {
            System.out.println(client.getId()+"."+client.getName()+" "+client.getSurname()+" "+client.getPhone());
        }
    }

    public static void showListOfCourses(){
        final String uri = "http://localhost:8080/courses";
        RestTemplate restTemplate = new RestTemplate();
        CourseEntity[] result = restTemplate.getForObject(uri, CourseEntity[].class);
        for (CourseEntity course:result) {
            System.out.println(course.getId()+"."+course.getType()+" "+course.getCost());
        }
    }

    public static void showListOfEmployees(){
        final String uri = "http://localhost:8080/employees";
        RestTemplate restTemplate = new RestTemplate();
        EmployeeEntity[] result = restTemplate.getForObject(uri, EmployeeEntity[].class);
        for (EmployeeEntity course:result) {
            System.out.println(course.getId()+"."+course.getName()+" "+course.getSurname());
        }
    }

    public static void addClient(ClientEntity newClient){
        final String uri = "http://localhost:8080/clients";
        ClientEntity clientEntity = newClient;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject( uri, clientEntity, ClientEntity.class);
    }

    public static void addCourse(CourseEntity newCourse){
        final String uri = "http://localhost:8080/courses";
        CourseEntity courseEntity = newCourse;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject( uri, courseEntity, CourseEntity.class);
    }

    public static void addEmployee(EmployeeEntity newEmpolyee){
        final String uri = "http://localhost:8080/employees";
        EmployeeEntity employeeEntity = newEmpolyee;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject( uri, employeeEntity, EmployeeEntity.class);
    }

    public static void deleteClient(String id){
        final String uri = "http://localhost:8080/clients/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete ( uri, params);
    }

    public static void deleteCourse(String id){
        final String uri = "http://localhost:8080/courses/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete ( uri, params);
    }

    public static void deleteEmployee(String id){
        final String uri = "http://localhost:8080/employees/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete ( uri, params);
    }

    public static ClientEntity getClient(String id){
        final String uri = "http://localhost:8080/clients/{id}";
        Map<String,String> params = new HashMap<>();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        ClientEntity client = restTemplate.getForObject(uri, ClientEntity.class,params);
        return client;
    }

    public static CourseEntity getCourse(String id){
        final String uri = "http://localhost:8080/courses/{id}";
        Map<String,String> params = new HashMap<>();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        CourseEntity course = restTemplate.getForObject(uri, CourseEntity.class,params);
        return course;
    }

    public static EmployeeEntity getEmployee(String id){
        final String uri = "http://localhost:8080/employees/{id}";
        Map<String,String> params = new HashMap<>();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        EmployeeEntity employee = restTemplate.getForObject(uri, EmployeeEntity.class, params);
        return employee;
    }

    public static void updateClient(ClientEntity client){
        final String uri = "http://localhost:8080/clients/{id}";
        Map<String, String> params = new HashMap<String, String>();
        ClientEntity updatedClient = client;
        params.put("id", String.valueOf(updatedClient.getId()));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uri, updatedClient, params);
    }

    public static void updateCourse(CourseEntity course){
        final String uri = "http://localhost:8080/courses/{id}";
        Map<String, String> params = new HashMap<String, String>();
        CourseEntity updatedCourse = course;
        params.put("id", String.valueOf(updatedCourse.getId()));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uri, updatedCourse, params);
    }

    public static void updateEmployee(EmployeeEntity employee){
        final String uri = "http://localhost:8080/employee/{id}";
        Map<String, String> params = new HashMap<String, String>();
        EmployeeEntity updatedEmployee = employee;
        params.put("id", String.valueOf(updatedEmployee.getId()));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uri, updatedEmployee, params);
    }
}

