package fr.univtln.bruno.coursjava.librarymanager.exceptions.materiels;

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
