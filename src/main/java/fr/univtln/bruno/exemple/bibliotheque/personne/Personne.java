package fr.univtln.bruno.exemple.bibliotheque.personne;

/**
 * Created by bruno on 26/09/14.
 */
public class Personne {
    public final Id ID;
    private String nom;
    private String prenom;

    public Personne(Id Id, String nom, String prenom) {
        this.ID = Id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne(String Id, String nom, String prenom) {
        this(new Personne.Id(Id), nom, prenom);
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

    public static final class Id implements Comparable<Personne.Id> {
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
        public int compareTo(Personne.Id id) {
            return EMAIL.compareTo(id.EMAIL);
        }
    }
}
