package fr.univtln.bruno.coursjava.librarymanager.emprunts;

import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;

/**
 * Created by bruno on 26/09/14.
 */
public interface Empruntable {
    public boolean isDisponible();

    public void estEmprunte(IBibliotheque.Adhérent adhérent);

    public void estRendu();
}
