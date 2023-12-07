package FinalProjectStudent.api;

import FinalProjectStudent.api.IObserver;

/**
 * The {@code IObserverSystem} interface defines the common behavior expected from an observable system
 * that manages a collection of observers. Classes implementing this interface should provide concrete
 * implementations for attaching observers using {@link #attach(FinalProjectStudent.api.IObserver)}, detaching observers using
 * {@link #detach(FinalProjectStudent.api.IObserver)}, and notifying observers about events using {@link #notifyMsg(int)}.
 */
public interface IObserverSystem {

    /**
     * Attach an observer to the subject.
     *
     * @param observer The observer to be attached.
     */
    void attach(FinalProjectStudent.api.IObserver observer);

    /**
     * Detach an observer from the subject.
     *
     * @param observer The observer to be detached.
     */
    void detach(IObserver observer);

    /**
     * Notify all observers about an event.
     *
     * @param mode An integer representing the mode or type of the event.
     */
    void notifyMsg(int mode);

}
