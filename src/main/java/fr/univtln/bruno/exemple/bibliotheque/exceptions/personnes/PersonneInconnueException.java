package fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes;

import fr.univtln.bruno.exemple.bibliotheque.IPersonne;

/**
 * Created by bruno on 26/09/14.
 */
public class PersonneInconnueException extends Exception {
    public IPersonne personne;

    public PersonneInconnueException(IPersonne personne) {
        super("Personne " + personne + " inconnu.");
        this.personne = personne;
    }
}
