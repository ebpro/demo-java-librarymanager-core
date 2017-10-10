package fr.univtln.bruno.coursjava.librarymanager.exceptions.emprunts;


import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;
import fr.univtln.bruno.coursjava.librarymanager.emprunts.Empruntable;

/**
 * Created by bruno on 26/09/14.
 */
public class OrdinateurDejaEmprunteException extends EmpruntImpossibleException {
    public OrdinateurDejaEmprunteException(IBibliotheque.Adhérent adhérent, Empruntable empruntable) {
        super(adhérent, empruntable);
    }
}
