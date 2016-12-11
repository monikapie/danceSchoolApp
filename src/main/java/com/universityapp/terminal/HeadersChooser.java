//package com.universityapp.terminal;
//
//import com.universityapp.model.*;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Date;
//import java.util.Scanner;
//
//public class HeadersChooser {
//    public static void showMainView(Scanner sc) throws IOException {
//        ASCIIArt.createHeader("DANCE.SCHOOL", 12);
//        System.out.println(".............Main menu..............." +
//                "\n1. Courses " + "\n" + "2. Clients\n3. Employees\n");
//        System.out.println("Enter number to choose: ");
//        if(sc.hasNext()) {
//            switch (sc.next()){
//                case "1":
//                    HeadersChooser.showCourseView(sc);
//                    break;
//                case "2":
//                    HeadersChooser.showClientView(sc);
//                    break;
//                case "3":
//                    HeadersChooser.showEmployeeView(sc);
//                    break;
//                default: HeadersChooser.showMainView(sc);
//            }
//        }
//    }
//
//    public static void showCourseView(Scanner sc) throws IOException {
//        System.out.println(".............Courses' menu...............\n" +
//                "1. List courses\n2. Back");
//        System.out.println("Enter number to choose: ");
//        switch(sc.next()) {
//            case "1":
//                System.out.println(".............List of courses...............");
//                RestTemplateService.showListOfCourses();
//                System.out.println("............................................");
//                System.out.println("1. Delete course"+"\n"+"2. Add course"+"\n"+"3. Details course");
//                System.out.println("4. Back");
//                coursesListViewOptions(sc);
//                break;
//            default:
//                showMainView(sc);
//                break;
//        }
//    }
//
//    public static void showClientView(Scanner sc) throws IOException {
//        System.out.println(".............Clients' menu...............\n" +
//                "1. List clients\n2. Back");
//        switch(sc.next()) {
//            case "1":
//                System.out.println(".............List of clients...............");
//                RestTemplateService.showListOfClients();
//                System.out.println("............................................");
//                System.out.println("1. Delete client"+"\n"+"2. Add client"+"\n"+"3. Details client");
//                System.out.println("4. Back");
//                clientsListViewOptions(sc);
//                break;
//            default:
//                showMainView(sc);
//                break;
//        }
//    }
//
//    public static void showEmployeeView(Scanner sc) throws IOException {
//        System.out.println("1. List employees"+"\n3. Back");
//        switch(sc.next()) {
//            case "1":
//                System.out.println(".............List of employees...............");
//                RestTemplateService.showListOfEmployees();
//                System.out.println("............................................");
//                System.out.println("1. Delete employee"+"\n"+"2. Add employee"+"\n"+"3. Details employee");
//                System.out.println("4. Back");
//                employeeListViewOptions(sc);
//                break;
//            default:
//                showMainView(sc);
//                break;
//        }
//    }
//
//    private static void coursesListViewOptions(Scanner sc) throws IOException {
//        switch(sc.next()){
//            case "1":
//                System.out.println("Enter course's id to delete it: ");
//                String id = sc.next();
//                RestTemplateService.deleteCourse(id);
//                System.out.println("Course "+id+" was deleted.");
//                showMainView(sc);
//                break;
//            case "2":
//                CourseEntity newCourse = new CourseEntity();
//                createCourse(sc, newCourse);
//                RestTemplateService.addCourse(newCourse);
//                System.out.println("Course was created.");
//                showMainView(sc);
//                break;
//            case "3":
//                System.out.println("Enter course's id to show details about course.");
//                String idCourse = sc.next();
//                try{
//                    CourseEntity updatedCourse = RestTemplateService.getCourse(idCourse);
//                    showCourseInfo(updatedCourse);
//                    System.out.println("1. Update course.\n2. Back");
//                    courseDetailsOptions(sc, updatedCourse);
//                }catch(NullPointerException ex){
//                    System.out.println("Course with this id doesn't exist.");
//                    showMainView(sc);
//                }
//                break;
//            default:
//                showMainView(sc);
//                break;
//        }
//    }
//
//    private static void clientsListViewOptions(Scanner sc) throws IOException {
//        switch(sc.next()){
//            case "1":
//                System.out.println("Enter client's id to delete her/him: ");
//                String id = sc.next();
//                RestTemplateService.deleteClient(id);
//                System.out.println("User "+id+" was deleted.");
//                break;
//            case "2":
//                ClientEntity newClient = new ClientEntity();
//                createClient(sc, newClient);
//                RestTemplateService.addClient(newClient);
//                System.out.println("Client "+newClient.getName()+" was created.");
//                showMainView(sc);
//                break;
//            case "3":
//                System.out.println("Enter client's id to show details about client.");
//                String idClient = sc.next();
//                ClientEntity updatedClient = RestTemplateService.getClient(idClient);
//                showClientInfo(updatedClient);
//                System.out.println("1. Update client."+"\n"+"2. Back");
//                clientsDetailsOptions(sc, updatedClient);
//                break;
//            default:
//                showMainView(sc);
//                break;
//        }
//    }
//
//    private static void employeeListViewOptions(Scanner sc) throws IOException {
//        switch(sc.next()){
//            case "1":
//                System.out.println("Enter employee's id to delete her/him: ");
//                String id = sc.next();
//                RestTemplateService.deleteEmployee(id);
//                System.out.println("Employee "+id+" was deleted.");
//                showMainView(sc);
//                break;
//            case "2":
//                EmployeeEntity newEmployee = new EmployeeEntity();
//                createEmployee(sc, newEmployee);
//                RestTemplateService.addEmployee(newEmployee);
//                System.out.println("Employee "+newEmployee.getName()+" was created.");
//                showMainView(sc);
//                break;
//            case "3":
//                System.out.println("Enter employee's id to show details about employee.");
//                String idEmployee = sc.next();
//                EmployeeEntity updatedEmployee = RestTemplateService.getEmployee(idEmployee);
//                showEmployeeInfo(updatedEmployee);
//                System.out.println("1. Update employee.\n2. Back");
//                employeeDetailsOptions(sc, updatedEmployee);
//                break;
//            default:
//                showMainView(sc);
//                break;
//        }
//    }
//
//    private static void clientsDetailsOptions(Scanner sc, ClientEntity updatedClient) throws IOException {
//        switch(sc.next()){
//            case "1":
//                updateClient(sc, updatedClient);
//                RestTemplateService.updateClient(updatedClient);
//                System.out.println("Client "+updatedClient.getId()+" was updated.");
//                showMainView(sc);
//                break;
//            default:
//                showMainView(sc);
//                break;
//        }
//    }
//
//    private static void courseDetailsOptions(Scanner sc, CourseEntity updatedCourse) throws IOException {
//        switch(sc.next()){
//            case "1":
//                updateCourse(sc, updatedCourse);
//                RestTemplateService.updateCourse(updatedCourse);
//                System.out.println("Client "+updatedCourse.getId()+" was updated.");
//                showMainView(sc);
//                break;
//            default:
//                showMainView(sc);
//                break;
//        }
//    }
//
//    private static void employeeDetailsOptions(Scanner sc, EmployeeEntity updatedEmployee) throws IOException {
//        switch(sc.next()){
//            case "1":
//                updateEmployee(sc, updatedEmployee);
//                RestTemplateService.updateEmployee(updatedEmployee);
//                System.out.println("Client "+updatedEmployee.getId()+" was updated.");
//                showMainView(sc);
//                break;
//            default:
//                showMainView(sc);
//                break;
//        }
//    }
//
//    private static void showClientInfo(ClientEntity client) {
//        System.out.println("..........Clients's details............");
//        System.out.println("Name: "+client.getName()
//                +"\nSurname: "+client.getSurname()
//                +"\nPhone: "+client.getPhone()
//                +"\nE-mail: "+client.getEmail()
//                +"\nBirth date: "+client.getBirthDate()
//                +"\nCard id: "+client.getCard()
//                +"\nTeams: ");
//        for (TeamEntity team : client.getTeams()) {
//            System.out.println(team.getCourse());
//        }
//    }
//
//    private static void showCourseInfo(CourseEntity course) {
//        System.out.println("..........Clients's details............");
//        System.out.println("Type: "+course.getType()
//                +"\nTrainer id: "+course.getTrainerId()
//                +"\nCost: "+course.getCost()
//                +"\nTeams: ");
//        for (TeamEntity team : course.getTeams()) {
//            System.out.println(team.getCourse());
//        }
//    }
//
//    private static void showEmployeeInfo(EmployeeEntity employee) {
//        System.out.println("..........Employee's details............");
//        System.out.println("Name: "+employee.getName()
//                +"\nSurname: "+employee.getSurname()
//                +"\nPhone: "+employee.getPhone()
//                +"\nPosition: "+employee.getPosition()
//                +"\nSupervisor id: "+employee.getIdSupervisor()
//                +"\nCard id: ");
//        for (ContractEntity contract : employee.getContracts()) {
//            System.out.println(contract.getEndDate());
//        }
//    }
//
//    private static ClientEntity createClient(Scanner sc, ClientEntity newClient){
//        System.out.println("Enter name: ");
//        newClient.setName(sc.next());
//        System.out.println("Enter surname: ");
//        newClient.setSurname(sc.next());
//        System.out.println("Enter phone: ");
//        Long phone = Long.valueOf(sc.next());
//        newClient.setPhone(phone);
//        System.out.println("Enter email: ");
//        newClient.setEmail(sc.next());
//        System.out.println("Enter birth date: ");
//        Date birthDate = Conversion.convertStringIntoDate(sc.next());
//        newClient.setBirthDate(birthDate);
//        return newClient;
//    }
//
//    private static CourseEntity createCourse(Scanner sc, CourseEntity newCourse){
//        System.out.println("Enter type: ");
//        newCourse.setType(sc.next());
//        System.out.println("Enter cost: ");
//        Long cost = Long.valueOf(sc.next());
//        newCourse.setCost(cost);
//        return newCourse;
//    }
//
//    private static EmployeeEntity createEmployee(Scanner sc, EmployeeEntity newEmployee){
//        System.out.println("Enter name: ");
//        newEmployee.setName(sc.next());
//        System.out.println("Enter surname: ");
//        newEmployee.setSurname(sc.next());
//        System.out.println("Enter phone: ");
//        Long phone = Long.valueOf(sc.next());
//        newEmployee.setPhone(phone);
//        System.out.println("Enter position: ");
//        newEmployee.setPosition(sc.next());
//        System.out.println("Enter supervisor id: ");
//        Long idSupervisor = Long.valueOf(sc.next());
//        newEmployee.setIdSupervisor(idSupervisor);
//        return newEmployee;
//    }
//
//    private static ClientEntity updateClient(Scanner sc, ClientEntity newClient){
//        System.out.println("Enter name: ");
//        String name = sc.next();
//        if(!name.equals("x")){
//            newClient.setName(name);
//        }
//        System.out.println("Enter surname: ");
//        String surname = sc.next();
//        if(!surname.equals("x")){
//            newClient.setSurname(surname);
//        }
//        System.out.println("Enter phone: ");
//        String phoneClient = sc.next();
//        if(!phoneClient.equals("x")){
//            Long phone = Long.valueOf(phoneClient);
//            newClient.setPhone(phone);
//        }
//        System.out.println("Enter email: ");
//        String email = sc.next();
//        if(!email.equals("x")){
//            newClient.setEmail(email);
//        }
//        System.out.println("Enter birth date: ");
//        String date = sc.next();
//        if(!date.equals("x")){
//            Date birthDate = Conversion.convertStringIntoDate(sc.next());
//            newClient.setBirthDate(birthDate);
//        }
//        return newClient;
//    }
//
//    private static CourseEntity updateCourse(Scanner sc, CourseEntity newCourse){
//        System.out.println("Enter type: ");
//        String type = sc.next();
//        if(!type.equals("x")){
//            newCourse.setType(type);
//        }
//        System.out.println("Enter trainer id: ");
//        String idTrainer = sc.next();
////        EmployeeEntity trainer = RestTemplateService.getEmployee(idTrainer);
//        if(!idTrainer.equals("x")){
//            Long id = Long.valueOf(idTrainer);
//            newCourse.setTrainerId(id);
//        }
//        System.out.println("Enter cost: ");
//        String costHour = sc.next();
//        if(!costHour.equals("x")){
//            Long cost = Long.valueOf(costHour);
//            newCourse.setCost(cost);
//        }
//        return newCourse;
//    }
//
//    private static EmployeeEntity updateEmployee(Scanner sc, EmployeeEntity newEmployee){
//        System.out.println("Enter name: ");
//        String name = sc.next();
//        if(!name.equals("x")){
//            newEmployee.setName(name);
//        }
//        System.out.println("Enter surname: ");
//        String surname = sc.next();
//        if(!surname.equals("x")){
//            newEmployee.setSurname(surname);
//        }
//        System.out.println("Enter phone: ");
//        String phoneClient = sc.next();
//        if(!phoneClient.equals("x")){
//            Long phone = Long.valueOf(phoneClient);
//            newEmployee.setPhone(phone);
//        }
//        System.out.println("Enter email: ");
//        String position = sc.next();
//        if(!position.equals("x")){
//            newEmployee.setPosition(position);
//        }
//        System.out.println("Enter birth date: ");
//        String id = sc.next();
//        if(!id.equals("x")){
//            Long supervisorId = Long.valueOf(id);
//            newEmployee.setIdSupervisor(supervisorId);
//        }
//        return newEmployee;
//    }
//}
