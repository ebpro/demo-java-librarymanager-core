package fr.univtln.bruno.coursjava.librarymanager.exceptions.personnes;

import fr.univtln.bruno.coursjava.librarymanager.IPersonne;

/**
 * Created by bruno on 26/09/14.
 */
public class AuteurInconnuException extends Exception {
    public IPersonne.Id auteur;

    public AuteurInconnuException(IPersonne.Id auteur) {
        super("Auteur " + auteur + " inconnu.");
        this.auteur = auteur;
    }
}
