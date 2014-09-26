package fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes;

import fr.univtln.bruno.exemple.bibliotheque.personne.Personne;

/**
 * Created by bruno on 26/09/14.
 */
public class AuteurInconnuException extends Exception {
    public Personne.Id auteur;

    public AuteurInconnuException(Personne.Id auteur) {
        super("Auteur " + auteur + " inconnu.");
        this.auteur = auteur;
    }
}
