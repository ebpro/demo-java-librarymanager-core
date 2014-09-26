package fr.univtln.bruno.exemple.bibliotheque.emprunts;

import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;

/**
 * Created by bruno on 26/09/14.
 */
public interface Empruntable {
    public boolean isDisponible();

    public void estEmprunte(Bibliotheque.Adhérent adhérent);

    public void estRendu();
}
