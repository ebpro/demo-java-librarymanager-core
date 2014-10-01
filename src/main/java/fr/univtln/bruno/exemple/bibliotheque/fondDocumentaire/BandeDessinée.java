package fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire;

import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;
import fr.univtln.bruno.exemple.bibliotheque.personne.Personne;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public class BandeDessinée extends Volume implements Serializable{
    private String dessinateur;

    public String getDessinateur() {
        return dessinateur;
    }

    public void setDessinateur(String dessinateur) {
        this.dessinateur = dessinateur;
    }

    public BandeDessinée(Bibliotheque bibliotheque, String ISBN, String titre, Personne auteur, String dessinateur) {
        super(bibliotheque, ISBN, titre, auteur);
        this.dessinateur = dessinateur;
    }

    @Override
    public String toString() {
        return "BandeDessinée{" + super.toString() +
                "dessinateur='" + dessinateur + '\'' +
                '}';
    }
}
