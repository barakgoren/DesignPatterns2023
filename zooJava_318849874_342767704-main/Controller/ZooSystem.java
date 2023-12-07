package FinalProjectStudent.Controller;

import FinalProjectStudent.*;
import FinalProjectStudent.ObserverSystem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ZooSystem {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {

        Zoo zoo = new Zoo.ZooBuilder()
                .setZooName("Biblic Zoo")
                .setManager(Manager.readManagerFromJson())
                .setEmployeeMap(Employee.readEmployeesFromJson())
                .setEnclosureMap(Enclosure.readEnclosuresFromJson())
                .setVisitors(Visitor.readVisitorFromJson())
                .setAnimalMap(Animal.readAnimalsFromJson())
                .build();
        ObserverSystem animalHandlingObserver = ObserverSystem.getInstance();
        zoo.getAnimalMap().forEach((name, animal) -> {
            animalHandlingObserver.attach(animal);
        });
        zoo.setAnimalObserver(animalHandlingObserver);
        MainMenu(zoo);



    }
    /**
     * A method that pops the main menu
     *
     * @param zoo is for making changes in the current object that represent zoo.
     */
    static void MainMenu(Zoo zoo) throws IOException, CloneNotSupportedException {
        System.out.println("Welcome in : " + zoo.getZooName());
        System.out.println("Select the desired option");
        System.out.println("1. Animal Menu");
        System.out.println("2. Employee Menu");
        System.out.println("3. Manager Menu");
        System.out.println("4. Visitor Menu");
        System.out.println("5. Exit");
        int choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1:
                AnimalMenu(zoo);
                break;
            case 2:
                EmployeeMenu(zoo);
                break;
            case 3:
                ManagerMenu(zoo);
                break;
            case 4:
                VisitorMenu(zoo);
                break;
            case 5:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    }
    /**
     * A method that pops an employee menu
     *
     * @param zoo is for making changes in the current object that represent zoo.
     */
    static void EmployeeMenu(Zoo zoo) throws IOException {

        String employeeId;
        Employee currentEmployee;

        int choice = 0;

        do {
            System.out.print("Insert your Employee ID: ");
            employeeId = new Scanner(System.in).next();
            currentEmployee = zoo.getEmployeeMap().get(employeeId);


            if (currentEmployee == null) {
                System.out.println("Invalid Employee ID. Please try again.");
                continue;
            }
            System.out.println("Hello " + "\033[34m" + currentEmployee.getFirstName() + "\033[0m" + " manager of " + "\033[34m" + currentEmployee.getDepartment() + "\033[0m" + " Department!");
            System.out.println("Select the desired option");
            System.out.println("1. Feed animals inside an enclosure");
            System.out.println("2. Add Animal");
            System.out.println("3. Remove Animal");
            System.out.println("4. Exit");

            choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You fed all the animals");
                    zoo.getAnimalObserver().notifyMsg(1);
                    break;
                case 2:
                    addAnimal(zoo);
                    break;
                case 3:
                    Employee.removeAnimal();

                    break;
                case 4:
                    System.out.println("Exiting Employee Menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (choice != 4);
    }
    /**
     * A method that pops a visitor menu
     *
     * @param zoo is for making changes in the current object that represent zoo.
     */
    static int VisitorMenu(Zoo zoo) {
        System.out.println("Visitor Menu");
        Collection<Enclosure> enclosures = zoo.getEnclosureMap().values();
        int count = 1;
        for (Enclosure enclosure : enclosures) {
            System.out.println(count + "." +enclosure.getName());
            count++;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Choose an enclosure number: ");

        if (in.hasNextInt()) {
            int userChoice = in.nextInt();

            if (userChoice >= 1 && userChoice <= enclosures.size()) {
                Enclosure selectedEnclosure = (Enclosure) enclosures.toArray()[userChoice - 1];

                System.out.println("Description of the enclosure: " + selectedEnclosure.getDescription());
            } else {
                System.out.println("Invalid entry. Please enter a number..");
            }
        } else {
            System.out.println("Invalid entry. Please enter a number.");
        }
        return 0;
    }
    /**
     * A method that pops a manager menu
     *
     * @param zoo is for making changes in the current object that represent zoo.
     */
    static void ManagerMenu(Zoo zoo) throws IOException {
        String employeeId;
        Manager currentManager = null;
        do{
            System.out.print("Insert your Employee ID: ");
             employeeId = new Scanner(System.in).next();
             if(!employeeId.equals(zoo.getManager().getEmployeeID())){
                 System.out.println("Wrong ID!");
             } else {
                 currentManager = zoo.getManager();
             }
        } while ( (!employeeId.equals(zoo.getManager().getEmployeeID())));


        int managerChoice;
        do {
            System.out.println("Hello " + "\033[34m" + currentManager.getFirstName() + "\033[0m");
            System.out.println("Select the desired option");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Back to Main Menu");

            managerChoice = new Scanner(System.in).nextInt();

            switch (managerChoice) {
                case 1:
                    Manager.addEmployee();
                    break;
                case 2:
                    Manager.removeEmployee();
                    break;
                case 3:
                    System.out.println("Returning to the Main Menu");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (managerChoice != 3);
    }
    /**
     * A method that pops an animal menu
     *
     * @param zoo is for making changes in the current object that represent zoo.
     */
    static void AnimalMenu(Zoo zoo) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);

        int option = 0;

        while (option != 2) {
            System.out.println("1. Clone animal");
            System.out.println("2. Exit");

            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Insert the animal's name: ");
                    String animalName = scanner.next();

                    Animal currentAnimal = zoo.getAnimalMap().get(animalName);

                    if (currentAnimal != null) {
                        System.out.println("Enter a new name:");
                        String newName = scanner.next();
                        currentAnimal.setName(newName);

                        System.out.println("Enter a chipNumber:");
                        String newChipNumber = scanner.next();
                        currentAnimal.setChipNumber(newChipNumber);

                        zoo.getAnimalMap().put(newName, currentAnimal);
                        writeAnimalToJson(zoo.getAnimalMap());
                        System.out.println("Animal cloned !");
                    } else {
                        System.out.println("Animal not found. Please enter a valid name.");
                    }
                    break;

                case 2:
                    System.out.println("Exiting AnimalMenu.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }
    /**
     * A method for rewriting the animals data.
     *
     * @param animals to insert a map of animals
     */
    public static void writeAnimalToJson(Map animals) {
        try (Writer writer = new FileWriter("./data/animal.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(animals, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * A method for adding new animal.
     *
     * @param zoo to put the new animal to the map of animals of the object that represent zoo.
     */
    public static void addAnimal(Zoo zoo) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter chipNumber:");
        String chipNumber = in.nextLine();

        System.out.println("Enter species:");
        String species = in.nextLine();

        System.out.println("Enter type:");
        String type = in.nextLine();

        System.out.println("Enter name:");
        String name = in.nextLine();

        System.out.println("Enter habitat:");
        String habitat = in.nextLine();

        System.out.println("Enter ageMonths:");
        int ageMonths = in.nextInt();
        in.nextLine();

        System.out.println("Enter isHealthy:");
        boolean isHealthy = in.nextBoolean();
        in.nextLine();

        System.out.println("Enter sound:");
        String sound = in.nextLine();

        Animal animal1 = new Animal(chipNumber, species, type, name, habitat, ageMonths, isHealthy, sound);

        zoo.getAnimalMap().put(name, animal1);
        writeAnimalToJson(zoo.getAnimalMap());
        System.out.println("Animal added !");


    }



}

