package fr.univtln.bruno.exemple.bibliotheque.exceptions.materiels;

/**
 * Created by bruno on 26/09/14.
 */
public class MaterielInconnuException extends Exception {
    public int matériel;

    public MaterielInconnuException(int matérielID) {
        super("Matériel " + matérielID + " inconnu.");
        this.matériel = matérielID;
    }
}
