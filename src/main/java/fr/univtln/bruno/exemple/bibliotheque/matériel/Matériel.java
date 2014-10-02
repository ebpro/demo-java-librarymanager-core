package fr.univtln.bruno.exemple.bibliotheque.matériel;

import fr.univtln.bruno.exemple.bibliotheque.IBibliotheque;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public abstract class Matériel implements Serializable {
    private static int nbItemMatériel = 0;
    public final int ID;

    public Matériel(IBibliotheque bibliotheque) {
        this.ID = nbItemMatériel++;
        bibliotheque.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Matériel matériel = (Matériel) o;
        if (ID != matériel.ID) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return ID;
    }
}
