package fr.univtln.bruno.exemple.bibliotheque.exceptions.sauvegarde;

import java.io.IOException;

/**
 * Created by bruno on 30/09/14.
 */
public class RestaurationException extends Exception{
    private Exception exception;

    public Exception getException() {
        return exception;
    }

    public RestaurationException(Exception e) {
        exception = e;
    }
}
