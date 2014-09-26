package fr.univtln.bruno.exemple.bibliotheque.exceptions.emprunts;

import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;
import fr.univtln.bruno.exemple.bibliotheque.emprunts.Empruntable;

/**
 * Created by bruno on 26/09/14.
 */
public class EmpruntImpossibleException extends Exception {
    public Bibliotheque.Adhérent adhérent;
    public Empruntable empruntable;

    public EmpruntImpossibleException(Bibliotheque.Adhérent adhérent, Empruntable empruntable) {
        super("Emprunt de " + empruntable + " par " + adhérent + " impossible.");
        this.adhérent = adhérent;
        this.empruntable = empruntable;
    }
}
