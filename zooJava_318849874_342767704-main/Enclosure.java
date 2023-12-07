package FinalProjectStudent;


import FinalProjectStudent.Animal;
import FinalProjectStudent.api.IEnclosure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The {@code Enclosure} class represents an enclosure in a zoo that houses animals.
 */
public final class Enclosure implements IEnclosure{
    private int id;
    private String name;
    private String type;
    private String size;
    private String description;
    private List<FinalProjectStudent.Animal> animals;

    /**
     * Constructs a new {@code Enclosure} object with the specified name and type.
     *
     * @param name The name of the enclosure.
     * @param type The type of animals the enclosure is designed for (e.g., "Mammals," "Birds").
     */
    public Enclosure(int id, String name, String type, String size, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.description = description;
        this.animals = new LinkedList<>();
    }
    public int getId() { return id; }
    /**
     * Gets the name of the enclosure.
     *
     * @return The name of the enclosure.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the enclosure.
     *
     * @param name The name to set for the enclosure.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the type of animals the enclosure is designed for.
     *
     * @return The type of animals the enclosure is designed for.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of animals the enclosure is designed for.
     *
     * @param type The type of animals to set for the enclosure.
     */
    public void setType(String type) {
        this.type = type;
    }



    /**
     * Gets a list of animals currently housed in the enclosure.
     *
     * @return A list of animals in the enclosure.
     */
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Returns a string representation of the {@code Enclosure} object.
     *
     * @return A string describing the enclosure, including its name and type.
     */
    @Override
    public String toString() {
        return "Enclosure{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void clean() {

    }

    @Override
    public void addAnimal(Animal animal) {

    }

    public String getDescription() {
        return description;
    }

    @Override
    public Animal removeAnimal(Animal animal) {
        return null;
    }

    public static Map<Integer, Enclosure> readEnclosuresFromJson() {
        try (Reader reader = new FileReader("zooJava_318849874_342767704-main/data/enclosure.json")) {
            Type listType = new TypeToken<List<Enclosure>>() {}.getType();
            List<Enclosure> enclosureList = new Gson().fromJson(reader, listType);

            Map<Integer, Enclosure> enclosureMap = new HashMap<>();
            for (Enclosure enclosure : enclosureList) {
                enclosureMap.put(enclosure.getId(), enclosure);
            }
            return enclosureMap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
