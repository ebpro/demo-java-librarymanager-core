package fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes;

import fr.univtln.bruno.exemple.bibliotheque.IPersonne;

/**
 * Created by bruno on 26/09/14.
 */
public class AdherentInconnuException extends Exception {
    public IPersonne.Id adhérent;

    public AdherentInconnuException(IPersonne.Id adhérent) {
        super("Adhérent " + adhérent + " inconnu.");
        this.adhérent = adhérent;
    }
}
