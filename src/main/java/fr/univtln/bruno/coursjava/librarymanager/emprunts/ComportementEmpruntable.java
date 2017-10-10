package fr.univtln.bruno.coursjava.librarymanager.emprunts;

import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public class ComportementEmpruntable implements Serializable {
    private IBibliotheque.Adhérent emprunteur = null;

    public boolean isDisponible() {
        return emprunteur == null;
    }

    public void estEmprunte(Empruntable empruntable, IBibliotheque.Adhérent emprunteur) {
        if (this.emprunteur == emprunteur) return;
        this.emprunteur = emprunteur;
    }

    public void estRendu(Empruntable empruntable) {
        this.emprunteur = null;
    }

    @Override
    public String toString() {
        return "isDisponible = " +
                isDisponible();
    }
}
