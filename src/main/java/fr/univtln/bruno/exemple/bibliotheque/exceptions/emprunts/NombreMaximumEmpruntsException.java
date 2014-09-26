package fr.univtln.bruno.exemple.bibliotheque.exceptions.emprunts;

import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;
import fr.univtln.bruno.exemple.bibliotheque.emprunts.Empruntable;

/**
 * Created by bruno on 26/09/14.
 */
public class NombreMaximumEmpruntsException extends EmpruntImpossibleException {
    public NombreMaximumEmpruntsException(Bibliotheque.Adhérent adhérent, Empruntable empruntable) {
        super(adhérent, empruntable);
    }
}
