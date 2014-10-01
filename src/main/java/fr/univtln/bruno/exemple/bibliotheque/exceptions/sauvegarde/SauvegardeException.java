package fr.univtln.bruno.exemple.bibliotheque.exceptions.sauvegarde;

/**
 * Created by bruno on 30/09/14.
 */
public class SauvegardeException extends Exception {
    private Exception exception;

    public SauvegardeException(Exception e) {
        exception = e;
    }

    public Exception getException() {
        return exception;
    }
}
