package fr.univtln.bruno.exemple.bibliotheque;

import fr.univtln.bruno.exemple.bibliotheque.emprunts.Empruntable;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.documents.DocumentInconnuException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.emprunts.EmpruntImpossibleException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.emprunts.NonEmpruntableException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.materiels.MaterielInconnuException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes.AdherentInconnuException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes.AuteurInconnuException;
import fr.univtln.bruno.exemple.bibliotheque.matériel.OrdinateurPortable;
import fr.univtln.bruno.exemple.bibliotheque.personne.Personne;

/**
 * Created by bruno on 26/09/14.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        Bibliotheque bibliothèque = null;

        //Initialisation de la bibliothèque
        try {
            bibliothèque = new Bibliotheque("Ma Bibliothèque")
                    .addAuteur(new Personne("marie.durand@test.fr", "marie", "durand"))
                    .addAuteur(new Personne("jean.martin@test.fr", "jean", "martin"))
                    .addAdhérent("pierre.dupond@test.fr", "pierre", "dupond", Bibliotheque.Adhérent.Statut.ENSEIGNANT)
                    .addAdhérent("marc.durand@test.fr", "marc", "durand", Bibliotheque.Adhérent.Statut.ETUDIANT)
                    .addOrdinateurPortable("Vaio", OrdinateurPortable.Os.LINUX)
                    .addOrdinateurPortable("Dell", OrdinateurPortable.Os.WINDOWS)
                    .addOrdinateurPortable("Macbook Pro", OrdinateurPortable.Os.MACOS)
                    .addLivre("123-XY", "Mon livre 1", "marie.durand@test.fr")
                    .addLivre("A", "Mon livre 1", "marie.durand@test.fr")
                    .addLivre("B", "Mon livre B", "marie.durand@test.fr")
                    .addLivre("C", "Mon livre C", "marie.durand@test.fr")
                    .addLivre("D", "Mon livre D", "marie.durand@test.fr");
        } catch (AuteurInconnuException e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        }

        System.out.println(bibliothèque);
        System.out.println();

        System.out.println("## Le Matériel ##");
        try {
            for (Integer id : bibliothèque.getMaterielIds())
                System.out.println(bibliothèque.getMatériel(id));
        } catch (MaterielInconnuException e) {
            e.printStackTrace();
        }

        System.out.println("## Les adhérents ##");
        try {
            for (Personne.Id id : bibliothèque.getAdherentsIds())
                System.out.println(bibliothèque.getAdhérent(id));
        } catch (AdherentInconnuException e) {
            e.printStackTrace();
        }

        System.out.println("## Les auteurs ##");
        try {
            for (Personne.Id id : bibliothèque.getAuteursIds())
                System.out.println(bibliothèque.getAuteur(id));
        } catch (AuteurInconnuException e) {
            e.printStackTrace();
        }

        /*
        Emprunt d'un ordinateur avec recherche explicite de l'adhérent et du PC.
        Chaque type d'exception est traitées séparément.
         */
        try {
            bibliothèque.emprunter(bibliothèque.getAdhérent("pierre.dupond@test.fr")
                    , (Empruntable) bibliothèque.getMatériel(1))
                    .emprunterLivre("pierre.dupond@test.fr", "123-XY");
        } catch (EmpruntImpossibleException e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        } catch (DocumentInconnuException e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        } catch (MaterielInconnuException e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        } catch (AdherentInconnuException e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        } catch (NonEmpruntableException e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        }

        Thread.sleep(500);

        System.out.println("## LA BIBLIOTHEQUE APRES EMPRUNT D'UN PC ET D'UN LIVRE ##");
        System.out.println(bibliothèque);
        System.out.println();

        Thread.sleep(500);

        System.out.println("## Emprunt d'un empruntable non disponible ##");
        try {
            bibliothèque.emprunterOrdinateur("pierre.dupond@test.fr", 1);
        } catch (Exception e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        }
        Thread.sleep(500);

        System.out.println("## Emprunt de trop de PC ##");
        try {
            bibliothèque.emprunterOrdinateur("pierre.dupond@test.fr", 0);
        } catch (Exception e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        }

        Thread.sleep(500);

        System.out.println("## Trop d'emprunts au total avec un pc ##");
        try {
            bibliothèque.emprunterLivre("pierre.dupond@test.fr", "A")
                    .emprunterLivre("pierre.dupond@test.fr", "B")
                    .emprunterLivre("pierre.dupond@test.fr", "C")
                    .emprunterLivre("pierre.dupond@test.fr", "D");
        } catch (Exception e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        }

        System.out.println(bibliothèque);

        System.out.println("## LA BIBLIOTHEQUE apres que le livre et le PC soient rendus ##");
        try {
            bibliothèque.rendreOrdinateur(1);
        } catch (Exception e) {
            System.err.println(e.getClass() + " : " +
                    e.getMessage());
        }
        System.out.println(bibliothèque);
    }

}