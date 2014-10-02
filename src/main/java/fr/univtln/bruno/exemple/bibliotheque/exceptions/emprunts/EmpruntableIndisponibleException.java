package fr.univtln.bruno.exemple.bibliotheque.exceptions.emprunts;

import fr.univtln.bruno.exemple.bibliotheque.IBibliotheque;
import fr.univtln.bruno.exemple.bibliotheque.emprunts.Empruntable;

/**
 * Created by bruno on 26/09/14.
 */
public class EmpruntableIndisponibleException extends EmpruntImpossibleException {
    public EmpruntableIndisponibleException(IBibliotheque.Adhérent adhérent, Empruntable empruntable) {
        super(adhérent, empruntable);
    }
}
