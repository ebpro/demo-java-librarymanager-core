package fr.univtln.bruno.coursjava.librarymanager.exceptions.sauvegarde;

/**
 * Created by bruno on 30/09/14.
 */
public class RestaurationException extends Exception {
    private Exception exception;

    public RestaurationException(Exception e) {
        exception = e;
    }

    public Exception getException() {
        return exception;
    }
}
