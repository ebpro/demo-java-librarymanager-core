package fr.univtln.bruno.exemple.bibliotheque.personne;

import fr.univtln.bruno.exemple.bibliotheque.IPersonne;

import java.io.Serializable;

/**
 * Created by bruno on 26/09/14.
 */
public class Personne implements IPersonne, Serializable {
    public final IPersonne.Id ID; //ATTENTION la classe Id aussi doit être sérialisable.
    private String nom;
    private String prenom;

    public Personne(IPersonne.Id Id, String nom, String prenom) {
        this.ID = Id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne(String Id, String nom, String prenom) {
        this(new Personne.Id(Id), nom, prenom);
    }

    @Override
    public IPersonne.Id getId() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public static final class Id implements IPersonne.Id, Serializable {
        public final String EMAIL;

        public Id(String email) {
            this.EMAIL = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Id id = (Id) o;

            if (EMAIL != null ? !EMAIL.equals(id.EMAIL) : id.EMAIL != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return EMAIL != null ? EMAIL.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Id{" +
                    "EMAIL='" + EMAIL + '\'' +
                    '}';
        }

        @Override
        public int compareTo(IPersonne.Id id) {
            return EMAIL.compareTo(id.getEmail());
        }

        @Override
        public String getEmail() {
            return EMAIL;
        }
    }
}
