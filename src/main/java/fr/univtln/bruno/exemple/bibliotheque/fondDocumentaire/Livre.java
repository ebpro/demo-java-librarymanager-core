package fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire;

import fr.univtln.bruno.exemple.bibliotheque.IBibliotheque;
import fr.univtln.bruno.exemple.bibliotheque.emprunts.ComportementEmpruntable;
import fr.univtln.bruno.exemple.bibliotheque.emprunts.Empruntable;
import fr.univtln.bruno.exemple.bibliotheque.IPersonne;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public class Livre extends Volume implements Empruntable, Serializable {

    private ComportementEmpruntable comportementEmpruntable = new ComportementEmpruntable();

    public static Livre getInstance(IBibliotheque bibliotheque, String ISBN, String titre, IPersonne auteur) {
        Livre livre = new Livre(bibliotheque, ISBN, titre, auteur);
        bibliotheque.add(livre);
        return livre;
    }

    private Livre(IBibliotheque bibliotheque, String ISBN, String titre, IPersonne auteur) {
        super(bibliotheque, ISBN, titre, auteur);
    }

    @Override
    public boolean isDisponible() {
        return comportementEmpruntable.isDisponible();
    }

    @Override
    public void estEmprunte(IBibliotheque.Adhérent emprunteur) {
        comportementEmpruntable.estEmprunte(this, emprunteur);
    }

    @Override
    public void estRendu() {
        comportementEmpruntable.estRendu(this);
    }

    @Override
    public String toString() {
        return "Livre{" + super.toString() +
                ", " + comportementEmpruntable +
                '}';
    }

}
