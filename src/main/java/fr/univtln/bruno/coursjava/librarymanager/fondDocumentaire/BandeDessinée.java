package fr.univtln.bruno.coursjava.librarymanager.fondDocumentaire;


import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;
import fr.univtln.bruno.coursjava.librarymanager.IPersonne;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public class BandeDessinée extends Volume implements Serializable {
    private String dessinateur;

    public BandeDessinée(IBibliotheque bibliotheque, String ISBN, String titre, IPersonne auteur, String dessinateur) {
        super(bibliotheque, ISBN, titre, auteur);
        this.dessinateur = dessinateur;
    }

    public String getDessinateur() {
        return dessinateur;
    }

    public void setDessinateur(String dessinateur) {
        this.dessinateur = dessinateur;
    }

    @Override
    public String toString() {
        return "BandeDessinée{" + super.toString() +
                "dessinateur='" + dessinateur + '\'' +
                '}';
    }
}
