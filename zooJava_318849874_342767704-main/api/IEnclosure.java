package FinalProjectStudent.api;

import FinalProjectStudent.Animal;
import FinalProjectStudent.Enclosure;

/**
 * The {@code IEnclosure} interface defines common operations expected from an enclosure
 * that houses animals in a zoo.
 */
public interface IEnclosure {
     /**
      * Performs cleaning operations within the enclosure.
      * Specific cleaning tasks may vary depending on the type of enclosure.
      */
     void clean();

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
}

