package fr.univtln.bruno.coursjava.librarymanager.exceptions.emprunts;


import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;
import fr.univtln.bruno.coursjava.librarymanager.emprunts.Empruntable;

/**
 * Created by bruno on 26/09/14.
 */
public class EmpruntableIndisponibleException extends EmpruntImpossibleException {
    public EmpruntableIndisponibleException(IBibliotheque.Adhérent adhérent, Empruntable empruntable) {
        super(adhérent, empruntable);
    }
}
