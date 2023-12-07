package FinalProjectStudent.api;

import FinalProjectStudent.Animal;
import FinalProjectStudent.Enclosure;
import FinalProjectStudent.Visitor;
import FinalProjectStudent.api.IEnclosure;

/**
 * The {@code IZoo} interface defines the common operations expected from a zoo.
 * Classes implementing this interface should provide concrete implementations
 * for adding and removing animals, as well as adding and removing enclosures.
 * It also includes methods for feeding animals and cleaning enclosures.
 * Additionally, this interface defines methods for opening and closing the zoo.
 */
public interface IZoo extends IEnclosure {
    /**
     * Adds an {@link Animal} to the zoo.
     *
     * @param animal The animal to be added to the zoo.
     */
    void addAnimal(Animal animal);

    /**
     * Removes an {@link Animal} from the zoo.
     *
     * @param animal The animal to be removed from the zoo.
     */
    Animal removeAnimal(Animal animal);

    /**
     * Adds an {@link Enclosure} to the zoo.
     *
     * @param enclosure The enclosure to be added to the zoo.
     */
    void addEnclosure(Enclosure enclosure);

    /**
     * Removes an {@link Enclosure} from the zoo.
     *
     * @param enclosure The enclosure to be removed from the zoo.
     */
    Enclosure removeEnclosure(Enclosure enclosure);

    /**
     * Adds a {@link Visitor} to the zoo.
     *
     * @param visitor The visitor to be added to the zoo.
     */
    void addVisitor(Visitor visitor);

    /**
     * Removes a {@link Visitor} from the zoo.
     *
     * @param visitor The visitor to be removed from the zoo.
     */
    Visitor removeVisitor(Visitor visitor);

    /**
     * Opens the zoo for visitors.
     *
     * @return {@code true} if the zoo is successfully opened, {@code false} otherwise.
     */
    boolean openTheZoo();

    /**
     * Closes the zoo to visitors.
     *
     * @return {@code true} if the zoo is successfully closed, {@code false} otherwise.
     */
    boolean closeTheZoo();
}
