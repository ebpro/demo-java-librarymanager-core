package fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes;

import fr.univtln.bruno.exemple.bibliotheque.IPersonne;

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
