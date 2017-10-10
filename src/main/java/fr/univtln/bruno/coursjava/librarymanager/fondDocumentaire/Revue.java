package fr.univtln.bruno.coursjava.librarymanager.fondDocumentaire;

import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public abstract class Revue extends Document implements Serializable {

    protected Revue(IBibliotheque bibliotheque, String ISBN, String titre) {
        super(bibliotheque, ISBN, titre);
    }
}
