package fr.univtln.bruno.exemple.bibliotheque.exceptions.documents;

/**
 * Created by bruno on 26/09/14.
 */
public class DocumentInconnuException extends Exception {
    public String documentID;

    public DocumentInconnuException(String documentID) {
        super("Document " + documentID + " inconnu.");
        this.documentID = documentID;
    }
}
