package fr.univtln.bruno.exemple.bibliotheque.emprunts;

import fr.univtln.bruno.exemple.bibliotheque.IBibliotheque;

/**
 * Created by bruno on 26/09/14.
 */
public interface Empruntable {
    public boolean isDisponible();

    public void estEmprunte(IBibliotheque.Adhérent adhérent);

    public void estRendu();
}
