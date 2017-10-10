package fr.univtln.bruno.coursjava.librarymanager.fondDocumentaire;

import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;
import fr.univtln.bruno.coursjava.librarymanager.IPersonne;
import fr.univtln.bruno.coursjava.librarymanager.emprunts.ComportementEmpruntable;
import fr.univtln.bruno.coursjava.librarymanager.emprunts.Empruntable;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public class Livre extends Volume implements Empruntable, Serializable {

    private ComportementEmpruntable comportementEmpruntable = new ComportementEmpruntable();

    private Livre(IBibliotheque bibliotheque, String ISBN, String titre, IPersonne auteur) {
        super(bibliotheque, ISBN, titre, auteur);
    }

    public static Livre getInstance(IBibliotheque bibliotheque, String ISBN, String titre, IPersonne auteur) {
        Livre livre = new Livre(bibliotheque, ISBN, titre, auteur);
        bibliotheque.add(livre);
        return livre;
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
