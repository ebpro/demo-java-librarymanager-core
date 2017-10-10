package fr.univtln.bruno.coursjava.librarymanager;

/**
 * Created by bruno on 02/10/14.
 */
public interface IPersonne {
    public Id getId();

    public String getNom();

    public void setNom(String nom);

    public String getPrenom();

    public void setPrenom(String prenom);

    public interface Id extends Comparable<Id> {
        String getEmail();
    }
}
