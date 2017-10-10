package fr.univtln.bruno.coursjava.librarymanager.fondDocumentaire;

import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;

import java.io.Serializable;
import java.util.logging.Logger;

public abstract class Document implements Serializable {
    private static final Logger logger = Logger.getLogger(Document.class.getName());
    public final String ISBN;
    private String titre;

    protected Document(IBibliotheque bibliotheque, String ISBN) {
        logger.info("Création du document \"" + ISBN + "\" et ajout à la bibliothèque \"" + bibliotheque.getNom() + "\"");
        this.ISBN = ISBN;
        bibliotheque.add(this);
    }

    protected Document(IBibliotheque bibliotheque, String ISBN, String titre) {
        this(bibliotheque, ISBN);
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Document{" +
                "titre='" + titre + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}