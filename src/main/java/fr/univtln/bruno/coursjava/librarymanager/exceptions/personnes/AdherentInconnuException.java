package fr.univtln.bruno.coursjava.librarymanager.exceptions.personnes;

import fr.univtln.bruno.coursjava.librarymanager.IPersonne;

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
