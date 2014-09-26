package fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes;

import fr.univtln.bruno.exemple.bibliotheque.personne.Personne;

/**
 * Created by bruno on 26/09/14.
 */
public class PersonneInconnueException extends Exception {
    public Personne personne;

    public PersonneInconnueException(Personne personne) {
        super("Personne " + personne + " inconnu.");
        this.personne = personne;
    }
}
