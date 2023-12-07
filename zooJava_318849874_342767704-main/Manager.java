package FinalProjectStudent;

import FinalProjectStudent.Employee;
import FinalProjectStudent.ObserverSystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

/**
 * The {@code Manager} class represents a manager who is an employee responsible for overseeing
 * operations in a department or section of a zoo.
 */
public class Manager extends Employee{
    private String departmentManaged;

    public Manager(String departmentManaged,String employeeID,String department,double salary,String firstName, String lastName, int age, String gender){
        super(employeeID, department, salary, firstName, lastName, age, gender);
        this.departmentManaged = departmentManaged;
    }

    /**
     * Constructs a new {@code Manager} with the specified attributes.
     *
     * @param firstName         The first name of the manager.
     * @param lastName          The last name of the manager.
     * @param age               The age of the manager.
     * @param gender            The gender of the manager.
     * @param employeeID        The unique ID of the manager as an employee.
     * @param department        The department in which the manager works.
     * @param salary            The salary of the manager.
     * @param departmentManaged The department or section managed by the manager.
     */


    /**
     * Gets the department or section managed by the manager.
     *
     * @return The department or section managed by the manager.
     */
    public String getDepartmentManaged() {
        return departmentManaged;
    }

    /**
     * Sets the department or section managed by the manager.
     *
     * @param departmentManaged The department or section to be managed by the manager.
     */
    public void setDepartmentManaged(String departmentManaged) {
        this.departmentManaged = departmentManaged;
    }

    /**
     * Manages department-specific operations and tasks as per the manager's responsibilities.
     */
    public void manageDepartment() {
    }
    public static void addEmployee() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter employeeID:");
        String employeeID = in.nextLine();

        System.out.println("Enter department:");
        String department = in.nextLine();

        System.out.println("Enter salary:");
        double salary = in.nextDouble();
        in.nextLine();

        System.out.println("Enter firstName:");
        String firstName = in.nextLine();

        System.out.println("Enter lastName:");
        String lastName = in.nextLine();

        System.out.println("Enter age:");
        int age = in.nextInt();
        in.nextLine();

        System.out.println("Enter gender:");
        String gender = in.nextLine();

        Employee employee1 = new Employee(employeeID, department, salary, firstName, lastName, age, gender);

        List<Employee> employees = readEmployeesFromJsonBase();
        employees.add(employee1);
        writeEmployeesToJson(employees);

    }

    public static Manager readManagerFromJson() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("zooJava_318849874_342767704-main/data/manager.json")) {
            // Convert JSON File to Java Object
            Manager manager = gson.fromJson(reader, Manager.class);
            return manager;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading JSON file: " + e.getMessage());
            return null;
        }
    }


    // Method to delete an employee
    public static void removeEmployee() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter employeeID:");
        String employeeID = in.nextLine();

        List<Employee> employees = readEmployeesFromJsonBase();
        boolean employeeExists = employees.stream().anyMatch(e -> e.getEmployeeID().equals(employeeID));

        if (employeeExists) {
            employees.removeIf(e -> e.getEmployeeID().equals(employeeID));
            writeEmployeesToJson(employees);
            System.out.println("Employee with ID " + employeeID + " has been removed.");
        } else {
            System.out.println("Employee with ID " + employeeID + " not found.");
        }
    }

    // Method to read employees from JSON file
    private static List<Employee> readEmployeesFromJsonBase() {
        try (Reader reader = new FileReader("./data/employee.json")) {
            Type listType = new TypeToken<List<Employee>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to write employee list to JSON file
    private static void writeEmployeesToJson(List<Employee> employees) {
        try (Writer writer = new FileWriter("./data/employee.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(employees, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}