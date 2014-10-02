package fr.univtln.bruno.exemple.bibliotheque;

import fr.univtln.bruno.exemple.bibliotheque.emprunts.Empruntable;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.documents.DocumentInconnuException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.emprunts.EmpruntImpossibleException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.emprunts.NonEmpruntableException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.emprunts.RestitutionException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.materiels.MaterielInconnuException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes.AdherentInconnuException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes.AuteurInconnuException;
import fr.univtln.bruno.exemple.bibliotheque.exceptions.sauvegarde.SauvegardeException;
import fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire.Document;
import fr.univtln.bruno.exemple.bibliotheque.matériel.Matériel;
import fr.univtln.bruno.exemple.bibliotheque.matériel.OrdinateurPortable;

import java.io.OutputStream;
import java.util.Collection;
import java.util.Set;

/**
 * La classe Bibliothèque est une facade pour la gestion complète d'une bibliothèque. Elle permet de créer des ressources (Documents, Adhérents, Matériel)
 * et les emprunts.
 */
public interface IBibliotheque {

    /**
     * retourne la collection des matériels de la bibliothèque
     *
     * @return
     */
    public Collection<Matériel> getMatériels();

    /**
     * retourne la collection des adhérents de la bibliothèque
     *
     * @return
     */
    public Collection<Adhérent> getAdhérents();

    /**
     * retourne la liste des documents de la bibliothèque
     *
     * @return
     */
    public Collection<Document> getDocuments();

    /**
     * Ajoute une personne aux auteurs.
     *
     * @param auteur
     * @return
     */
    public IBibliotheque addAuteur(IPersonne auteur);

    /**
     * Retourne un auteur correspondant à un id.
     *
     * @param auteurId
     * @return
     * @throws fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes.AuteurInconnuException
     */
    public IPersonne getAuteur(String auteurId) throws AuteurInconnuException;

    /**
     * @return L'ensemble des Ids des auteurs.
     */
    public Set<IPersonne.Id> getAuteursIds();

    public IBibliotheque setNom(String nom);


    /**
     * @return L'ensemble des Id des matériels.
     */
    public Set<Integer> getMaterielIds();

    /**
     * Retourne un auteur correspondant à un id sous forme de String.
     *
     * @param auteurId
     * @return
     * @throws fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes.AuteurInconnuException
     */
    public IPersonne getAuteur(IPersonne.Id auteurId) throws AuteurInconnuException;

    /**
     * Ajoute un nouveau matériel à la bibliothèque
     *
     * @param matériel
     * @return
     */
    public IBibliotheque add(Matériel matériel);

    /**
     * Supprime un matériel de la bibliothèque
     *
     * @param matériel
     * @return
     */
    public IBibliotheque remove(Matériel matériel);

    /**
     * Ajoute un Document à la bibliothèque
     *
     * @param document
     * @return
     */
    public IBibliotheque add(Document document);

    /**
     * Supprime un document de la bibliothèque
     *
     * @param document
     * @return
     */
    public IBibliotheque remove(Document document);

    /**
     * Ajoute un adhérent à la bibliothèque
     *
     * @param adhérent
     * @return
     */
    public IBibliotheque add(Adhérent adhérent);

    /**
     * Supprime un adhérent de la bibliothèque
     *
     * @param adhérent
     * @return
     */
    public IBibliotheque remove(Adhérent adhérent);

    /**
     * Retourne le nom de la bibliothèque
     *
     * @return
     */
    public String getNom();

    /**
     * Créée un adhérent et l'ajoute à la bibliothèque. C'est une facade de Adhérent.
     *
     * @param email
     * @param prenom
     * @param nom
     * @param statut
     * @return
     */
    public IBibliotheque addAdhérent(String email, String prenom, String nom, Adhérent.Statut statut);

    /**
     * Créée un ordinateur portable et l'ajoute à la bibliothèque. C'est une facade de Ordinateur portable.
     *
     * @param marque
     * @param os
     * @return
     */
    public IBibliotheque addOrdinateurPortable(String marque, OrdinateurPortable.Os os);

    /**
     * Créée un Livre et l'ajoute à la bibliothèque. C'est une facade de Livre.
     *
     * @param isbn
     * @param titre
     * @param auteur
     * @return
     */
    public IBibliotheque addLivre(String isbn, String titre, String auteur) throws AuteurInconnuException;

    /**
     * Créée un Livre et l'ajoute à la bibliothèque. C'est une facade de Livre.
     *
     * @param isbn
     * @param titre
     * @param auteur
     * @return
     */
    public IBibliotheque addLivre(String isbn, String titre, IPersonne auteur);

    /**
     * retourne un document correspondant à un ISBN.
     *
     * @param isbn
     * @return
     * @throws fr.univtln.bruno.exemple.bibliotheque.exceptions.documents.DocumentInconnuException
     */
    public Document getDocument(String isbn) throws DocumentInconnuException;

    /**
     * Retourne un matériel correspondant à un id.
     *
     * @param id
     * @return
     * @throws fr.univtln.bruno.exemple.bibliotheque.exceptions.materiels.MaterielInconnuException
     */
    public Matériel getMatériel(int id) throws MaterielInconnuException;

    /**
     * Retourne un adherent correspondant à un id de personne.
     *
     * @param id
     * @return
     * @throws fr.univtln.bruno.exemple.bibliotheque.exceptions.personnes.AdherentInconnuException
     */
    public Adhérent getAdhérent(IPersonne.Id id) throws AdherentInconnuException;

    public Adhérent getAdhérent(String email) throws AdherentInconnuException;

    /**
     * @return L'ensemble des Ids des adhérents
     */
    public Set<IPersonne.Id> getAdherentsIds();

    public IBibliotheque rendreOrdinateur(int id) throws MaterielInconnuException, NonEmpruntableException;

    public IBibliotheque rendreLivre(String isbn) throws DocumentInconnuException, NonEmpruntableException;

    public IBibliotheque rendre(Empruntable empruntable);

    public IBibliotheque emprunterOrdinateur(String emprunteur, int id) throws MaterielInconnuException, NonEmpruntableException, AdherentInconnuException, EmpruntImpossibleException, DocumentInconnuException;


    public IBibliotheque emprunterLivre(String emprunteur, String isbn) throws MaterielInconnuException, NonEmpruntableException, AdherentInconnuException, EmpruntImpossibleException, DocumentInconnuException;

    public IBibliotheque emprunter(Adhérent emprunteur, Empruntable empruntable) throws MaterielInconnuException,
            AdherentInconnuException, NonEmpruntableException, EmpruntImpossibleException;

    /**
     * Serialise la bibliotheque dans un fichier.
     *
     * @param filename Le nom du fichier dans lequel sera serialisée la bibliotheque
     * @throws fr.univtln.bruno.exemple.bibliotheque.exceptions.sauvegarde.SauvegardeException
     */
    public void exporter(String filename) throws SauvegardeException;

    /**
     * Serialise la bibliotheque dans un flux.
     *
     * @param outputStream le flux de destination
     * @throws fr.univtln.bruno.exemple.bibliotheque.exceptions.sauvegarde.SauvegardeException
     */
    public void exporter(OutputStream outputStream) throws SauvegardeException;

    public interface Adhérent extends IPersonne {

        public Adhérent emprunter(Empruntable empruntable) throws EmpruntImpossibleException;

        public Adhérent rendre(Empruntable empruntable) throws RestitutionException;

        public Set<Empruntable> getEmprunts();

        public enum Statut {ETUDIANT, ENSEIGNANT}



    }

}
