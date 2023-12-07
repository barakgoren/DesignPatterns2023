package FinalProjectStudent;


import FinalProjectStudent.api.IObserver;
import FinalProjectStudent.api.IObserverSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ObserverSystem} class represents a Singleton implementation of the Observer pattern.
 * It allows attaching, detaching, and notifying observers.
 */
public final class ObserverSystem implements IObserverSystem{

    // Singleton instance
    private static ObserverSystem instance;

    // List of observers
    private List<IObserver> observers;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private ObserverSystem() {
        observers = new ArrayList<>();
    }

    /**
     * Get the singleton instance of the ObserverSystem.
     *
     * @return The singleton instance.
     */
    public static ObserverSystem getInstance() {
        if (instance == null) {
            instance = new ObserverSystem();
        }
        return instance;
    }

    /**
     *The attach method is for adding an observer given as a parameter to the listeners list.
     *
     * @param observer the current observer you want to add.
     */
    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }
    /**
     *The detach method is for removing the observer given as a parameter from the listeners list.
     *
     * @param observer the current observer you want to remove.
     */
    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    /**
     * This method initiat an event on the animals that registered to this subject.
     * you can control the event that occur by initiating this method using the mode parameter.
     *
     * @param mode controlling which event will occur by calling this method:
     *            1 for feeding the animals.
     *            2 for washing the animals.
     */
    @Override
    public void notifyMsg(int mode) {
        for (IObserver observer : observers) {
            observer.update(this, mode);
        }
    }

}
