package fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire;

import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;

/**
 * Created by bruno on 26/09/14.
 */
public abstract class Revue extends Document {

    protected Revue(Bibliotheque bibliotheque, String ISBN, String titre) {
        super(bibliotheque, ISBN, titre);
    }
}
