package FinalProjectStudent;

import FinalProjectStudent.api.IObserver;

/**
 * The {@code Person} class represents an individual with basic personal information.
 * It includes attributes such as first name, last name, age, gender, and additional information
 * of a generic type.
 *
 */
public abstract class Person implements IObserver {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String additionalInfo;

    public Person(String firstName, String lastName, int age, String gender, String  additionalInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.additionalInfo = additionalInfo;
    }

    public Person(String firstName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
    /**
     * Constructs a new {@code Person} object with the specified attributes.
     *
     * @param firstName      The first name of the person.
     * @param lastName       The last name of the person.
     * @param age            The age of the person.
     * @param gender         The gender of the person.
     * @param additionalInfo Additional information associated with the person.
     */

    /**
     * Constructs a new {@code Person} object with the specified attributes.
     *
     * @param firstName      The first name of the person.
     * @param lastName       The last name of the person.
     * @param age            The age of the person.
     * @param gender         The gender of the person.
     */
    /**
     * Gets the first name of the person.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the person.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the age of the person.
     *
     * @return The age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the gender of the person.
     *
     * @return The gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets the additional information associated with the person.
     *
     * @return The additional information.
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the additional information associated with the person.
     *
     * @param additionalInfo The additional information to set.
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Returns a string representation of the {@code Person} object.
     *
     * @return A string describing the person, including their first name, last name, age,
     * gender, and additional information.
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", additionalInfo=" + additionalInfo +
                '}';
    }
}
