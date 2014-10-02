package fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire;

import fr.univtln.bruno.exemple.bibliotheque.IBibliotheque;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public abstract class Revue extends Document implements Serializable {

    protected Revue(IBibliotheque bibliotheque, String ISBN, String titre) {
        super(bibliotheque, ISBN, titre);
    }
}
