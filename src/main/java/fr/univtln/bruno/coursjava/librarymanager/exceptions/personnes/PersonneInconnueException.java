package fr.univtln.bruno.coursjava.librarymanager.exceptions.personnes;


import fr.univtln.bruno.coursjava.librarymanager.IPersonne;

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
