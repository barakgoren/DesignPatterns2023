package FinalProjectStudent;

import FinalProjectStudent.ObserverSystem;
import FinalProjectStudent.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.*;
import java.lang.reflect.Type;

/**
 * The {@code Employee} class represents an employee with various attributes,
 * including their first name, last name, age, gender, employee ID, department,
 * and salary.
 * It extends the {@link FinalProjectStudent.Person} class to inherit basic personal information.
 */
public class Employee extends Person {
    private String employeeID;
    private String department;
    private double salary;

    public Employee(String employeeID,String department,double salary,String firstName, String lastName, int age, String gender, String additionalInfo) {
        super(firstName, lastName, age, gender, additionalInfo);
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String employeeID,String department,double salary, String firstName, String lastName, int age, String gender) {
        super(firstName, lastName, age, gender);
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    /**
     * Constructs a new {@code Employee} with the specified attributes.
     *
     * @param firstName  The first name of the employee.
     * @param lastName   The last name of the employee.
     * @param age        The age of the employee.
     * @param gender     The gender of the employee.
     * @param employeeID The employee ID of the employee.
     * @param department The department in which the employee works.
     * @param salary     The salary of the employee.
     */


    /**
     * Gets the employee ID of the employee.
     *
     * @return The employee ID.
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the employee ID of the employee.
     *
     * @param employeeID The employee ID to set.
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets the department in which the employee works.
     *
     * @return The department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department in which the employee works.
     *
     * @param department The department to set.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the salary of the employee.
     *
     * @return The salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param salary The salary to set.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Represents the performance of duties by the employee.
     * Implement specific duties logic in subclasses as needed.
     */
    public void performDuties() {
        // Implement employee's duties logic here
    }
    public static Map<String, Employee> readEmployeesFromJson() {
        try (Reader reader = new FileReader("zooJava_318849874_342767704-main/data/employee.json")) {
            Type listType = new TypeToken<List<Employee>>() {}.getType();
            List<Employee> employeeList = new Gson().fromJson(reader, listType);

            Map<String, Employee> employeeMap = new HashMap<>();
            for (Employee employee : employeeList) {
                employeeMap.put(employee.getEmployeeID(), employee);
            }
            return employeeMap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(ObserverSystem subject, int mode) {
        switch (mode) {
            case 1:
                System.out.println("You are feeding an animal");
                break;
            case 2:
                System.out.println("You are washing an animal");
                break;
        }
    }

    // Method to delete an animal

    public static List<Animal> readAnimalsFromJson() {
        try (Reader reader = new FileReader("./data/animal.json")) {
            Type mapType = new TypeToken<Map<String, Animal>>() {}.getType();
            Map<String, Animal> animalMap = new Gson().fromJson(reader, mapType);
            return new ArrayList<>(animalMap.values());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading JSON file: " + e.getMessage());
            return null;
        }
    }

    public static void removeAnimal() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter chipNumber:");
        String chipNumber = in.nextLine();

        List<Animal> animals = readAnimalsFromJson();
        boolean animalExists = animals.stream().anyMatch(a -> a.getChipNumber().equals(chipNumber));

        if (animalExists) {
            animals.removeIf(a -> a.getChipNumber().equals(chipNumber));
            writeAnimalToJson(animals);
            System.out.println("Animal with ID " + chipNumber + " has been removed.");
        } else {
            System.out.println("Animal with ID " + chipNumber + " not found.");
        }
    }


    // Method to write employee list to JSON file
    public static void writeAnimalToJson(List<Animal> animals) {
        try (Writer writer = new FileWriter("./data/animal.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(animals, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
