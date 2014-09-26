package fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire;

import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;

import java.util.logging.Logger;

public abstract class Document {
    private static final Logger logger = Logger.getLogger(Document.class.getName());

    private String titre;
    public final String ISBN;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    protected Document(Bibliotheque bibliotheque, String ISBN) {
        logger.info("Création du document \""+ISBN+"\" et ajout à la bibliothèque \""+bibliotheque.getNom()+"\"");
        this.ISBN = ISBN;
        bibliotheque.add(this);
    }

    protected Document(Bibliotheque bibliotheque, String ISBN, String titre) {
        this(bibliotheque, ISBN);
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