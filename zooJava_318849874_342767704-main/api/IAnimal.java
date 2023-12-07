package FinalProjectStudent.api;
/**
 * The {@code IAnimal} interface defines the common behavior expected from animal objects.
 * Classes implementing this interface are required to provide implementations for
 * the {@link #makeSound()} method for specifying the sound produced by the particular type of animal.
 * It also includes an {@link #eat(String)} method to represent the action of eating.
 */
public interface IAnimal {

    /**
     * Abstract method representing the action of making a sound.
     * Subclasses of this interface are expected to provide their own
     * implementations of this method to specify the sound produced
     * by the particular type of animal.
     */
    void makeSound();

    /**
     * Represents the action of eating.
     *
     * Subclasses implementing this interface should provide their own
     * implementations of this method to specify how the animal eats.
     *
     * @param food The type of food the animal is eating.
     */

    void eat(String food);

    /**
     * Displays information about the animal.
     *
     * This method provides details about the name, species, age, habitat,
     * carnivorous nature, and nocturnal behavior of the animal.
     */
    void displayInfo();

    /**
     * Represents the action of sleeping.
     * Subclasses implementing this interface should provide their own
     * implementations of this method to specify how the animal sleeps.
     */
    void sleep();

    /**
     * Represents the action of moving.
     * Subclasses implementing this interface should provide their own
     * implementations of this method to specify how the animal moves.
     *
     * @param movement The type of movement the animal is performing.
     */
    void move(String movement);
}
