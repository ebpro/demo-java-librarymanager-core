package fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire;

import fr.univtln.bruno.exemple.bibliotheque.IBibliotheque;
import fr.univtln.bruno.exemple.bibliotheque.IPersonne;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public class Dictionnaire extends Volume implements Serializable {
    public Dictionnaire(IBibliotheque bibliotheque, String ISBN, String titre, IPersonne auteur) {
        super(bibliotheque, ISBN, titre, auteur);
    }


}
