package fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire;

import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;
import fr.univtln.bruno.exemple.bibliotheque.personne.Personne;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public abstract class Volume extends Document implements Serializable {
    private Personne auteur;

    public Personne getAuteur() {
        return auteur;
    }

    public void setAuteur(Personne auteur) {
        this.auteur = auteur;
    }

    public Volume(Bibliotheque bibliotheque, String ISBN, String titre, Personne auteur) {
        super(bibliotheque, ISBN, titre);
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Volume{" + super.toString() +
                "Auteur=" + auteur +
                '}';
    }
}
