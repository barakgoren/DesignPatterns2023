package FinalProjectStudent;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code Zoo} class represents a zoo with various properties, including its name,
 * manager, enclosures, and employees. It can be constructed using the {@link ZooBuilder}
 * to facilitate flexible object creation.
 */
final public class Zoo {

    /**
     * The name of the zoo.
     */
    private String zooName;

    /**
     * The manager of the zoo.
     */
    private Manager manager;

    /**
     * A map of enclosures in the zoo, where the key is the enclosure's name and the value is the enclosure object.
     */
    private Map<Integer, Enclosure> enclosureMap;

    /**
     * A map of employees in the zoo, where the key is the employee's ID and the value is the employee object.
     */
    private Map<String, Employee> employeeMap;
    private Map<String, Animal> animalMap;
    /**
     * A List of visitors in the zoo.
     */
    private List<Visitor> visitors;
    private ObserverSystem animalObserver;

    private Zoo(ZooBuilder builder) {
        this.zooName = builder.zooName;
        this.manager = builder.manager;
        this.employeeMap = builder.employeeMap;
        this.enclosureMap = builder.enclosureMap;
        this.animalMap = builder.animalMap;
        this.animalObserver = builder.animalObserver;
    }

    public String getZooName() {
        return zooName;
    }

    public Manager getManager() {
        return manager;
    }

    public Map<Integer, Enclosure> getEnclosureMap() {
        return enclosureMap;
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public Map<String, Animal> getAnimalMap() {
        return animalMap;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public ObserverSystem getAnimalObserver() {
        return animalObserver;
    }

    public void setAnimalObserver(ObserverSystem animalObserver) {
        this.animalObserver = animalObserver;
    }

    //-----------------------------------------------------------------------
    /**
     * Constructs a new {@code Zoo} using a {@link ZooBuilder} to facilitate flexible
     * object creation.
     *
     * @param {@code ZooBuilder} containing zoo configuration.
     */
    //-----------------------------------------------------------------------
    public static class ZooBuilder {
        private String zooName;
        private Manager manager;
        private Map<Integer, Enclosure> enclosureMap;
        private Map<String, Employee> employeeMap;
        private Map<String, Animal> animalMap;
        private List<Visitor> visitors;
        private ObserverSystem animalObserver;

        public ZooBuilder setZooName(String zooName) {
            this.zooName = zooName;
            return this;
        }

        public Map<String, Animal> getAnimalMap() {
            return animalMap;
        }

        public ZooBuilder setAnimalMap(Map<String, Animal> animalMap) {
            this.animalMap = animalMap;
            return this;
        }

        public ObserverSystem getAnimalObserver() {
            return animalObserver;
        }

        public ZooBuilder setManager(Manager manager) {
            this.manager = manager;
            return this;
        }

        public ZooBuilder setAnimalObserver(ObserverSystem animalObserver) {
            this.animalObserver = animalObserver;
            return this;
        }

        public ZooBuilder setEnclosureMap(Map<Integer, Enclosure> enclosureMap) {
            this.enclosureMap = enclosureMap;
            return this;
        }

        public ZooBuilder setEmployeeMap(Map<String, Employee> employeeMap) {
            this.employeeMap = employeeMap;
            return this;
        }

        public ZooBuilder setVisitors(List<Visitor> visitors) {
            this.visitors = visitors;
            return this;
        }
        public Zoo build() {
            return new Zoo(this);
        }

    }

    //-----------------------------------------------------------------------
    /**
     * The {@code ZooBuilder} class provides a builder pattern for constructing zoos.
     * It allows you to set various properties of the zoo, such as its name, manager,
     * enclosures, and employees, before building the final zoo object.
     */
    //-----------------------------------------------------------------------

}
