package fr.univtln.bruno.coursjava.librarymanager.fondDocumentaire;


import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;
import fr.univtln.bruno.coursjava.librarymanager.IPersonne;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public class Dictionnaire extends Volume implements Serializable {
    public Dictionnaire(IBibliotheque bibliotheque, String ISBN, String titre, IPersonne auteur) {
        super(bibliotheque, ISBN, titre, auteur);
    }


}
