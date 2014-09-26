package fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes;

import fr.univtln.bruno.exemple.bibliotheque.personne.Personne;

/**
 * Created by bruno on 26/09/14.
 */
public class AdherentInconnuException extends Exception {
    public Personne.Id adhérent;

    public AdherentInconnuException(Personne.Id adhérent) {
        super("Adhérent " + adhérent + " inconnu.");
        this.adhérent = adhérent;
    }
}
