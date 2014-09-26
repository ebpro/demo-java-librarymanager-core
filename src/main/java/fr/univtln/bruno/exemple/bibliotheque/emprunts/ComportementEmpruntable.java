package fr.univtln.bruno.exemple.bibliotheque.emprunts;


import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;

/**
 * Created by bruno on 26/09/14.
 */
public class ComportementEmpruntable {
    private Bibliotheque.Adhérent emprunteur = null;

    public boolean isDisponible() {
        return emprunteur == null;
    }

    public void estEmprunte(Empruntable empruntable, Bibliotheque.Adhérent emprunteur) {
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
