package fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire;

import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;
import fr.univtln.bruno.exemple.bibliotheque.personne.Personne;

/**
 * Created by bruno on 26/09/14.
 */
public class Dictionnaire extends Volume {
    public Dictionnaire(Bibliotheque bibliotheque, String ISBN, String titre, Personne auteur) {
        super(bibliotheque, ISBN, titre, auteur);
    }


}
