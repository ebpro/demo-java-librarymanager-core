package fr.univtln.bruno.coursjava.librarymanager.fondDocumentaire;


import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;
import fr.univtln.bruno.coursjava.librarymanager.IPersonne;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public abstract class Volume extends Document implements Serializable {
    private IPersonne auteur;

    public Volume(IBibliotheque bibliotheque, String ISBN, String titre, IPersonne auteur) {
        super(bibliotheque, ISBN, titre);
        this.auteur = auteur;
    }

    public IPersonne getAuteur() {
        return auteur;
    }

    public void setAuteur(IPersonne auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Volume{" + super.toString() +
                "Auteur=" + auteur +
                '}';
    }
}
