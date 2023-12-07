package FinalProjectStudent;

import FinalProjectStudent.ObserverSystem;
import FinalProjectStudent.Person;
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
 * The {@code Visitor} class represents a visitor at a zoo.
 * It stores information about the visitor, including their name, age, and ticket type.
 */
public final class Visitor extends Person {

    private String ticketType;

    public Visitor(String ticketType,String firstName, String lastName, int age, String gender, String additionalInfo) {
        super(firstName, lastName, age, gender, additionalInfo);
        this.ticketType = ticketType;
    }




    /**
     * Constructs a new {@code Visitor} with the specified name, age, and ticket type.
     *
     * @param firstName  The first name of the person.
     * @param lastName   The last name of the person.
     * @param age        The age of the person.
     * @param gender     The gender of the person.
     * @param ticketType The type of ticket held by the visitor (e.g., "Adult," "Child").
     */


    /**
     * Gets the type of ticket held by the visitor.
     *
     * @return The ticket type of the visitor (e.g., "Adult," "Child").
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * Returns a string representation of the {@code Visitor} object.
     *
     * @return A string representation including the name, age, and ticket type of the visitor.
     */
    @Override
    public String toString() {
        return "Visitor{" +
                "ticketType='" + ticketType + '\'' +
                '}';
    }

    public static List<Visitor> readVisitorFromJson() {
        try (Reader reader = new FileReader("zooJava_318849874_342767704-main/data/visitors.json")) {
            Type listType = new TypeToken<List<Visitor>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(ObserverSystem subject, int mode) {

    }
}

