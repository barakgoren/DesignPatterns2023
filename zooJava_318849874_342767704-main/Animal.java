package FinalProjectStudent;

import FinalProjectStudent.api.AnimalPrototype;
import FinalProjectStudent.api.IAnimal;
import FinalProjectStudent.api.IObserver;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code Animal} class represents an individual animal in a zoo.
 * It contains information about the animal's species, age, and health status.
 * This class implements the Prototype pattern, allowing animals to reproduce
 * by creating new instances of themselves through cloning.
 */

public final class Animal implements IAnimal, IObserver, Cloneable {

    public Animal(String chipNumber, String species, String type, String name, String habitat, int ageMonths, boolean isHealthy, String sound) {
        this.chipNumber = chipNumber;
        this.species = species;
        this.type = type;
        this.name = name;
        this.habitat = habitat;
        this.ageMonths = ageMonths;
        this.isHealthy = isHealthy;
        this.sound = sound;
    }
    /**
     * The chip number of the animal.
     */
    private String chipNumber;

    /**
     * Whether the animal is carnivorous or not.
     */
    private boolean isCarnivorous;

    /**
     * Whether the animal is nocturnal or not.
     */
    private boolean isNocturnal;

    /**
     * The species of the animal.
     */
    private String species;

    public static void cloneAnimal() {

    }

    public String getChipNumber() {
        return chipNumber;
    }

    /**
     * The type of the animal.
     */
    private String type;
    /**
     * The name of the animal.
     */
    private String name;
    /**
     * The habitat of the animal.
     */
    private String habitat;
    /**
     * The age of the animal in months.
     */
    private int ageMonths;

    /**
     * The health status of the animal.
     */
    private boolean isHealthy;

    /**
     * The sound of the animal.
     */
    private String sound;


    public String getType() {
        return type;
    }


    /**
     * Creates a new {@code Animal} object by copying the attributes from another {@code Animal}.
     *
     * @param other The {@code Animal} object to copy attributes from.
     */
    public Animal(Animal other) {
        this.species = other.species;
        this.ageMonths = other.ageMonths;
        this.isHealthy = other.isHealthy;
        this.name = other.name;
        this.habitat = other.habitat;
        this.type = other.type;
        this.isCarnivorous = other.isCarnivorous;
        this.isNocturnal = other.isNocturnal;
        this.chipNumber = other.chipNumber;
    }

    @Override
    public Animal clone() throws CloneNotSupportedException {
        return (Animal) super.clone();
    }


    //-----------------------------------------------------------------------
    /**
     * Creates a new {@code Animal} object by copying the attributes from another {@code Animal}.
     *
     * @param other The {@code Animal} object to copy attributes from.
     */
    //-----------------------------------------------------------------------

    /**
     * Returns the species of the animal.
     *
     * @return The species of the animal.
     */


    /**
     * Returns the age of the animal in months.
     *
     * @return The age of the animal in months.
     */

    /**
     * Returns the health status of the animal.
     *
     * @return {@code true} if the animal is healthy, {@code false} otherwise.
     */
    public boolean isHealthy() {
        return isHealthy;
    }

    /**
     * Sets the health status of the animal.
     *
     * @param healthy {@code true} if the animal is healthy, {@code false} otherwise.
     */
    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    /**
     * Returns a string representation of the animal.
     *
     * @return A string describing the animal.
     */
    @Override
    public String toString() {
        return "Animal{" +
                "chipNumber='" + chipNumber + '\'' +
                ", isCarnivorous=" + isCarnivorous +
                ", isNocturnal=" + isNocturnal +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", habitat='" + habitat + '\'' +
                ", ageMonths=" + ageMonths +
                ", isHealthy=" + isHealthy +
                ", sound='" + sound + '\'' +
                '}';
    }

    public void setChipNumber(String chipNumber) {
        this.chipNumber = chipNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    @Override
    public void eat(String food) {

    }

    @Override
    public void displayInfo() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void move(String movement) {

    }

    //-----------------------------------------------------------------------

    public String getName() {
        return name;
    }

    /**
     * The {@code AnimalBuilder} class is used to construct instances of the {@code Animal} class
     * with various optional parameters, allowing for a flexible and convenient way to create animal objects.
     */
    //-----------------------------------------------------------------------

    /**
     * Reading the animals from the json file inside the project in the data library.
     *
     * @return Map of animals
     */
    public static Map<String, Animal> readAnimalsFromJson() {
        try (Reader reader = new FileReader("zooJava_318849874_342767704-main/data/animal.json")) {
            Type listType = new TypeToken<List<Animal>>() {}.getType();
            List<Animal> animalList = new Gson().fromJson(reader, listType);

            Map<String, Animal> animalMap = new HashMap<>();
            for (Animal animal : animalList) {
                animalMap.put(animal.getName(), animal);
            }
            return animalMap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This method is part of an observing technique for handling all the that is part of the {@link ObserverSystem}
     *
     * @param mode controlling which event will occur by calling this method:
     *                  1 for feeding the animals.
     *                  2 for washing the animals.
     */
    @Override
    public void update(ObserverSystem subject, int mode) {
        switch (mode) {
            case 1:
                System.out.println(this.name + "is eating");
                break;
            case 2:
                System.out.println(this.name + "is getting wash");
                break;
        }
    }
}
